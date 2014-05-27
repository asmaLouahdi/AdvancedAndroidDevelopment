package com.siteduzero.android.requests.security;

public class Authentication {
	private String mId;
	private String mEmail;
	private String mPassword;
	private String mAccessToken;

	public String getId() {
		return mId;
	}

	public void setId(String mId) {
		this.mId = mId;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(final String email) {
		this.mEmail = email;
	}

	public String getPassword() {
		return mPassword;
	}

	public void setPassword(final String password) {
		this.mPassword = password;
	}

	public String getAccessToken() {
		return mAccessToken;
	}

	public void setAccessToken(final String accessToken) {
		this.mAccessToken = accessToken;
	}

	public boolean isLoginValid() {
		return mEmail != null && mPassword != null;
	}

	public boolean isSessionValid() {
		return mAccessToken != null;
	}
}
