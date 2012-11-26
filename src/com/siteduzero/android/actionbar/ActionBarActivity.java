package com.siteduzero.android.actionbar;

import com.siteduzero.android.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ActionBarActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_actionbar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, R.string.toast_add, Toast.LENGTH_SHORT).show();
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
