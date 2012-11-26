package com.siteduzero.android.lists;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.siteduzero.android.R;

public class ListViewActivity extends FragmentActivity {
	private String mFragment;
	private SimpleListViewFragment mListViewFragment;
	private CustomListViewFragment mCustomListViewFragment;
	private DynamicListViewFragment mDynamicListViewFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);

		if (savedInstanceState != null)
			mFragment = savedInstanceState.getString("fragment");
		else
			mFragment = getIntent().getStringExtra("fragment");

		setupFragments();
		if (mFragment != null) {
			if (mFragment.equals("SimpleListViewFragment")) {
				setTitle(R.string.title_fragment_simple_listview);
				showFragment(this.mListViewFragment);
			} else if (mFragment.equals("CustomListViewFragment")) {
				setTitle(R.string.title_fragment_custom_listview);
				showFragment(this.mCustomListViewFragment);
			} else if (mFragment.equals("DynamicListViewFragment")) {
				setTitle(R.string.title_fragment_dynamic_listview);
				showFragment(this.mDynamicListViewFragment);
			}
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("fragment", mFragment != null ? mFragment : "");
		super.onSaveInstanceState(outState);
	}

	private void setupFragments() {
		final FragmentManager fm = getSupportFragmentManager();

		this.mListViewFragment = (SimpleListViewFragment) fm
				.findFragmentByTag(SimpleListViewFragment.TAG);
		if (this.mListViewFragment == null) {
			this.mListViewFragment = new SimpleListViewFragment();
		}

		this.mCustomListViewFragment = (CustomListViewFragment) fm
				.findFragmentByTag(CustomListViewFragment.TAG);
		if (this.mCustomListViewFragment == null) {
			this.mCustomListViewFragment = new CustomListViewFragment();
		}

		this.mDynamicListViewFragment = (DynamicListViewFragment) fm
				.findFragmentByTag(DynamicListViewFragment.TAG);
		if (this.mDynamicListViewFragment == null) {
			this.mDynamicListViewFragment = new DynamicListViewFragment();
		}
	}

	private void showFragment(Fragment fragment) {
		if (fragment == null)
			return;

		final FragmentManager fm = getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();
		ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

		ft.replace(R.id.frameLayoutListView, fragment);

		ft.commit();
	}
}
