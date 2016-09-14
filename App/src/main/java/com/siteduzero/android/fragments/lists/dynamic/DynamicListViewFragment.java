package com.siteduzero.android.fragments.lists.dynamic;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siteduzero.android.R;

public class DynamicListViewFragment extends ListFragment {
    public static final String TAG = "DynamicListViewFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DynamicListViewModel header = new DynamicListViewModel(R.drawable.ic_launcher, R.string.default_lorem);

        DynamicListViewAdapter adapter = new DynamicListViewAdapter(getActivity());
        adapter.add(header);
        adapter.add(R.string.default_lorem);
        adapter.add(R.string.default_lorem);
        setListAdapter(adapter);
    }
}
