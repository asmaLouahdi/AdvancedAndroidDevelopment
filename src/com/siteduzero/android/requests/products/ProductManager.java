package com.siteduzero.android.requests.products;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.util.Log;

import com.siteduzero.android.requests.Manager;
import com.siteduzero.android.utils.Utils;

public class ProductManager extends Manager {
	private static final String URL = "http://" + DOMAIN
			+ ":8888/AdvancedAndroidDevelopment/products.php";

	public ProductManager(final Context context) {
		super(context);
	}

	protected List<Product> request() {
		return parse(mWebService.post(URL, null, true));
	}

	private List<Product> parse(final InputStream is) {
		JSONArray jProductArray = null;
		try {
			final String json = Utils.convertInputStreamToString(is);
			final List<Product> products = new ArrayList<Product>();
			jProductArray = new JSONArray(json);
			for (int i = 0; i < jProductArray.length(); i++) {
				products.add(new Product(jProductArray.optJSONObject(i)));
			}
			return products;
		} catch (JSONException e) {
			Log.v(TAG, "[JSONException] e : " + e.getMessage());
		}
		return null;
	}
}
