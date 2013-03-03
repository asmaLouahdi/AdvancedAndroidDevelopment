package com.siteduzero.android.requests.php;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.util.Log;

public class WebService {
	private static final String TAG = "com.siteduzero.android.requests";

	private HttpURLConnection mUrlConnection = null;

	public InputStream connect(final String strUrl) {
		URLConnection connection = null;
		URL url = null;
		try {
			url = new URL(strUrl);
			connection = url.openConnection();
			mUrlConnection = (HttpURLConnection) connection;
			mUrlConnection.connect();
			if (mUrlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return mUrlConnection.getInputStream();
			}
		} catch (IOException e) {
			Log.v(TAG, "[IOException] e : " + e.getMessage());
		}
		return null;
	}

	public void disconnect() {
		if (mUrlConnection != null)
			mUrlConnection.disconnect();
	}
}
