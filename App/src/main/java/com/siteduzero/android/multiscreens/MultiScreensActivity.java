package com.siteduzero.android.multiscreens;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.siteduzero.android.R;

public class MultiScreensActivity extends FragmentActivity implements
		ActionBar.TabListener {
	private MultiScreensAdapter mAdapter = null;
	private ViewPager mViewPager = null;

	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.activity_multi_screens);

		if (findViewById(R.id.viewPagerMultiScreen) != null) {
			// Set up the adapter.
			mAdapter = new MultiScreensAdapter(getSupportFragmentManager(),
					this);

			// Set up the action bar.
			final ActionBar actionBar = getActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

			// Set up the ViewPager with the sections adapter.
			mViewPager = (ViewPager) findViewById(R.id.viewPagerMultiScreen);
			mViewPager.setAdapter(mAdapter);

			// Set up the gesture to swipe between tab.
			mViewPager
					.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
						@Override
						public void onPageSelected(int position) {
							actionBar.setSelectedNavigationItem(position);
						}
					});

			// For each of the sections in the app, add a tab to the action bar.
			for (int i = 0; i < mAdapter.getCount(); i++) {
				actionBar
						.addTab(actionBar.newTab()
								.setText(mAdapter.getPageTitle(i))
								.setTabListener(this));
			}
		}
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}
}
