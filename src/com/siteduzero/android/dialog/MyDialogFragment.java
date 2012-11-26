package com.siteduzero.android.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.siteduzero.android.R;

public class MyDialogFragment extends DialogFragment {
	public static MyDialogFragment newInstance(int title) {
		MyDialogFragment dialog = new MyDialogFragment();
		Bundle args = new Bundle();
		args.putInt("title", title);
		dialog.setArguments(args);
		return dialog;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_dialog, container, false);

		Button button = (Button) v.findViewById(R.id.buttonShow);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				((DialogActivity) getActivity())
						.showDialogType(DialogActivity.TYPE_ALERT_DIALOG);
			}
		});

		getDialog().setTitle(getArguments().getInt("title"));

		return v;
	}
}
