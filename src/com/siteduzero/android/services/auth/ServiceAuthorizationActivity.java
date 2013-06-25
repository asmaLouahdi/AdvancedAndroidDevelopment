package com.siteduzero.android.services.auth;

import java.io.IOException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.siteduzero.android.R;

public class ServiceAuthorizationActivity extends Activity {
	private static final String TAG = "com.siteduzero.android.services.auth";
	private static final int REQUEST_AUTHORIZATION = 42;
	private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.profile";

	private TextView mTextViewName;
	private TextView mTextViewGender;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authorization);

		mTextViewName = (TextView) findViewById(R.id.textViewName);
		mTextViewGender = (TextView) findViewById(R.id.textViewGender);

		if (getIntent() != null) {
			final String account = getIntent().getExtras().getString("ACCOUNT");
			new AuthorizationAsyncTask(this).execute(account);
		}
	}

	private static class AuthorizationAsyncTask extends
			AsyncTask<String, Void, UserInformation> {
		private final ServiceAuthorizationActivity mActivity;
		private final AuthorizationManager mAuthorizationManager;

		public AuthorizationAsyncTask(
				final ServiceAuthorizationActivity activity) {
			mActivity = activity;
			mAuthorizationManager = new AuthorizationManager(activity);
		}

		@Override
		protected UserInformation doInBackground(String... params) {
			final String account = params[0];
			try {
				final String token = GoogleAuthUtil.getToken(mActivity,
						account, SCOPE);
				return mAuthorizationManager.downloadUserInformation(token);
			} catch (UserRecoverableAuthException e) {
				Log.v(TAG,
						"[UserRecoverableAuthException] message : "
								+ e.getMessage());
				mActivity.startActivityForResult(e.getIntent(),
						REQUEST_AUTHORIZATION);
			} catch (IOException e) {
				Log.v(TAG, "[IOException] message : " + e.getMessage());
			} catch (GoogleAuthException e) {
				Log.v(TAG, "[GoogleAuthException] message : " + e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPostExecute(UserInformation result) {
			super.onPostExecute(result);
			if (result != null) {
				mActivity.mTextViewName.setText(result.getName());
				mActivity.mTextViewGender.setText(result.getGender());
			}
		}
	}
}
