package com.siteduzero.android.fragments.dynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.siteduzero.android.R;

public class DynamicActivity extends FragmentActivity {
	private static final String KEY_FRAGMENT = "fragment_save";

	private String mFragment;
	private Dynamic1Fragment mDynamic1Fragment;
	private Dynamic2Fragment mDynamic2Fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_dynamic);

		if (savedInstanceState != null)
			mFragment = savedInstanceState.getString(KEY_FRAGMENT);
		else
			mFragment = getIntent().getStringExtra(KEY_FRAGMENT);

		setupFragments();
		if (mFragment != null) {
			if (mFragment.equals(mDynamic1Fragment.getClass().getSimpleName())) {
				showFragment(this.mDynamic1Fragment);
			} else if (mFragment.equals(mDynamic2Fragment.getClass().getSimpleName())) {
				showFragment(this.mDynamic2Fragment);
			}
		} else {
			showFragment(this.mDynamic1Fragment);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString(KEY_FRAGMENT, mFragment != null ? mFragment : "");
		super.onSaveInstanceState(outState);
	}

	private void setupFragments() {
		// We instantiate just one time instance of fragments during the live of
		// the activity.
		this.mDynamic1Fragment = new Dynamic1Fragment();
		this.mDynamic2Fragment = new Dynamic2Fragment();
	}

	private void showFragment(final Fragment fragment) {
		if (fragment == null)
			return;

		// Update current fragment.
		mFragment = fragment.getClass().getSimpleName();
		// Begin a fragment transaction.
		final FragmentManager fm = getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();
		// We can also animate the changing of fragment.
		ft.setCustomAnimations(android.R.anim.slide_in_left,
				android.R.anim.slide_out_right);
		// Replace current fragment by the new one.
		ft.replace(R.id.frameLayoutListView, fragment);
		// Null on the back stack to return on the previous fragment when user
		// press on back button.
		ft.addToBackStack(null);
		ft.setBreadCrumbShortTitle("Test");

		// Commit changes.
		ft.commit();
	}

	public void goToFragment1(View v) {
		showFragment(this.mDynamic1Fragment);
	}

	public void goToFragment2(View v) {
		showFragment(this.mDynamic2Fragment);
	}
}
