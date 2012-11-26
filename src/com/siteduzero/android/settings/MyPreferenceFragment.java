package com.siteduzero.android.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.siteduzero.android.R;

public class MyPreferenceFragment extends PreferenceFragment {
	public static final String TAG = "MyPreferenceFragment";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.preferences);
	}
}
