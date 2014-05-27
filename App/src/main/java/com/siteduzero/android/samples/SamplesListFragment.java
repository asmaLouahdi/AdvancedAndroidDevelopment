package com.siteduzero.android.samples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.siteduzero.android.R;

public class SamplesListFragment extends ListFragment implements
		OnItemClickListener {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_samples, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		SamplesAdapter adapter = new SamplesAdapter(getActivity());
		adapter.bind(SamplesController.getInstance().getItems());
		setListAdapter(adapter);

		getListView().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		SamplesItem item = (SamplesItem) getListAdapter().getItem(pos);
		Intent intent = new Intent(getActivity(), item.getActivityToStart());
		startActivity(intent);
	}
}
