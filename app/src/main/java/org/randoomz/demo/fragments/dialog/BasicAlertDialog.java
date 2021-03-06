package org.randoomz.demo.fragments.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import org.randoomz.demo.R;

public class BasicAlertDialog extends DialogFragment {
	private static final String KEY_TITLE = "title";

	private NoticeHostComponent mListener;

	public static BasicAlertDialog newInstance(int title) {
		BasicAlertDialog fragment = new BasicAlertDialog();
		Bundle args = new Bundle();
		args.putInt(KEY_TITLE, title);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (NoticeHostComponent) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeHostComponent");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final int title = getArguments().getInt(KEY_TITLE);

		final Builder builder = new AlertDialog.Builder(getActivity());
		builder.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle(title)
				.setMessage(R.string.text_alert)
				.setPositiveButton(R.string.alert_dialog_ok,
						new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								mListener.onPositiveClick();
							}
						})
				.setNegativeButton(R.string.alert_dialog_cancel,
						new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								mListener.onNegativeClick();
							}
						})
				.setNeutralButton(R.string.alert_dialog_neutral,
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								mListener.onNeutralClick();
							}
						});

		// Set other dialog properties...

		return builder.create();
	}
}
