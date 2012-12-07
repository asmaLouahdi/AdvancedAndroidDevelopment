package com.siteduzero.android.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.siteduzero.android.R;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	private Context mContext;

	public ViewPagerAdapter(FragmentManager fm, Context c) {
		super(fm);
		this.mContext = c;
	}

	@Override
	public Fragment getItem(int pos) {
		return SectionFragment.newInstance(pos);
	}
	
	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			return mContext.getString(R.string.title_section1).toUpperCase();
		case 1:
			return mContext.getString(R.string.title_section2).toUpperCase();
		case 2:
			return mContext.getString(R.string.title_section3).toUpperCase();
		}
		return null;
	}
}
