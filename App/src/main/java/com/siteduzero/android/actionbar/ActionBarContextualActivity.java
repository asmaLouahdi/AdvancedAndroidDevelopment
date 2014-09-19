package com.siteduzero.android.actionbar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.siteduzero.android.R;

public class ActionBarContextualActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contextual);
	}

	public void changeContextual(View view) {
        startSupportActionMode(new ActionMode.Callback() {

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Handle click on contextual item menu.
                switch (item.getItemId()) {
                    case R.id.menu_trash:
                        Toast.makeText(getApplicationContext(), R.string.toast_trash, Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the contextual menu.
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_contextual, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
        });
	}
}
