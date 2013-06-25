package com.siteduzero.android.requests.security;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.siteduzero.android.R;

public class AuthenticationAdapter extends FragmentPagerAdapter {
	private Context mContext;

	public AuthenticationAdapter(FragmentManager fm, Context c) {
		super(fm);
		this.mContext = c;
	}

	@Override
	public Fragment getItem(int pos) {
		switch (pos) {
		case 0:
			return new AuthenticationFragment();
		case 1:
			return new RegisterFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		String title = "";
		switch (position) {
		case 0:
			title = mContext.getString(R.string.request_login);
			break;
		case 1:
			title = mContext.getString(R.string.request_register);
			break;
		}
		return title.toUpperCase();
	}
}
