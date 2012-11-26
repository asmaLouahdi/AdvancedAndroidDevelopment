package com.siteduzero.android.settings;

import java.util.List;

import android.preference.PreferenceActivity;

import com.siteduzero.android.R;

public class SettingsActivity extends PreferenceActivity {
	@Override
	public void onBuildHeaders(List<Header> target) {
		loadHeadersFromResource(R.xml.header_preferences, target);
	}
}
