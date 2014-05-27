package com.siteduzero.android.requests;

import android.content.Context;

public abstract class Manager {
	protected static final String TAG = "com.siteduzero.android.requests";
	protected static final String DOMAIN = "192.168.0.103";
	protected final WebService mWebService;
	
	public Manager(final Context context) {
		mWebService = new WebService(context);
	}
}
