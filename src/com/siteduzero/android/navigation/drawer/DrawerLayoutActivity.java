package com.siteduzero.android.navigation.drawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.siteduzero.android.R;
import com.siteduzero.android.dynamicui.CountryDetailsFragment;
import com.siteduzero.android.dynamicui.CountryListFragment.OnCountrySelectedListener;

public class DrawerLayoutActivity extends FragmentActivity implements
		OnCountrySelectedListener {
	private DrawerLayout mDrawerLayout;
	private ListView mListView;
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] mCountries;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		mListView = (ListView) findViewById(R.id.list);

		mCountries = getResources().getStringArray(R.array.list_examples);

		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mCountries);
		mListView.setAdapter(aa);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				onCountrySelected(arg2);
			}
		});

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close);
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCountrySelected(int position) {
		final CountryDetailsFragment detailsFragment = (CountryDetailsFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragmentDetails);
		detailsFragment.updateCountry(position);
		// Highlight the selected item, update the title, and close the drawer
		mListView.setItemChecked(position, true);
		setTitle(mCountries[position]);
		mDrawerLayout.closeDrawer(mListView);
	}
}
