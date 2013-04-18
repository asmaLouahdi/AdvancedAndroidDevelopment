package com.siteduzero.android.requests;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.util.Log;

public class WebService {
	private static final String TAG = "com.siteduzero.android.requests";

	private HttpURLConnection mUrlConnection = null;

	public InputStream request(final String strUrl) {
		try {
			final URL url = new URL(strUrl);
			final URLConnection connection = url.openConnection();
			mUrlConnection = (HttpURLConnection) connection;
			mUrlConnection.connect();
			final int code = mUrlConnection.getResponseCode();
			if (code == HttpURLConnection.HTTP_OK) {
				return mUrlConnection.getInputStream();
			} else if (code == HttpURLConnection.HTTP_UNAUTHORIZED) {
				Log.v(TAG, "Unauthorization request on " + strUrl);
			}
		} catch (IOException e) {
			Log.v(TAG, "[IOException] e : " + e.getMessage());
		}
		return null;
	}
	
	public void disconnect() {
		if (mUrlConnection != null) {
			mUrlConnection.disconnect();
		}
	}
}
