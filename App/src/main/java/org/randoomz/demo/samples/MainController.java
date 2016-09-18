package org.randoomz.demo.samples;

import android.support.v4.app.Fragment;

import org.randoomz.demo.R;
import org.randoomz.demo.fragments.SamplesFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MainController {
  private static final MainController INSTANCE = new MainController();

  static MainController getInstance() {
    return INSTANCE;
  }

  private List<Item> items = new ArrayList<Item>();

  private MainController() {
    items.add(new Item(R.string.title_fragment, SamplesFragment.class));
  }

  List<Item> getItems() {
    return Collections.unmodifiableList(items);
  }

  class Item {
    final int title;
    final Class<? extends Fragment> fragmentToStart;

    Item(int title, Class<? extends Fragment> fragmentToStart) {
      super();
      this.title = title;
      this.fragmentToStart = fragmentToStart;
    }
  }
}
