package org.randoomz.demo.design;

import org.randoomz.demo.R;
import org.randoomz.demo.design.drawer.DrawerActivity;
import org.randoomz.demo.design.toolbar.ToolbarExtendsActivity;
import org.randoomz.demo.design.toolbar.ToolbarSearchActivity;
import org.randoomz.demo.design.toolbar.ToolbarTabsActivity;
import org.randoomz.demo.samples.common.Item;

import java.util.ArrayList;
import java.util.List;

public class DesignController {
  private static final DesignController INSTANCE = new DesignController();

  public static DesignController get() {
    return INSTANCE;
  }

  public final List<Item> items = new ArrayList<Item>();

  private DesignController() {
    items.add(new Item(R.string.title_design_drawer, DrawerActivity.class));
    items.add(new Item(R.string.title_design_toolbar_search, ToolbarSearchActivity.class));
    items.add(new Item(R.string.title_design_toolbar_extends, ToolbarExtendsActivity.class));
    items.add(new Item(R.string.title_design_toolbar_tabs, ToolbarTabsActivity.class));
  }
}
