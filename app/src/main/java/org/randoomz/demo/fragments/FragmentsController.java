package org.randoomz.demo.fragments;

import org.randoomz.demo.R;
import org.randoomz.demo.fragments.dialog.DialogActivity;
import org.randoomz.demo.fragments.dynamicui.DynamicUIActivity;
import org.randoomz.demo.fragments.fragments.dynamic.DynamicActivity;
import org.randoomz.demo.fragments.fragments.fixe.FixeActivity;
import org.randoomz.demo.fragments.lists.custom.CustomListActivity;
import org.randoomz.demo.fragments.lists.dynamic.DynamicListActivity;
import org.randoomz.demo.fragments.lists.simple.SimpleListActivity;
import org.randoomz.demo.fragments.settings.UsingSettingsActivity;
import org.randoomz.demo.samples.common.Item;

import java.util.ArrayList;
import java.util.List;

public class FragmentsController {
  private static final FragmentsController INSTANCE = new FragmentsController();

  public static FragmentsController get() {
    return INSTANCE;
  }

  public final List<Item> items = new ArrayList<Item>();

  private FragmentsController() {
    items.add(new Item(R.string.title_fragment_fixe, FixeActivity.class));
    items.add(new Item(R.string.title_fragment_dynamic, DynamicActivity.class));
    items.add(new Item(R.string.title_listfragment_simple, SimpleListActivity.class));
    items.add(new Item(R.string.title_listfragment_custom, CustomListActivity.class));
    items.add(new Item(R.string.title_listfragment_dynamic, DynamicListActivity.class));
    items.add(new Item(R.string.title_dynamic_ui, DynamicUIActivity.class));
    items.add(new Item(R.string.title_fragment_settings, UsingSettingsActivity.class));
    items.add(new Item(R.string.title_fragment_dialog, DialogActivity.class));
  }
}
