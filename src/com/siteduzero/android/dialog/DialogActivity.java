package com.siteduzero.android.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.siteduzero.android.R;

public class DialogActivity extends FragmentActivity implements
		NoticeHostComponent {
	private static final String KEY_DIALOG = "dialog";
	private static final int TYPE_DIALOG_FRAGMENT = 1;
	private static final int TYPE_BASIC_ALERT_DIALOG = 2;
	private static final int TYPE_LIST_ALERT_DIALOG = 3;
	private static final int TYPE_MULTI_ALERT_DIALOG = 4;
	private static final int TYPE_CUSTOM_ALERT_DIALOG = 5;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
	}

	public void showDialogFragment(View v) {
		showDialogType(TYPE_DIALOG_FRAGMENT);
	}

	public void showBasicAlertDialog(View v) {
		showDialogType(TYPE_BASIC_ALERT_DIALOG);
	}

	public void showListAlertDialog(View v) {
		showDialogType(TYPE_LIST_ALERT_DIALOG);
	}

	public void showMultiAlertDialog(View v) {
		showDialogType(TYPE_MULTI_ALERT_DIALOG);
	}

	public void showCustomAlertDialog(View v) {
		showDialogType(TYPE_CUSTOM_ALERT_DIALOG);
	}

	private void showDialogType(int type) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment prev = getSupportFragmentManager().findFragmentByTag(KEY_DIALOG);
		if (prev != null) {
			ft.remove(prev);
		}
		ft.addToBackStack(null);

		DialogFragment newFragment = null;
		switch (type) {
		case TYPE_DIALOG_FRAGMENT:
			newFragment = MyDialogFragment.newInstance(R.string.title_dialog);
			break;
		case TYPE_BASIC_ALERT_DIALOG:
			newFragment = BasicAlertDialog
					.newInstance(R.string.title_basic_alert);
			break;
		case TYPE_LIST_ALERT_DIALOG:
			newFragment = ListAlertDialog
					.newInstance(R.string.title_list_alert);
			break;
		case TYPE_MULTI_ALERT_DIALOG:
			newFragment = MultiListAlertDialog
					.newInstance(R.string.title_multi_alert);
			break;
		case TYPE_CUSTOM_ALERT_DIALOG:
			newFragment = CustomAlertDialog
					.newInstance(R.string.title_custom_alert);
			break;
		}
		newFragment.show(ft, KEY_DIALOG);
	}

	@Override
	public void onPositiveClick() {
		// TODO Do something
	}

	@Override
	public void onNegativeClick() {
		// TODO Do something
	}

	@Override
	public void onNeutralClick() {
		// TODO Do something
	}
}
