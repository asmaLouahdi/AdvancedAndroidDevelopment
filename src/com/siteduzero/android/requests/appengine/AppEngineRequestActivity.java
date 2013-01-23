package com.siteduzero.android.requests.appengine;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.siteduzero.android.R;
import com.siteduzero.android.requests.models.Product;

public class AppEngineRequestActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appengine);
	}

	public void getProduct(View v) {
		Product p = new Product();
		p.setId(1);
		p.setName("Framboise");
		p.setPrice(1);
		p.setType("Fruit");
		new ProductAsyncTask().execute(p);
	}

	private class ProductAsyncTask extends AsyncTask<Product, Void, Void> {

		@Override
		protected Void doInBackground(Product... params) {
			ProductManager.getInstance().create((Product) params[0]);
			return null;
		}

	}
}
