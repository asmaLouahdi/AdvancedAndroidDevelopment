package com.siteduzero.android.requests.appengine;

import org.restlet.resource.ClientResource;

import com.siteduzero.android.requests.models.Product;

public class ProductManager {
	private static final String URL_PRODUCT = "http://sdz-samples.appspot.com/rest/product";
	private final ClientResource mClientResource;
	private final ProductControllerInterface mController;
	private static final ProductManager INSTANCE = new ProductManager();

	public static ProductManager getInstance() {
		return INSTANCE;
	}

	private ProductManager() {
		mClientResource = new ClientResource(URL_PRODUCT);
		mController = mClientResource.wrap(ProductControllerInterface.class);
	}

	public void create(Product p) {
		mController.create(p);
	}

	public Product getProduct(long id) {
		return mController.getProduct(id);
	}

}
