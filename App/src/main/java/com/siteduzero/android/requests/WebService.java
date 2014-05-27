package com.siteduzero.android.requests;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.util.Log;

import com.siteduzero.android.requests.security.SessionStore;

public class WebService {
	private static final String TAG = "com.siteduzero.android.requests";
	private final Context mContext;

	public WebService(final Context context) {
		mContext = context;
	}

	public InputStream post(final String url, final Map<String, String> params,
			final boolean token) {
		if (url == null || url.isEmpty())
			return null;
		try {
			// Initialize post client.
			final HttpClient httpClient = new DefaultHttpClient();
			final HttpPost post = new HttpPost(url);
			// Add token in the header of the request.
			if (token) {
				final String accessToken = SessionStore
						.getAccessToken(mContext);
				post.setHeader("Authorization", accessToken);
			}
			// Add parameter on the request.
			if (params != null) {
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					nameValuePairs.add(new BasicNameValuePair(entry.getKey(),
							entry.getValue()));
				}
				post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			}
			// Execute the request.
			HttpResponse response = httpClient.execute(post);
			// Get the result if the HTTP status is ok.
			final int code = response.getStatusLine().getStatusCode();
			if (code == HttpURLConnection.HTTP_OK) {
				return response.getEntity().getContent();
			} else if (code == HttpURLConnection.HTTP_UNAUTHORIZED) {
				Log.v(TAG, "Unauthorization request on " + url);
			}
		} catch (UnsupportedEncodingException e) {
			Log.v(TAG,
					"[UnsupportedEncodingException] message : "
							+ e.getMessage());
		} catch (ClientProtocolException e) {
			Log.v(TAG, "[ClientProtocolException] message : " + e.getMessage());
		} catch (IOException e) {
			Log.v(TAG, "[IOException] message : " + e.getMessage());
		}
		return null;
	}

	public InputStream get(final String url, final boolean token) {
		if (url == null || url.isEmpty())
			return null;
		try {
			// Initialize post client.
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			// Add token in the header of the request.
			if (token) {
				final String accessToken = SessionStore
						.getAccessToken(mContext);
				get.setHeader("Authorization", accessToken);
			}
			// Execute the request.
			HttpResponse response = httpClient.execute(get);
			// Get the result if the HTTP status is ok.
			final int code = response.getStatusLine().getStatusCode();
			if (code == HttpURLConnection.HTTP_OK) {
				return response.getEntity().getContent();
			} else if (code == HttpURLConnection.HTTP_UNAUTHORIZED) {
				Log.v(TAG, "Unauthorization request on " + url);
			}
		} catch (UnsupportedEncodingException e) {
			Log.v(TAG,
					"[UnsupportedEncodingException] message : "
							+ e.getMessage());
		} catch (ClientProtocolException e) {
			Log.v(TAG, "[ClientProtocolException] message : " + e.getMessage());
		} catch (IOException e) {
			Log.v(TAG, "[IOException] message : " + e.getMessage());
		}
		return null;
	}
}
