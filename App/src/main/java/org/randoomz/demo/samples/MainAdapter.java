package org.randoomz.demo.samples;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.randoomz.demo.utils.ui.AbstractAdapter;
import org.randoomz.demo.utils.ui.OnItemListener;

/**
 * Created by Gerard on 14/09/16.
 */
class MainAdapter extends AbstractAdapter<MainAdapter.ViewHolder, MainController.Item> {
  MainAdapter(OnItemListener<MainController.Item> listener) {
    super(listener);
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, MainController.Item item, int position) {
    holder.tvTitle.setText(item.title);
  }

  final class ViewHolder extends AbstractAdapter.ViewHolder {
    TextView tvTitle;

    ViewHolder(View itemView) {
      super(itemView);
      tvTitle = (TextView) itemView.findViewById(android.R.id.text1);
    }
  }
}
