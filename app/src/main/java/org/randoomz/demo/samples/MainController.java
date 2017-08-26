package org.randoomz.demo.samples;

import org.randoomz.demo.R;

import java.util.ArrayList;
import java.util.List;

class MainController {
  private static final MainController INSTANCE = new MainController();

  static MainController get() {
    return INSTANCE;
  }

  public final List<Item> items = new ArrayList<Item>();

  private MainController() {
    items.add(new Item(R.string.title_fragment, OnMainNavigationListener.FRAGMENTS));
    items.add(new Item(R.string.title_design, OnMainNavigationListener.DESIGN));
  }

  class Item {
    final int title;
    final String fragmentToStart;

    Item(int title, String fragmentToStart) {
      super();
      this.title = title;
      this.fragmentToStart = fragmentToStart;
    }
  }
}
