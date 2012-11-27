package com.siteduzero.android.samples;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SamplesAdapter extends BaseAdapter {
	private Context mContext = null;
	private List<SamplesItem> mItems = new ArrayList<SamplesItem>();

	public SamplesAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public SamplesItem getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SamplesItem item = getItem(position);
		SamplesView v = null;
		if (convertView == null)
			v = new SamplesView(mContext);
		else
			v = (SamplesView) convertView;
		v.bind(item.getTitle(), item.getChapter());
		return v;
	}
	
	public void bind(List<SamplesItem> items) {
		mItems = items;
	}
}
