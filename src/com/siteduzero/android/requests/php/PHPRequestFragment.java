package com.siteduzero.android.requests.php;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.siteduzero.android.R;

public class PHPRequestFragment extends ListFragment {
	private final List<String> mItems = new ArrayList<String>();
	private ArrayAdapter<String> mAdapter;
	private WebAsyncTask mWebAsyncTask;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listview, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);
		if (mWebAsyncTask != null) {
			mWebAsyncTask.mFragment = this;
		} else {
			startWebAsyncTask();
		}

		mAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, mItems);
		getListView().setAdapter(mAdapter);
	}

	@Override
	public void onDetach() {
		super.onDetach();
		if (mWebAsyncTask != null) {
			mWebAsyncTask.mFragment = null;
		}
	}

	private static class WebAsyncTask extends
			AsyncTask<Void, Void, List<String>> {
		PHPRequestFragment mFragment;
		ProductManager mPHPLocalManager = new ProductManager();

		public WebAsyncTask(PHPRequestFragment fragment) {
			this.mFragment = fragment;
		}

		@Override
		protected List<String> doInBackground(Void... params) {
			return mPHPLocalManager.downloadProducts();
		}

		@Override
		protected void onPostExecute(List<String> result) {
			super.onPostExecute(result);
			if (mFragment != null && result != null && !result.isEmpty()) {
				mFragment.mItems.addAll(result);
				mFragment.mAdapter.notifyDataSetChanged();
			}
		}
	}

	private void startWebAsyncTask() {
		if (getActivity() != null) {
			this.mWebAsyncTask = new WebAsyncTask(this);
			this.mWebAsyncTask.execute();
		}
	}
}
