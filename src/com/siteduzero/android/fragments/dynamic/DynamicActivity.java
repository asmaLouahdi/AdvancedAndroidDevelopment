package com.siteduzero.android.fragments.dynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.siteduzero.android.R;

public class DynamicActivity extends FragmentActivity {
	private String mFragment;
	private Dynamic1Fragment mDynamic1Fragment;
	private Dynamic2Fragment mDynamic2Fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_dynamic);

		if (savedInstanceState != null)
			mFragment = savedInstanceState.getString("fragment");
		else
			mFragment = getIntent().getStringExtra("fragment");

		setupFragments();
		if (mFragment != null) {
			if (mFragment.equals("Dynamic1Fragment")) {
				showFragment(this.mDynamic1Fragment);
			} else if (mFragment.equals("Dynamic2Fragment")) {
				showFragment(this.mDynamic2Fragment);
			}
		} else {
			showFragment(this.mDynamic1Fragment);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("fragment", mFragment != null ? mFragment : "");
		super.onSaveInstanceState(outState);
	}

	private void setupFragments() {
		final FragmentManager fm = getSupportFragmentManager();

		this.mDynamic1Fragment = (Dynamic1Fragment) fm
				.findFragmentByTag(Dynamic1Fragment.TAG);
		if (this.mDynamic1Fragment == null) {
			this.mDynamic1Fragment = new Dynamic1Fragment();
		}

		this.mDynamic2Fragment = (Dynamic2Fragment) fm
				.findFragmentByTag(Dynamic2Fragment.TAG);
		if (this.mDynamic2Fragment == null) {
			this.mDynamic2Fragment = new Dynamic2Fragment();
		}
	}

	private void showFragment(final Fragment fragment) {
		if (fragment == null)
			return;

		final FragmentManager fm = getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();
		// We can also animate the changing of fragment
		ft.setCustomAnimations(android.R.anim.slide_in_left,
				android.R.anim.slide_out_right);

		ft.replace(R.id.frameLayoutListView, fragment);

		ft.commit();
	}

	public void goToFragment1(View v) {
		showFragment(this.mDynamic1Fragment);
	}

	public void goToFragment2(View v) {
		showFragment(this.mDynamic2Fragment);
	}
}
