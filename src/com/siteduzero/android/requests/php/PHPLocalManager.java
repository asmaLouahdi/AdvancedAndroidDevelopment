package com.siteduzero.android.requests.php;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.siteduzero.android.requests.WebService;
import com.siteduzero.android.requests.models.Product;
import com.siteduzero.android.utils.Utils;

public class PHPLocalManager {
	private static final String TAG = "com.siteduzero.android.requests.php";
	private static final String URL = "http://192.168.0.33:8888/SdZServeur/index.php";
	private WebService mWebService = new WebService();
	
	public List<String> downloadProducts() {
		InputStream is = mWebService.connect(URL);
		List<String> res = parse(is);
		mWebService.disconnect();
		return res;
	}

	private List<String> parse(InputStream is) {
		JSONArray jProductArray = null;
		try {
			String json = Utils.convertInputStreamToString(is);
			List<String> products = new ArrayList<String>();
			jProductArray = new JSONArray(json);
			for (int i = 0; i < jProductArray.length(); i++) {
				Product p = new Product(jProductArray.optJSONObject(i));
				products.add(p.getName());
			}
			return products;
		} catch (JSONException e) {
			Log.v(TAG, "[JSONException] e : " + e.getMessage());
		}
		return null;
	}
}
