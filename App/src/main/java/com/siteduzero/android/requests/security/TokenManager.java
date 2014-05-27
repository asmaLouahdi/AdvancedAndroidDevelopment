package com.siteduzero.android.requests.security;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.siteduzero.android.requests.Manager;
import com.siteduzero.android.utils.Utils;

public class TokenManager extends Manager {
	private static final String URL_REQUEST = "http://" + DOMAIN
			+ ":8888/AdvancedAndroidDevelopment/register.php";
	private static final String URL_AUTH = "http://" + DOMAIN
			+ ":8888/AdvancedAndroidDevelopment/auth.php";
	private static final String KEY_TOKEN = "access_token";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_PASSWORD = "password";
	private final Map<String, String> mParams = new HashMap<String, String>();

	public TokenManager(final Context context) {
		super(context);
	}

	public String register(final String email, final String password) {
		mParams.clear();
		mParams.put(KEY_EMAIL, email);
		mParams.put(KEY_PASSWORD, password);
		return parse(mWebService.post(URL_REQUEST, mParams, false));
	}

	public String auth(final String email, final String password) {
		mParams.clear();
		mParams.put(KEY_EMAIL, email);
		mParams.put(KEY_PASSWORD, password);
		return parse(mWebService.post(URL_AUTH, mParams, false));
	}

	private String parse(final InputStream is) {
		try {
			final String json = Utils.convertInputStreamToString(is);
			final JSONObject jObject = new JSONObject(json);
			return jObject.optString(KEY_TOKEN);
		} catch (JSONException e) {
			Log.v(TAG, "[JSONException] e : " + e.getMessage());
		}
		return null;
	}

}
