package com.siteduzero.android.requests;

import java.util.List;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class ProductsAsyncTaskLoader extends AsyncTaskLoader<ListProduct> {
	private final ProductManager mPHPLocalManager = new ProductManager();
	private ListProduct mProducts;

	public ProductsAsyncTaskLoader(Context context) {
		super(context);
	}

	@Override
	public ListProduct loadInBackground() {
		final List<Product> products = mPHPLocalManager.downloadProducts();
		if (products == null || products.isEmpty()) {
			return new ListProduct();
		}
		return mProducts = new ListProduct(products);
	}

	@Override
	protected void onStartLoading() {
		// We already have a result.
		if (mProducts != null) {
			deliverResult(mProducts);
		} else {
			forceLoad();
		}
	}
}
