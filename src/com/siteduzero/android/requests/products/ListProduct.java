package com.siteduzero.android.requests.products;

import java.util.ArrayList;
import java.util.List;

public class ListProduct {
	private final List<Product> mProducts = new ArrayList<Product>();

	public ListProduct() {
	}

	public ListProduct(final List<Product> products) {
		mProducts.clear();
		mProducts.addAll(products);
	}

	public void add(final Product product) {
		mProducts.add(product);
	}

	public List<Product> getProducts() {
		return new ArrayList<Product>(mProducts);
	}
}
