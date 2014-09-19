package com.siteduzero.android.actionbar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.siteduzero.android.R;

public class ActionBarContextualListActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_list);

        final ListView list = (ListView) findViewById(R.id.action_bar_contextual_list);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.list_examples,
                        android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                startSupportActionMode(mActionMode);
                return true;
            }
        });
    }

    final ActionMode.Callback mActionMode = new ActionMode.Callback() {

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
    };

}
