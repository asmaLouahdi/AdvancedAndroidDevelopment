package org.randoomz.demo.fragments.dialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

public class DateDialog extends DialogFragment implements OnDateSetListener {
	private static final String KEY_YEAR = "year";
	private static final String KEY_MONTH = "month";
	private static final String KEY_DAY = "day";
	private final Calendar mCalendar = Calendar.getInstance();
	private DateSelected mListener;

	public static DateDialog newInstance(final Calendar calendar) {
		DateDialog fragment = new DateDialog();
		Bundle args = new Bundle();
		args.putInt(KEY_YEAR, calendar.get(Calendar.YEAR));
		args.putInt(KEY_MONTH, calendar.get(Calendar.MONTH));
		args.putInt(KEY_DAY, calendar.get(Calendar.DAY_OF_MONTH));
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (DateSelected) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement DateSelected");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final int year = getArguments().getInt(KEY_YEAR);
		final int month = getArguments().getInt(KEY_MONTH);
		final int day = getArguments().getInt(KEY_DAY);
		mCalendar.set(year, month, day);
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		mCalendar.set(year, monthOfYear, dayOfMonth);
		mListener.onDateSelected(mCalendar);
	}

	public interface DateSelected {
		void onDateSelected(final Calendar calendar);
	}

}
