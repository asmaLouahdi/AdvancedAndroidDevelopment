package com.siteduzero.android.fragments.dynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siteduzero.android.R;

public class Dynamic2Fragment extends Fragment {
	public static final String TAG = "Dynamic2Fragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_dynamic_2, container, false);
	}
}
