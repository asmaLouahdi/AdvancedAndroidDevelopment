package com.siteduzero.android.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.siteduzero.android.R;

public class DialogActivity extends FragmentActivity {
	public static final int TYPE_DIALOG_FRAGMENT = 1;
	public static final int TYPE_ALERT_DIALOG = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
	}

	protected void showDialogType(int type) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
		if (prev != null) {
			ft.remove(prev);
		}
		ft.addToBackStack(null);

		DialogFragment newFragment = null;
		switch (type) {
		case TYPE_DIALOG_FRAGMENT:
			newFragment = MyDialogFragment
					.newInstance(R.string.btn_launch_dialog);
			break;
		case TYPE_ALERT_DIALOG:
			newFragment = MyAlertDialog
					.newInstance(R.string.btn_launch_alert);
			break;
		}
		newFragment.show(ft, "dialog");
	}

	public void showDialogFragment(View v) {
		showDialogType(TYPE_DIALOG_FRAGMENT);
	}

	public void showAlertDialog(View v) {
		showDialogType(TYPE_ALERT_DIALOG);
	}

	public void doPositiveClick() {
		// TODO Do something
	}

	public void doNegativeClick() {
		// TODO Do something
	}
}
