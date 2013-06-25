package com.siteduzero.android.requests.products;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siteduzero.android.R;

public class ProductAdapter extends BaseAdapter {
	private final Context mContext;
	private final List<Product> mItems = new ArrayList<Product>();

	public ProductAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Product getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Product item = getItem(position);
		ProductView v = null;
		if (convertView == null) {
			v = new ProductView(mContext);
		} else {
			v = (ProductView) convertView;
		}
		v.bind(item);
		return v;
	}

	public void bind(List<Product> items) {
		mItems.clear();
		mItems.addAll(items);
	}

	private class ProductView extends RelativeLayout {
		private TextView mTextViewName;
		private TextView mTextViewType;
		private TextView mTextViewPrice;

		public ProductView(Context context) {
			super(context);
			inflate(context, R.layout.view_requests_php, this);
			mTextViewName = (TextView) findViewById(R.id.textViewName);
			mTextViewType = (TextView) findViewById(R.id.textViewType);
			mTextViewPrice = (TextView) findViewById(R.id.textViewPrice);
		}

		public void bind(final Product product) {
			mTextViewName.setText(product.getName());
			mTextViewType.setText(product.getType());
			mTextViewPrice.setText(product.getPrice() + "€");
		}
	}
}
