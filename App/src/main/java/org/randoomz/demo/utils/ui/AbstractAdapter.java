package org.randoomz.demo.utils.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerard on 14/09/16.
 */
public abstract class AbstractAdapter<T extends AbstractAdapter.ViewHolder, I> extends RecyclerView.Adapter<T> {
  private final OnItemListener<I> listener;
  private final List<I> items = new ArrayList<>();

  public AbstractAdapter() {
    this(null);
  }

  public AbstractAdapter(OnItemListener<I> listener) {
    this.listener = listener;
  }

  public void update(List<I> items) {
    this.items.clear();
    this.items.addAll(items);
  }

  @Override public int getItemCount() {
    return items.size();
  }

  @Override public void onBindViewHolder(T holder, int position) {
    onBindViewHolder(holder, items.get(position), position);
  }

  public abstract void onBindViewHolder(T holder, I item, int position);

  public abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ViewHolder(View itemView) {
      super(itemView);
      itemView.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
      if (listener != null) {
        final int position = getLayoutPosition();
        listener.onClick(items.get(position), position);
      }
    }
  }
}
