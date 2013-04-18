package com.siteduzero.android.requests;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.siteduzero.android.utils.Utils;

public class ProductManager {
	private static final String TAG = "com.siteduzero.android.requests.php";
	private static final String URL = "http://192.168.0.33:8888/SdZServeur/index.php";
	private final WebService mWebService = new WebService();
	
	public List<Product> downloadProducts() {
		final InputStream is = mWebService.request(URL);
		return parse(is);
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
