package org.randoomz.demo.design.toolbar;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.randoomz.demo.R;

/**
 * Created by gerard on 20/09/2016.
 */
public class ToolbarSearchActivity extends AppCompatActivity {
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_toolbar_search);

    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

    // Get the intent, verify the action and get the query
    Intent intent = getIntent();
    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
      querySubmit(intent.getStringExtra(SearchManager.QUERY));
    }
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_search, menu);
    MenuItem searchItem = menu.findItem(R.id.action_search);
    MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
      @Override public boolean onMenuItemActionExpand(MenuItem item) {
        // Method called when the search view is expand.
        return true;
      }

      @Override public boolean onMenuItemActionCollapse(MenuItem item) {
        // Method called when the search view is closed.
        return true;
      }
    });

    final SearchView searchView = (SearchView) searchItem.getActionView();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override public boolean onQueryTextSubmit(String query) {
        // Method called when the search is submitted.
        querySubmit(query);
        searchView.clearFocus();
        return true;
      }

      @Override public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.length() < 3) {
          return false;
        }
        // Method called when the text in the search view changes.
        return true;
      }
    });
    final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    return true;
  }

  private void querySubmit(String query) {
    Snackbar.make(findViewById(R.id.content), getString(R.string.search_query, query), Snackbar.LENGTH_SHORT).show();
  }
}
