package com.siteduzero.android.requests.security;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.siteduzero.android.R;
import com.siteduzero.android.requests.products.PHPRequestActivity;

public class AuthenticationActivity extends FragmentActivity implements
		ActionBar.TabListener {
	// Connection
	private final Authentication mAuthentication = new Authentication();

	// GUI
	private AuthenticationAdapter mAdapter = null;
	private ViewPager mViewPager = null;

	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		// If authentication is valid, we launch the application. Otherwise, we
		// launch the authentication activity.
		SessionStore.restoreAccessToken(mAuthentication, this);
		if (mAuthentication.isSessionValid()) {
			final Intent i = new Intent(this, PHPRequestActivity.class);
			startActivity(i);
			finish(); // Finish this activity for back navigation.
		}
		setContentView(R.layout.activity_authentication);

		initializeGUI();
	}

	private void initializeGUI() {
		// If we launch a ViewPager for GUI, we initialize this component.
		if (findViewById(R.id.view_pager_authentication) != null) {
			// Set up the adapter.
			mAdapter = new AuthenticationAdapter(getSupportFragmentManager(),
					this);

			// Set up the action bar.
			final ActionBar actionBar = getActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

			// Set up the ViewPager with the sections adapter.
			mViewPager = (ViewPager) findViewById(R.id.view_pager_authentication);
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
