package com.siteduzero.android.fragments.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.siteduzero.android.R;

public class ListAlertDialog extends DialogFragment {
	private static final String KEY_TITLE = "title";

	public static ListAlertDialog newInstance(int title) {
		ListAlertDialog fragment = new ListAlertDialog();
		Bundle args = new Bundle();
		args.putInt(KEY_TITLE, title);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final int title = getArguments().getInt(KEY_TITLE);
		final Builder builder = new AlertDialog.Builder(getActivity());

		builder.setTitle(title).setItems(R.array.array_mario,
				new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Do something
					}
				});

		return builder.create();
	}
}
