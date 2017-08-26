package org.randoomz.demo.fragments.lists.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.randoomz.demo.R;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewAdapter extends BaseAdapter {
	private List<Integer> mModel = new ArrayList<Integer>();
	private Context mContext;

	public CustomListViewAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return mModel.size();
	}

	@Override
	public Integer getItem(int position) {
		return mModel.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final int item = getItem(position);
		ViewHolder holder;
		if (convertView == null) {
			// It's the first instantiation, we create our view.
			convertView = LayoutInflater.from(mContext).inflate(R.layout.view_custom_listview, parent, false);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			// Android is awesome, we can retrieve an older version of our view.
			holder = (ViewHolder) convertView.getTag();
		}
		holder.bind(item);
		return convertView;
	}

	public void bind(List<Integer> model) {
		mModel = model;
	}

	private static class ViewHolder {
		private TextView mTextView;

		public ViewHolder(final View view) {
			mTextView = (TextView) view.findViewById(R.id.textView);
		}

		public void bind(int text) {
			mTextView.setText(text);
		}
	}
}
