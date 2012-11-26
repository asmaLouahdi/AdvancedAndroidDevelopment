package com.siteduzero.android.dialog.alert;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.siteduzero.android.R;
import com.siteduzero.android.dialog.DialogActivity;

public class MyAlertDialog extends DialogFragment {
	public static MyAlertDialog newInstance(int title) {
		MyAlertDialog frag = new MyAlertDialog();
		Bundle args = new Bundle();
		args.putInt("title", title);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		int title = getArguments().getInt("title");

		return new AlertDialog.Builder(getActivity())
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle(title)
				.setNegativeButton(R.string.alert_dialog_cancel,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								((DialogActivity) getActivity())
										.doNegativeClick();
							}
						})
				.setPositiveButton(R.string.alert_dialog_ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								((DialogActivity) getActivity())
										.doPositiveClick();
							}
						}).create();
	}
}
