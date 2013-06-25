package com.siteduzero.android.requests.security;

import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.siteduzero.android.requests.Manager;
import com.siteduzero.android.utils.Utils;

public class RegisterManager extends Manager {
	private static final String URL = "http://" + DOMAIN
			+ ":8888/AdvancedAndroidDevelopment/register.php";
	private static final String KEY_TOKEN = "access_token";

	public RegisterManager(final Context context) {
		super(context);
	}

	public String request(final String email, final String password) {
		return parse(mWebService.post(URL, null, false));
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
