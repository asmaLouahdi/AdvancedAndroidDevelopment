package org.randoomz.demo.utils.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siteduzero.android.R;

/**
 * Created by Gerard on 14/09/16.
 */

public abstract class ListFragment<T extends RecyclerView.Adapter<?>, N extends OnNavigationListener> extends Fragment {
  private final boolean hasFixedSize;
  private RecyclerView list;
  private T adapter;
  private N listener;

  public ListFragment() {
    this(true);
  }

  public ListFragment(boolean hasFixedSize) {
    this.hasFixedSize = hasFixedSize;
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    adapter = initializeAdapter();
    try {
      listener = (N) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement navigation listener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    listener = null;
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    final View inflate = inflater.inflate(R.layout.view_recycler_list, container, false);
    list = (RecyclerView) inflate.findViewById(R.id.list);
    return inflate;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    list.setHasFixedSize(hasFixedSize);
    list.setLayoutManager(new LinearLayoutManager(getContext()));
    list.addItemDecoration(new DividerItemDecoration(getContext()));
    setListAdapter(adapter);
  }

  public void setListAdapter(RecyclerView.Adapter<?> adapter) {
    if (list != null) {
      list.setAdapter(adapter);
    }
  }

  public RecyclerView getRecyclerView() {
    return list;
  }

  public T getAdapter() {
    return adapter;
  }

  public N getNavigationListener() {
    return listener;
  }

  protected abstract T initializeAdapter();
}
