package com.siteduzero.android.requests;

import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
	private final long mId;
	private final String mName;
	private final String mType;
	private final double mPrice;

	public Product(JSONObject jObject) {
		this.mId = jObject.optLong("id");
		this.mName = jObject.optString("name");
		this.mType = jObject.optString("type");
		this.mPrice = jObject.optDouble("price");
	}

	public Product(Parcel source) {
		this.mId = source.readLong();
		this.mName = source.readString();
		this.mType = source.readString();
		this.mPrice = source.readDouble();
	}

	public long getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public String getType() {
		return mType;
	}

	public double getPrice() {
		return mPrice;
	}

	@Override
	public String toString() {
		return "Product [id=" + mId + ", name=" + mName + ", type=" + mType
				+ ", price=" + mPrice + "]";
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(mId);
		dest.writeString(mName);
		dest.writeString(mType);
		dest.writeDouble(mPrice);
	}
}
