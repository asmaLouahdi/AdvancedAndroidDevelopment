package org.randoomz.demo.fragments;

import android.app.Activity;

import org.randoomz.demo.R;
import org.randoomz.demo.fragments.dialog.DialogActivity;
import org.randoomz.demo.fragments.dynamicui.DynamicUIActivity;
import org.randoomz.demo.fragments.fragments.dynamic.DynamicActivity;
import org.randoomz.demo.fragments.fragments.fixe.FixeActivity;
import org.randoomz.demo.fragments.lists.custom.CustomListActivity;
import org.randoomz.demo.fragments.lists.dynamic.DynamicListActivity;
import org.randoomz.demo.fragments.lists.simple.SimpleListActivity;
import org.randoomz.demo.fragments.settings.UsingSettingsActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SamplesController {
  private static final SamplesController INSTANCE = new SamplesController();

  static SamplesController getInstance() {
    return INSTANCE;
  }

  private List<Item> items = new ArrayList<Item>();

  private SamplesController() {
    items.add(new Item(R.string.title_fragment_fixe, FixeActivity.class));
    items.add(new Item(R.string.title_fragment_dynamic, DynamicActivity.class));
    items.add(new Item(R.string.title_listfragment_simple, SimpleListActivity.class));
    items.add(new Item(R.string.title_listfragment_custom, CustomListActivity.class));
    items.add(new Item(R.string.title_listfragment_dynamic, DynamicListActivity.class));
    items.add(new Item(R.string.title_dynamic_ui, DynamicUIActivity.class));
    items.add(new Item(R.string.title_fragment_settings, UsingSettingsActivity.class));
    items.add(new Item(R.string.title_fragment_dialog, DialogActivity.class));
  }

  List<Item> getItems() {
    return Collections.unmodifiableList(items);
  }

  class Item {
    final int title;
    final Class<? extends Activity> activityToStart;

    Item(int title, Class<? extends Activity> activityToStart) {
      super();
      this.title = title;
      this.activityToStart = activityToStart;
    }
  }
}
