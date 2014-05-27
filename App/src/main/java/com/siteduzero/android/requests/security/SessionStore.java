package com.siteduzero.android.requests.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionStore {
	private static final String ID = "id";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String TOKEN = "access_token";
	private static final String KEY = "session";

	public static boolean saveLogin(Authentication login, Context context) {
		Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
				.edit();
		editor.putString(ID, login.getId());
		editor.putString(USERNAME, login.getEmail());
		editor.putString(PASSWORD, login.getPassword());
		return editor.commit();
	}

	public static boolean saveAccessToken(String token, Context context) {
		Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
				.edit();
		editor.putString(TOKEN, token);
		return editor.commit();
	}

	public static boolean restoreLogin(Authentication login, Context context) {
		SharedPreferences savedSession = context.getSharedPreferences(KEY,
				Context.MODE_PRIVATE);
		login.setId(savedSession.getString(ID, null));
		login.setEmail(savedSession.getString(USERNAME, null));
		login.setPassword(savedSession.getString(PASSWORD, null));
		return login.isSessionValid();
	}

	public static boolean restoreAccessToken(Authentication session, Context context) {
		SharedPreferences savedSession = context.getSharedPreferences(KEY,
				Context.MODE_PRIVATE);
		session.setAccessToken(savedSession.getString(TOKEN, null));
		return session.isSessionValid();
	}

	public static String getAccessToken(Context context) {
		SharedPreferences savedSession = context.getSharedPreferences(KEY,
				Context.MODE_PRIVATE);
		return savedSession.getString(TOKEN, null);
	}

}
