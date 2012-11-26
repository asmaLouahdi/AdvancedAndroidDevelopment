package com.siteduzero.android.lists;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DynamicListViewAdapter extends BaseAdapter {
	private static final int TYPE_HEADER = 0;
	private static final int TYPE_BODY = 1;
	private static final int TYPE_MAX = 2;
	private List<Integer> mTypes = new ArrayList<Integer>();
	private DynamicListViewModel mModelHeader = null;
	private List<Integer> mModelBody = new ArrayList<Integer>();
	private Context mContext;

	public DynamicListViewAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getViewTypeCount() {
		return TYPE_MAX;
	}

	@Override
	public int getItemViewType(int position) {
		return mTypes.get(position);
	}

	@Override
	public int getCount() {
		if (mModelHeader == null)
			return mModelBody.size();
		return 1 + mModelBody.size();
	}

	@Override
	public Object getItem(int position) {
		int type = getItemViewType(position);
		return type == TYPE_HEADER ? mModelHeader : mModelBody
				.get(position - 1);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = null;
		int type = getItemViewType(position);

		if (convertView == null) {
			switch (type) {
			case TYPE_HEADER:
				v = new DynamicHeaderListViewView(mContext);
				break;
			case TYPE_BODY:
				v = new DynamicBodyListViewView(mContext);
				break;
			}
		} else {
			switch (type) {
			case TYPE_HEADER:
				v = (DynamicHeaderListViewView) convertView;
				break;
			case TYPE_BODY:
				v = (DynamicBodyListViewView) convertView;
				break;
			}
		}

		switch (type) {
		case TYPE_HEADER:
			DynamicListViewModel model1 = (DynamicListViewModel) getItem(position);
			((DynamicHeaderListViewView) v).bind(model1.getImageRessource(),
					model1.getTextRessource());
			break;
		case TYPE_BODY:
			Integer model2 = (Integer) getItem(position);
			((DynamicBodyListViewView) v).bind(model2);
			break;
		}

		return v;
	}

	public void bindHeader(DynamicListViewModel model) {
		mModelHeader = model;
		mTypes.add(TYPE_HEADER);
	}

	public void bindBody(List<Integer> model) {
		mModelBody = model;
		for (int i = 0; i < model.size(); i++) {
			mTypes.add(TYPE_BODY);
		}
	}
}
