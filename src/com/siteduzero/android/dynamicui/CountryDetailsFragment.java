package com.siteduzero.android.dynamicui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.siteduzero.android.R;

public class CountryDetailsFragment extends Fragment {
	private static final String ARG_POSITION = "POSITION";
	private static final int[] COUNTRIES = { R.drawable.belgique,
			R.drawable.france, R.drawable.italie, R.drawable.espagne,
			R.drawable.portugal, R.drawable.suisse };

	private ImageView mImageViewFlag;

	public static CountryDetailsFragment newInstance(int position) {
		final CountryDetailsFragment fragment = new CountryDetailsFragment();
		final Bundle args = new Bundle();
		args.putInt(ARG_POSITION, position);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.fragment_country_details,
				container, false);
		mImageViewFlag = (ImageView) v.findViewById(R.id.imageViewCountry);
		if (getArguments() != null) {
			final int position = getArguments().getInt(ARG_POSITION);
			updateCountry(position);
		}
		return v;
	}

	public void updateCountry(int position) {
		// Change flag of the country.
		mImageViewFlag.setImageResource(COUNTRIES[position]);
	}
}
