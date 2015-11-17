package com.siteduzero.android.samples;

import com.siteduzero.android.R;
import com.siteduzero.android.dialog.DialogActivity;
import com.siteduzero.android.dynamicui.DynamicUIActivity;
import com.siteduzero.android.fragments.dynamic.DynamicActivity;
import com.siteduzero.android.fragments.fixe.FixeActivity;
import com.siteduzero.android.lists.custom.CustomListActivity;
import com.siteduzero.android.lists.dynamic.DynamicListActivity;
import com.siteduzero.android.lists.simple.SimpleListActivity;
import com.siteduzero.android.settings.UsingSettingsActivity;

import java.util.ArrayList;
import java.util.List;

public class SamplesController {
  private static final SamplesController INSTANCE = new SamplesController();
  private List<SamplesItem> mItems = new ArrayList<SamplesItem>();

  public SamplesController() {
    mItems.add(new SamplesItem(R.string.title_fragment_fixe, R.string.chapter_1, FixeActivity.class));
    mItems.add(new SamplesItem(R.string.title_fragment_dynamic, R.string.chapter_1, DynamicActivity.class));
    mItems.add(new SamplesItem(R.string.title_listfragment_simple, R.string.chapter_2, SimpleListActivity.class));
    mItems.add(new SamplesItem(R.string.title_listfragment_custom, R.string.chapter_2, CustomListActivity.class));
    mItems.add(new SamplesItem(R.string.title_listfragment_dynamic, R.string.chapter_2, DynamicListActivity.class));
    mItems.add(new SamplesItem(R.string.title_dynamic_ui, R.string.chapter_3, DynamicUIActivity.class));
    mItems.add(new SamplesItem(R.string.title_fragment_settings, R.string.chapter_4, UsingSettingsActivity.class));
    mItems.add(new SamplesItem(R.string.title_fragment_dialog, R.string.chapter_5, DialogActivity.class));
  }

  public static SamplesController getInstance() {
    return INSTANCE;
  }

  public List<SamplesItem> getItems() {
    return mItems;
  }
}
