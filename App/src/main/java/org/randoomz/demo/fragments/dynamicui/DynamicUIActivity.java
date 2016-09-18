package org.randoomz.demo.fragments.dynamicui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.randoomz.demo.R;
import org.randoomz.demo.fragments.dynamicui.CountryListFragment.OnCountrySelectedListener;

public class DynamicUIActivity extends AppCompatActivity implements OnCountrySelectedListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dynamic_ui);

		if (findViewById(R.id.frameLayoutDynamicUi) != null) {
			final CountryListFragment listFragment = new CountryListFragment();
			getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frameLayoutDynamicUi, listFragment)
                    .commit();
		}
	}

	@Override
	public void onCountrySelected(int position) {
		if (findViewById(R.id.frameLayoutDynamicUi) == null) {
			// If we are in landscape mode, we show the flag in the second fragment.
			final CountryDetailsFragment detailsFragment = (CountryDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetails);
			detailsFragment.updateCountry(position);
		} else {
			// Else, we show the other fragment in portrait mode.
			final CountryDetailsFragment detailsFragment = CountryDetailsFragment.newInstance(position);
			final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.frameLayoutDynamicUi, detailsFragment);
			ft.addToBackStack(null);
			ft.commit();
		}
	}

}
