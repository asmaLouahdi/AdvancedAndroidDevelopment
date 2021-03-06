package org.randoomz.demo.fragments.dynamicui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import org.randoomz.demo.R;

public class CountryListFragment extends ListFragment implements OnItemClickListener {
	private OnCountrySelectedListener mListener = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listview, container, false);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnCountrySelectedListener) activity;
		} catch (ClassCastException e) {
			// Unchecked exception.
			throw new ClassCastException(activity.toString() + " must implement OnCountrySelectedListener");
		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		String[] items = getResources().getStringArray(R.array.list_examples);

		ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
		setListAdapter(aa);

		getListView().setOnItemClickListener(this);
	}

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (mListener != null) {
            mListener.onCountrySelected(position);
        }
    }

	public interface OnCountrySelectedListener {
		void onCountrySelected(int position);
	}
}
