package com.siteduzero.android.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;

public class Utils {
	public static String convertInputStreamToString(InputStream is) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
		} catch (Exception e) {
			Log.e("org.randoomz.android",
					"Error converting result " + e.toString());
		}
		return sb.toString();
	}
}
