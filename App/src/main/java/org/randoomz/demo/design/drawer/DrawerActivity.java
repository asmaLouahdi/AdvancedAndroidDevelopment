package org.randoomz.demo.design.drawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import org.randoomz.demo.R;

/**
 * Created by gerard on 18/09/2016.
 */

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  private DrawerLayout drawerLayout;
  private ActionBarDrawerToggle toggle;
  private NavigationView navigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drawer);

    final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle(R.string.title_design_drawer);
    setSupportActionBar(toolbar);

    drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
    drawerLayout.addDrawerListener(toggle);

    navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (toggle.onOptionsItemSelected(item)) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    final MenuItem dynamicItem = navigationView.getMenu().findItem(R.id.menu_dynamic);
    final SubMenu subMenu = dynamicItem.getSubMenu();
    switch (item.getItemId()) {
      case R.id.menu_add:
        subMenu.add(Menu.NONE, subMenu.size(), subMenu.size(), getString(R.string.menu_sub_item, subMenu.size()));
        return true;
      case R.id.menu_delete:
        subMenu.removeItem(subMenu.size() - 1);
        return true;
    }
    Snackbar.make(drawerLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
    drawerLayout.closeDrawers();
    return true;
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    toggle.onConfigurationChanged(newConfig);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    toggle.syncState();
  }
}
