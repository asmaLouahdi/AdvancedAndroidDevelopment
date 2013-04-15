package com.siteduzero.android.actionbar;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.ArrayAdapter;
import android.widget.ShareActionProvider;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.siteduzero.android.R;

public class ActionBarSimpleActivity extends Activity {
	private ShareActionProvider mShareActionProvider = null;
	private SearchView mSearchView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		final SpinnerAdapter spinnerAdapter = ArrayAdapter.createFromResource(
				this, R.array.list_examples,
				android.R.layout.simple_spinner_dropdown_item);
		final OnNavigationListener onNavigationListener = new OnNavigationListener() {
			@Override
			public boolean onNavigationItemSelected(int itemPosition,
					long itemId) {
				// Implement this method to attach a behavior to your drop down
				// menu.
				return false;
			}
		};
		actionBar.setListNavigationCallbacks(spinnerAdapter,
				onNavigationListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_actionbar, menu);

		// ShareActionProvider
		MenuItem itemProvider = menu.findItem(R.id.menu_share);
		mShareActionProvider = (ShareActionProvider) itemProvider
				.getActionProvider();

		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, "Message");
		setShareIntent(intent);

		// SearchView
		MenuItem itemSearch = menu.findItem(R.id.menu_search);
		mSearchView = (SearchView) itemSearch.getActionView();
		mSearchView.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String query) {
				Toast.makeText(getApplicationContext(),
						R.string.toast_search_submit, Toast.LENGTH_SHORT)
						.show();
				return true;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				return false;
			}
		});

		return true;
	}

	private void setShareIntent(Intent shareIntent) {
		if (mShareActionProvider != null) {
			mShareActionProvider.setShareIntent(shareIntent);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, R.string.toast_home, Toast.LENGTH_SHORT)
					.show();
			return true;
		case R.id.menu_add:
			Toast.makeText(this, R.string.toast_add, Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menu_save:
			Toast.makeText(this, R.string.toast_save, Toast.LENGTH_SHORT)
					.show();
			return true;
		case R.id.menu_crop:
			Toast.makeText(this, R.string.toast_crop, Toast.LENGTH_SHORT)
					.show();
			return true;
		}
		return false;
	}
}
