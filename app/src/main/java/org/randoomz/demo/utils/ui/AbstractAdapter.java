package org.randoomz.demo.utils.ui;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerard on 14/09/16.
 */
public abstract class AbstractAdapter<T extends RecyclerView.ViewHolder, I> extends RecyclerView.Adapter<T> {
  private final List<I> items = new ArrayList<>();

  public List<I> items() {
    return items;
  }

  public void update(List<I> items) {
    this.items.clear();
    this.items.addAll(items);
    notifyDataSetChanged();
  }

  @Override public int getItemCount() {
    return items.size();
  }

  @Override public void onBindViewHolder(T holder, int position) {
    onBindViewHolder(holder, items.get(position), position);
  }

  public abstract void onBindViewHolder(T holder, I item, int position);
}
