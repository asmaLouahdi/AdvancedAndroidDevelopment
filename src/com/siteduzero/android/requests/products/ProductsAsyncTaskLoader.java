package com.siteduzero.android.requests.products;

import java.util.List;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class ProductsAsyncTaskLoader extends AsyncTaskLoader<ListProduct> {
	private final ProductManager mProductManager;
	private ListProduct mProducts;

	public ProductsAsyncTaskLoader(Context context) {
		super(context);
		mProductManager = new ProductManager(context);
	}

	@Override
	public ListProduct loadInBackground() {
		final List<Product> products = mProductManager.request();
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
