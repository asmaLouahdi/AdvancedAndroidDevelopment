package com.siteduzero.android.lists.custom;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siteduzero.android.R;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewFragment extends ListFragment {
	public static final String TAG = "CustomListViewFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listview, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		List<Integer> items = new ArrayList<Integer>();
		items.add(R.string.default_lorem);
		items.add(R.string.default_lorem);
		items.add(R.string.default_lorem);
		items.add(R.string.default_lorem);

		CustomListViewAdapter adapter = new CustomListViewAdapter(getActivity());
		adapter.bind(items);
		setListAdapter(adapter);
	}
}
