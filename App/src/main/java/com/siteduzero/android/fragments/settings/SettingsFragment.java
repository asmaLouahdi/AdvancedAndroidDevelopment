package com.siteduzero.android.fragments.settings;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import com.siteduzero.android.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
	private static final String KEY_SETTINGS = "settings";
	private static final String HEADER_EDIT = "header_edit";
	private static final String HEADER_AGENDA = "header_agenda";
	private static final String KEY_PREF_1 = "pref_key_pref_1";
	private static final String KEY_PREF_2 = "pref_key_pref_2";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Show right preference due to arguments in the fragment.
		final String settings = getArguments().getString(KEY_SETTINGS);
		if (HEADER_EDIT.equals(settings)) {
			addPreferencesFromResource(R.xml.settings_edit);
		} else if (HEADER_AGENDA.equals(settings)) {
			addPreferencesFromResource(R.xml.settings_agenda);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		PreferenceManager.getDefaultSharedPreferences(getActivity())
				.registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		PreferenceManager.getDefaultSharedPreferences(getActivity())
				.unregisterOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		if (KEY_PREF_1.equals(key)) {
			final Preference preference = findPreference(KEY_PREF_2);
			preference.setSummary(R.string.change_settings);
		}
	}
}
