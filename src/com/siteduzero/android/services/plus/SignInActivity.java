package com.siteduzero.android.services.plus;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.plus.PlusClient;
import com.siteduzero.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class SignInActivity extends Activity implements OnClickListener,
		OnConnectionFailedListener, ConnectionCallbacks {
	private PlusClient mPlusClient;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		mPlusClient = new PlusClient.Builder(this, this, this)
				.setVisibleActivities("http://schemas.google.com/AddActivity",
						"http://schemas.google.com/BuyActivity").build();
		findViewById(R.id.sign_in_button).setOnClickListener(this);
	}

	@Override
	public void onStop() {
		super.onDestroy();
		if (mPlusClient.isConnected()) {
			mPlusClient.disconnect();
		}
	}

	@Override
	public void onConnected() {
		// Nothing to do.
		Log.v("com.siteduzero.android", "" + mPlusClient.getAccountName());
	}

	@Override
	public void onDisconnected() {
		// Nothing to do.
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// Nothing to do.
	}

	@Override
	public void onClick(View v) {
		if (!mPlusClient.isConnected()) {
			mPlusClient.connect();
		}
	}
}
