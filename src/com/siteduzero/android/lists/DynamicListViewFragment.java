package com.siteduzero.android.lists;

import java.util.ArrayList;
import java.util.List;

import com.siteduzero.android.R;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DynamicListViewFragment extends ListFragment {
	public static final String TAG = "DynamicListViewFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listview, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		DynamicListViewModel header = new DynamicListViewModel(
				R.drawable.avatar, R.string.default_lorem);

		List<Integer> itemsBody = new ArrayList<Integer>();
		itemsBody.add(R.string.default_lorem);
		itemsBody.add(R.string.default_lorem);
		itemsBody.add(R.string.default_lorem);
		itemsBody.add(R.string.default_lorem);

		DynamicListViewAdapter adapter = new DynamicListViewAdapter(
				getActivity());
		adapter.bindHeader(header);
		adapter.bindBody(itemsBody);
		setListAdapter(adapter);
	}
}
