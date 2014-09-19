package com.siteduzero.android.settings;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.siteduzero.android.R;

import java.util.List;

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
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
	public void onBuildHeaders(List<Header> target) {
		loadHeadersFromResource(R.xml.settings_headers, target);
	}

    @Override
    protected boolean isValidFragment(String fragmentName) {
        if (SettingsFragment.class.getName().equals(fragmentName)) {
            return true;
        }
        return false;
    }
}
