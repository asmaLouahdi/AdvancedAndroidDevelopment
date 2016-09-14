package com.siteduzero.android.fragments.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siteduzero.android.R;

public class MyDialogFragment extends DialogFragment {
	private static final String KEY_TITLE = "title";

	public static MyDialogFragment newInstance(int title) {
		MyDialogFragment dialog = new MyDialogFragment();
		Bundle args = new Bundle();
		args.putInt(KEY_TITLE, title);
		dialog.setArguments(args);
		return dialog;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_dialog, container, false);

		getDialog().setTitle(getArguments().getInt(KEY_TITLE));

		return v;
	}
}
