package org.randoomz.demo.fragments.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

import com.siteduzero.android.R;

public class CustomAlertDialog extends DialogFragment {
	private static final String KEY_TITLE = "title";

	private NoticeHostComponent mListener;

	public static CustomAlertDialog newInstance(int title) {
		CustomAlertDialog fragment = new CustomAlertDialog();
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
		final LayoutInflater inflater = getActivity().getLayoutInflater();

		final Builder builder = new AlertDialog.Builder(getActivity());
		builder.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle(title)
				.setView(inflater.inflate(R.layout.fragment_dialog, null))
				.setPositiveButton(android.R.string.ok, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
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
						});

		// Set other dialog properties...

		return builder.create();
	}
}
