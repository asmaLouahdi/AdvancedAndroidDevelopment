package com.siteduzero.android.lists.custom;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.siteduzero.android.R;

public class CustomListActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_custom);
	}
}
