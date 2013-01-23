package com.siteduzero.android.requests.appengine;

import com.siteduzero.android.requests.models.Product;

public interface ProductControllerInterface {
	void create(Product p);

	Product getProduct(long id);
}
