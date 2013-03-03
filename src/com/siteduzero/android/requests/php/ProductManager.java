package com.siteduzero.android.requests.php;

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
	
	public List<String> downloadProducts() {
		InputStream is = mWebService.connect(URL);
		List<String> res = parse(is);
		mWebService.disconnect();
		return res;
	}

	private List<String> parse(final InputStream is) {
		JSONArray jProductArray = null;
		try {
			final String json = Utils.convertInputStreamToString(is);
			final List<String> products = new ArrayList<String>();
			jProductArray = new JSONArray(json);
			for (int i = 0; i < jProductArray.length(); i++) {
				final Product p = new Product(jProductArray.optJSONObject(i));
				products.add(p.getName());
			}
			return products;
		} catch (JSONException e) {
			Log.v(TAG, "[JSONException] e : " + e.getMessage());
		}
		return null;
	}
}
