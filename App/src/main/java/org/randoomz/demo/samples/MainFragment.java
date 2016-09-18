package org.randoomz.demo.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.randoomz.demo.R;

import org.randoomz.demo.utils.ui.ListFragment;

public class MainFragment extends ListFragment<MainController.Item, MainAdapter, OnMainNavigationListener> {
  public static Fragment newInstance() {
    return new MainFragment();
  }

  @Override protected MainAdapter initializeAdapter() {
    return new MainAdapter();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
    if (ab != null) {
      ab.setDisplayHomeAsUpEnabled(false);
      ab.setTitle(getString(R.string.app_name));
    }
    getAdapter().update(MainController.getInstance().getItems());
  }

  @Override public void onClick(MainController.Item item, int position) {
    getNavigationListener().goToFragmentsList();
  }
}
