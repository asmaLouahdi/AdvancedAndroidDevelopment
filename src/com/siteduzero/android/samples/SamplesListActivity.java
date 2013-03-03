package com.siteduzero.android.samples;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.siteduzero.android.R;

public class SamplesListActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_samples);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_github:
			goToSourceCodes();
			return true;
		case R.id.menu_sdz:
			goToSdZ();
			return true;
		case R.id.menu_randoomz:
			goToRandoomz();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void goToSdZ() {
		Intent i = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse("http://www.siteduzero.com/tutoriel-3-746284-aller-plus-loin-dans-le-developpement-android.html"));
		startActivity(i);
	}

	private void goToSourceCodes() {
		Intent i = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse("https://github.com/AndroWiiid/AdvancedAndroidDevelopment"));
		startActivity(i);
	}

	private void goToRandoomz() {
		Intent i = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse("http://www.randoomz.org/category/programmation/tutoriels-android/"));
		startActivity(i);
	}
}
