package org.randoomz.demo.design.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.randoomz.demo.R;
import org.randoomz.demo.samples.common.Item;
import org.randoomz.demo.samples.common.SampleAdapter;
import org.randoomz.demo.utils.ui.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerard on 22/09/2016.
 */
public class ToolbarExtendsActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_toolbar_extends);

    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

    final RecyclerView list = (RecyclerView) findViewById(R.id.list);
    list.setHasFixedSize(true);
    list.addItemDecoration(new DividerItemDecoration(this));

    final SampleAdapter adapter = new SampleAdapter();
    list.setAdapter(adapter);

    List<Item> items = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      items.add(new Item(R.string.title_design_toolbar_extends, null));
    }
    adapter.update(items);
  }
}
