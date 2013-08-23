package com.siteduzero.android.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.siteduzero.android.R;

public class SettingsFragment extends PreferenceFragment {
	private static final String KEY_SETTINGS = "settings";
	private static final String HEADER_EDIT = "header_edit";
	private static final String HEADER_AGENDA = "header_agenda";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final String settings = getArguments().getString(KEY_SETTINGS);
		if (HEADER_EDIT.equals(settings)) {
			addPreferencesFromResource(R.xml.settings_edit);
		} else if (HEADER_AGENDA.equals(settings)) {
			addPreferencesFromResource(R.xml.settings_agenda);
		}
	}
}
