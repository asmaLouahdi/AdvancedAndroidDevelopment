package com.siteduzero.android.services.plus;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.model.people.Person;
import com.siteduzero.android.R;

public class SignInActivity extends Activity {
	private static final int REQUEST_CODE_SIGN_IN = 42;
	private PlusClient mPlusClient;
	private ConnectionResult mConnectionResult;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		mPlusClient = new PlusClient.Builder(this,
				mGooglePlusConnectionCallbacks,
				mGooglePlusOnConnectionFailedListener).setActions(
				"http://schemas.google.com/AddActivity",
				"http://schemas.google.com/BuyActivity").build();
		findViewById(R.id.sign_in_button).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						googlePlusSignInClick();
					}
				});
	}

	@Override
	public void onStart() {
		super.onStart();
		mPlusClient.connect();
	}

	@Override
	public void onStop() {
		mPlusClient.disconnect();
		super.onStop();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE_SIGN_IN) {
			if (resultCode == RESULT_OK && !mPlusClient.isConnected()
					&& !mPlusClient.isConnecting()) {
				mConnectionResult = null;
				// This time, connect should succeed.
				mPlusClient.connect();
			}
		}
	}

	private void googlePlusSignInClick() {
		try {
			if (mConnectionResult != null) {
				mConnectionResult.startResolutionForResult(SignInActivity.this,
						REQUEST_CODE_SIGN_IN);
			} else {
				Toast.makeText(this, "Error connection with Google Plus",
						Toast.LENGTH_SHORT).show();
			}
		} catch (SendIntentException e) {
			mPlusClient.connect();
		}
	}

	private final ConnectionCallbacks mGooglePlusConnectionCallbacks = new ConnectionCallbacks() {

		public void onDisconnected() {
			// User is disconnected.
		}

		public void onConnected(Bundle connectionHint) {
			final Person person = mPlusClient.getCurrentPerson();
			final String displayName = person.getDisplayName();
			Toast.makeText(SignInActivity.this, "Welcome " + displayName,
					Toast.LENGTH_SHORT).show();
		}
	};

	private final OnConnectionFailedListener mGooglePlusOnConnectionFailedListener = new OnConnectionFailedListener() {

		public void onConnectionFailed(ConnectionResult result) {
			mConnectionResult = result;
		}
	};
}
