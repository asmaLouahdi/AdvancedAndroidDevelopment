package com.siteduzero.android.navigation.slidingpane;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;

import com.siteduzero.android.R;
import com.siteduzero.android.dynamicui.CountryDetailsFragment;
import com.siteduzero.android.dynamicui.CountryListFragment.OnCountrySelectedListener;

public class SlidingPaneLayoutActivity extends FragmentActivity implements
		OnCountrySelectedListener {
	private SlidingPaneLayout mSlidingPaneLayout;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_sliding_pane);
		mSlidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.slidingPaneLayout);
		mSlidingPaneLayout.openPane();
	}

	@Override
	public void onCountrySelected(int position) {
		final CountryDetailsFragment detailsFragment = (CountryDetailsFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragmentDetails);
		detailsFragment.updateCountry(position);
		mSlidingPaneLayout.closePane();
	}
}
