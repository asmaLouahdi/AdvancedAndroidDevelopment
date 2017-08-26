package org.randoomz.demo.fragments.dialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;

public class TimeDialog extends DialogFragment implements OnTimeSetListener {
	private static final String KEY_HOUR = "hour";
	private static final String KEY_MINUTE = "minute";
	private final Calendar mCalendar = Calendar.getInstance();
	private TimeSelected mListener;

	public static TimeDialog newInstance(final Calendar calendar) {
		TimeDialog fragment = new TimeDialog();
		Bundle args = new Bundle();
		args.putInt(KEY_HOUR, calendar.get(Calendar.HOUR_OF_DAY));
		args.putInt(KEY_MINUTE, calendar.get(Calendar.MINUTE));
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (TimeSelected) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement TimeSelected");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final int hour = getArguments().getInt(KEY_HOUR);
		final int minute = getArguments().getInt(KEY_MINUTE);
		mCalendar.set(Calendar.HOUR_OF_DAY, hour);
		mCalendar.set(Calendar.MINUTE, minute);
		return new TimePickerDialog(getActivity(), this, hour, minute, true);
	}

	public interface TimeSelected {
		void onTimeSelected(final Calendar calendar);
	}

	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
		mCalendar.set(Calendar.MINUTE, minute);
		mListener.onTimeSelected(mCalendar);
	}

}
