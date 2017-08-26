package org.randoomz.demo.samples.common;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import org.randoomz.demo.R;
import org.randoomz.demo.samples.OnMainNavigationListener;
import org.randoomz.demo.utils.ui.ListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerard on 14/09/16.
 */
public class SampleListFragment extends ListFragment<Item, SampleAdapter, OnMainNavigationListener> {
  public static final String ITEMS = "sample.items";
  public static final String TITLE = "sample.title";
  public static final String GITHUB = "sample.github";
  public static final String ZDS = "sample.zds";

  public static Fragment newInstance(int title, int github, int zds, List<Item> items) {
    final Fragment fragment = new SampleListFragment();
    final Bundle args = new Bundle();
    args.putParcelableArrayList(ITEMS, (ArrayList<? extends Parcelable>) items);
    args.putInt(TITLE, title);
    args.putInt(GITHUB, github);
    args.putInt(ZDS, zds);
    fragment.setArguments(args);
    return fragment;
  }

  @Override protected SampleAdapter initializeAdapter() {
    return new SampleAdapter();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    if (getArguments() == null) {
      throw new RuntimeException("You should have arguments attached to sample fragments.");
    }
    final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
    if (ab != null) {
      ab.setDisplayHomeAsUpEnabled(true);
      ab.setTitle(getArguments().getInt(TITLE));
    }
    final List<Item> items = getArguments().getParcelableArrayList(ITEMS);
    getAdapter().update(items);
  }

  @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.menu_tutorials, menu);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_github:
        goTo(GITHUB);
        return true;
      case R.id.menu_zds:
        goTo(ZDS);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void goTo(String key) {
    if (!getArguments().containsKey(key)) {
      Snackbar.make(getView(), R.string.not_found, Snackbar.LENGTH_SHORT).show();
      return;
    }
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(getArguments().getInt(key)))));
  }

  @Override public void onClick(Item item, int position) {
    startActivity(new Intent(getActivity(), item.activityToStart));
  }
}
