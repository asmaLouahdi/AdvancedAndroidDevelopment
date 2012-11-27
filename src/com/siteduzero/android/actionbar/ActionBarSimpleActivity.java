package com.siteduzero.android.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.siteduzero.android.R;

public class ActionBarSimpleActivity extends Activity {
	private ShareActionProvider mShareActionProvider = null;

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

	    MenuItem item = menu.findItem(R.id.menu_share);
	    mShareActionProvider = (ShareActionProvider) item.getActionProvider();

	    Intent intent = new Intent(Intent.ACTION_SEND);
	    intent.setType("text/plain");
	    intent.putExtra(Intent.EXTRA_TEXT, "Message");
	    setShareIntent(intent);
	    
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
