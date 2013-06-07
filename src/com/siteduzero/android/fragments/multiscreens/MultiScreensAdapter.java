package com.siteduzero.android.fragments.multiscreens;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.siteduzero.android.R;
import com.siteduzero.android.lists.custom.CustomListViewFragment;
import com.siteduzero.android.lists.dynamic.DynamicListViewFragment;
import com.siteduzero.android.samples.SamplesListFragment;

public class MultiScreensAdapter extends FragmentPagerAdapter {
	private Context mContext;

	public MultiScreensAdapter(FragmentManager fm, Context c) {
		super(fm);
		this.mContext = c;
	}

	@Override
	public Fragment getItem(int pos) {
		switch (pos) {
		case 0:
			return new SamplesListFragment();
		case 1:
			return new CustomListViewFragment();
		case 2:
			return new DynamicListViewFragment();
		}
		return null;
	}
	
	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		String title = "";
		switch (position) {
		case 0:
			title = mContext.getString(R.string.title_section1); 
		case 1:
			title = mContext.getString(R.string.title_section2);
		case 2:
			title = mContext.getString(R.string.title_section3);
		}
		return title.toUpperCase();
	}
}
