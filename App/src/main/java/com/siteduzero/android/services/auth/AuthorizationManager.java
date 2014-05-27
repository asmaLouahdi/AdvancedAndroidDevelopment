package com.siteduzero.android.services.auth;

import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.siteduzero.android.requests.Manager;
import com.siteduzero.android.utils.Utils;

public class AuthorizationManager extends Manager {
	private static final String TAG = "com.siteduzero.android.services.auth";
	private static final String URL = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

	public AuthorizationManager(final Context context) {
		super(context);
	}
	
	public UserInformation downloadUserInformation(final String token) {
		return parse(mWebService.post(URL + token, null, false));
	}

	private UserInformation parse(final InputStream is) {
		try {
			final String json = Utils.convertInputStreamToString(is);
			final JSONObject profile = new JSONObject(json);
			return new UserInformation(profile);
		} catch (JSONException e) {
			Log.v(TAG, "[JSONException] e : " + e.getMessage());
		}
		return null;
	}
}
