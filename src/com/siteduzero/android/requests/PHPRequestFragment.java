package com.siteduzero.android.requests;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siteduzero.android.R;

public class PHPRequestFragment extends ListFragment implements
		LoaderManager.LoaderCallbacks<ListProduct> {
	private ProductAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listview, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mAdapter = new ProductAdapter(getActivity());
		setListAdapter(mAdapter);

		getLoaderManager().initLoader(0, null, this);
	}

	@Override
	public Loader<ListProduct> onCreateLoader(int id, Bundle args) {
		return new ProductsAsyncTaskLoader(getActivity());
	}

	@Override
	public void onLoadFinished(Loader<ListProduct> loader, ListProduct data) {
		if (data != null && !data.getProducts().isEmpty()) {
			mAdapter.bind(data.getProducts());
			mAdapter.notifyDataSetChanged();
		}
	}

	@Override
	public void onLoaderReset(Loader<ListProduct> loader) {
		// Nothing to do here.
	}
}
