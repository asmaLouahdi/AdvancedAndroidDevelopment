package com.siteduzero.android.requests.security;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.siteduzero.android.R;
import com.siteduzero.android.utils.Utils;

public class RegisterFragment extends Fragment implements
		LoaderManager.LoaderCallbacks<String> {
	private static final int ID_LOADER_REGISTER = 0;
	private static final String KEY_EMAIL = "email";
	private static final String KEY_PASSWORD = "password";

	// GUI
	private EditText mEmail;
	private EditText mPassword;
	private EditText mConfirmPassword;
	private Button mRegister;
	private Button mTwitterConnect;
	private Button mGooglePlusConnect;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_register, container, false);
		mTwitterConnect = (Button) v.findViewById(R.id.button_twitter_connect);
		mGooglePlusConnect = (Button) v
				.findViewById(R.id.button_google_plus_connect);

		mEmail = (EditText) v.findViewById(R.id.edit_text_email);
		mPassword = (EditText) v.findViewById(R.id.edit_text_password);
		mConfirmPassword = (EditText) v
				.findViewById(R.id.edit_text_confirm_pass);
		mRegister = (Button) v.findViewById(R.id.button_register);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mRegister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				clickRegister();
			}
		});
		mTwitterConnect.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Login with Twitter account.",
						Toast.LENGTH_SHORT).show();
			}
		});
		mGooglePlusConnect.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(),
						"Login with Google Plus account.", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}

	private void clickRegister() {
		final String email = mEmail.getText().toString();
		final String password = mPassword.getText().toString();
		final String confirmPassword = mConfirmPassword.getText().toString();
		if (Utils.checkString(email)) {
			Toast.makeText(getActivity(), "You must specify an email.",
					Toast.LENGTH_SHORT).show();
			return;
		}
		if (Utils.checkString(password)) {
			Toast.makeText(getActivity(), "You must specify a password.",
					Toast.LENGTH_SHORT).show();
			return;
		}
		if (Utils.checkString(confirmPassword)) {
			Toast.makeText(getActivity(),
					"You must specify a confirm password.", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		if (!password.equals(confirmPassword)) {
			Toast.makeText(getActivity(),
					"Password didn't match with confirmation.",
					Toast.LENGTH_SHORT).show();
			return;
		}
		final Bundle bundle = new Bundle();
		bundle.putString(KEY_EMAIL, email);
		bundle.putString(KEY_PASSWORD, password);
		getLoaderManager().initLoader(ID_LOADER_REGISTER, bundle, this);
	}

	@Override
	public Loader<String> onCreateLoader(int id, Bundle bundle) {
		final String email = bundle.getString(KEY_EMAIL);
		final String password = bundle.getString(KEY_PASSWORD);
		return new RegisterAsyncTaskLoader(getActivity(), email, password);
	}

	@Override
	public void onLoadFinished(Loader<String> loader, String data) {
		if (data != null && !data.isEmpty()) {
			Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
			SessionStore.saveAccessToken(data, getActivity());
		}
	}

	@Override
	public void onLoaderReset(Loader<String> arg0) {
		// Nothing to do here.
	}
}
