package com.siteduzero.android.services.auth;

import org.json.JSONObject;

public class UserInformation {
	private long mId;
	private String mName;
	private String mFirstName;
	private String mLastName;
	private String mLink;
	private String mPicture;
	private String mGender;
	private String mBirthday;
	private String mLocale;

	public UserInformation(final JSONObject jObject) {
		mId = jObject.optLong("id");
		mName = jObject.optString("name");
		mFirstName = jObject.optString("given_name");
		mLastName = jObject.optString("family_name");
		mLink = jObject.optString("link");
		mPicture = jObject.optString("picture");
		mGender = jObject.optString("gender");
		mBirthday = jObject.optString("birthday");
		mLocale = jObject.optString("locale");
	}

	public long getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public String getLink() {
		return mLink;
	}

	public String getPicture() {
		return mPicture;
	}

	public String getGender() {
		return mGender;
	}

	public String getBirthday() {
		return mBirthday;
	}

	public String getLocale() {
		return mLocale;
	}

	@Override
	public String toString() {
		return "UserInformation [mId=" + mId + ", mName=" + mName
				+ ", mFirstName=" + mFirstName + ", mLastName=" + mLastName
				+ ", mLink=" + mLink + ", mPicture=" + mPicture + ", mGender="
				+ mGender + ", mBirthday=" + mBirthday + ", mLocale=" + mLocale
				+ "]";
	}
}
