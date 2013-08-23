package com.siteduzero.android.settings;

import java.util.List;

import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.siteduzero.android.R;

public class SettingsActivity extends PreferenceActivity {
	private static final String ACTION_PREF_EDIT = "com.siteduzero.android.settings.EDIT";
	private static final String ACTION_PREF_AGENDA = "com.siteduzero.android.settings.AGENDA";

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Preferences for Android 2.3 and lower.
		final String settings = getIntent().getAction();
		// Show screen if a preference if header send an
		if (ACTION_PREF_EDIT.equals(settings)) {
			addPreferencesFromResource(R.xml.settings_edit);
		} else if (ACTION_PREF_AGENDA.equals(settings)) {
			addPreferencesFromResource(R.xml.settings_agenda);
		} else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
			// Show header if there aren't intent.
			addPreferencesFromResource(R.xml.settings_headers_legacy);
		}
	}

	// This methods is called with Android 3.0 and higher.
	@Override
	public void onBuildHeaders(List<Header> target) {
		loadHeadersFromResource(R.xml.settings_headers, target);
	}
}
