package com.siteduzero.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import com.siteduzero.android.actionbar.ActionBarActivity;
import com.siteduzero.android.actionbar.ActionBarContextualActivity;
import com.siteduzero.android.dialog.DialogActivity;
import com.siteduzero.android.fragments.dynamic.DynamicActivity;
import com.siteduzero.android.fragments.fixe.FixeActivity;
import com.siteduzero.android.lists.ListViewActivity;
import com.siteduzero.android.nfc.NFCActivity;
import com.siteduzero.android.notifications.NotificationsActivity;
import com.siteduzero.android.settings.UsingSettingsActivity;

public class MainActivity extends ListActivity implements OnItemClickListener {
	private String[] mItems = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mItems = getResources().getStringArray(R.array.list_samples);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mItems));

		getListView().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		if (mItems[pos].equals("Fixe fragment")) {
			startActivity(new Intent(this, FixeActivity.class));
		} else if (mItems[pos].equals("Dynamic fragment")) {
			Intent i = new Intent(this, DynamicActivity.class);
			i.putExtra("fragment", "Dynamic1Fragment");
			startActivity(i);
		} else if (mItems[pos].equals("Dialog")) {
			startActivity(new Intent(this, DialogActivity.class));
		} else if (mItems[pos].equals("Simple List")) {
			Intent i = new Intent(this, ListViewActivity.class);
			i.putExtra("fragment", "SimpleListViewFragment");
			startActivity(i);
		} else if (mItems[pos].equals("Custom List")) {
			Intent i = new Intent(this, ListViewActivity.class);
			i.putExtra("fragment", "CustomListViewFragment");
			startActivity(i);
		} else if (mItems[pos].equals("Dynamic List")) {
			Intent i = new Intent(this, ListViewActivity.class);
			i.putExtra("fragment", "DynamicListViewFragment");
			startActivity(i);
		} else if (mItems[pos].equals("Nfc")) {
			startActivity(new Intent(this, NFCActivity.class));
		} else if (mItems[pos].equals("Notifications")) {
			startActivity(new Intent(this, NotificationsActivity.class));
		} else if (mItems[pos].equals("Settings Preferences")) {
			startActivity(new Intent(this, UsingSettingsActivity.class));
		} else if (mItems[pos].equals("Actionbar contextual")) {
			startActivity(new Intent(this, ActionBarContextualActivity.class));
		} else if (mItems[pos].equals("Actionbar")) {
			startActivity(new Intent(this, ActionBarActivity.class));
		}
	}
}
