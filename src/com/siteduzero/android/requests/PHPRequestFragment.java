package com.siteduzero.android.requests;

import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siteduzero.android.R;

public class PHPRequestFragment extends ListFragment {
	private ProductAdapter mAdapter;
	private WebAsyncTask mWebAsyncTask;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listview, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (mWebAsyncTask != null) {
			mWebAsyncTask.mFragment = this;
		} else {
			startWebAsyncTask();
		}

		mAdapter = new ProductAdapter(getActivity());
		getListView().setAdapter(mAdapter);
	}

	@Override
	public void onDetach() {
		super.onDetach();
		if (mWebAsyncTask != null) {
			mWebAsyncTask.mFragment = null;
		}
	}

	private void startWebAsyncTask() {
		if (getActivity() != null) {
			this.mWebAsyncTask = new WebAsyncTask(this);
			this.mWebAsyncTask.execute();
		}
	}

	private static class WebAsyncTask extends
			AsyncTask<Void, Void, List<Product>> {
		private PHPRequestFragment mFragment;
		private final ProductManager mPHPLocalManager = new ProductManager();

		public WebAsyncTask(final PHPRequestFragment fragment) {
			this.mFragment = fragment;
		}

		@Override
		protected List<Product> doInBackground(Void... params) {
			return mPHPLocalManager.downloadProducts();
		}

		@Override
		protected void onPostExecute(List<Product> results) {
			super.onPostExecute(results);
			if (mFragment != null && results != null && !results.isEmpty()) {
				mFragment.mAdapter.bind(results);
				mFragment.mAdapter.notifyDataSetChanged();
			}
		}
	}
}
