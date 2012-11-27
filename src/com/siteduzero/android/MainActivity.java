package com.siteduzero.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.siteduzero.android.samples.SamplesListActivity;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void goToSamples(View v) {
		startActivity(new Intent(this, SamplesListActivity.class));
	}

	public void goToSdZ(View v) {
		Intent i = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse("http://www.siteduzero.com/tutoriel-3-704884-1-aller-plus-loin-dans-le-developpement-android.html"));
		startActivity(i);
	}

	public void goToSourceCodes(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW,
				Uri.parse("https://github.com/AndroWiiid/SdZAndroid"));
		startActivity(i);
	}
}
