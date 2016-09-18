package org.randoomz.demo.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.randoomz.demo.R;

import org.randoomz.demo.utils.ui.AbstractAdapter;

/**
 * Created by Gerard on 14/09/16.
 */
class SamplesFragmentAdapter extends AbstractAdapter<SamplesFragmentAdapter.ViewHolder, SamplesController.Item> {
  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, SamplesController.Item item, int position) {
    holder.tvTitle.setText(item.title);
  }

  final class ViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;

    ViewHolder(View itemView) {
      super(itemView);
      tvTitle = (TextView) itemView.findViewById(android.R.id.text1);
    }
  }
}
