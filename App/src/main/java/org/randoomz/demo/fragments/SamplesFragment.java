package org.randoomz.demo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.siteduzero.android.R;
import org.randoomz.demo.samples.OnMainNavigationListener;
import org.randoomz.demo.utils.ui.ListFragment;
import org.randoomz.demo.utils.ui.OnItemListener;

/**
 * Created by Gerard on 14/09/16.
 */
public class SamplesFragment extends ListFragment<SamplesFragmentAdapter, OnMainNavigationListener> implements OnItemListener<SamplesController.Item> {
  public static Fragment newInstance() {
    return new SamplesFragment();
  }

  @Override protected SamplesFragmentAdapter initializeAdapter() {
    return new SamplesFragmentAdapter(this);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
    if (ab != null) {
      ab.setDisplayHomeAsUpEnabled(true);
      ab.setTitle(R.string.title_fragment);
    }
    getAdapter().update(SamplesController.getInstance().getItems());
  }

  @Override public void onClick(SamplesController.Item item, int position) {
    startActivity(new Intent(getActivity(), item.activityToStart));
  }
}
