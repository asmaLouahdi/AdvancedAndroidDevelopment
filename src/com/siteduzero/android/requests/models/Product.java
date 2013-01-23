package com.siteduzero.android.requests.models;

import java.io.Serializable;

import org.json.JSONObject;

public class Product implements Serializable {
	private static final long serialVersionUID = 7345905078802684556L;

	private long id;
	private String name;
	private String type;
	private double price;

	public Product() {
		super();
	}
	
	public Product(JSONObject jObject) {
		this.id = jObject.optLong("id");
		this.name = jObject.optString("name");
		this.type = jObject.optString("type");
		this.price = jObject.optDouble("price");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type
				+ ", price=" + price + "]";
	}
}
