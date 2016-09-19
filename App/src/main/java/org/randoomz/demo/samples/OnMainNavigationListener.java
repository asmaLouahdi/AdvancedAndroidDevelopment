package org.randoomz.demo.samples;

import org.randoomz.demo.utils.ui.OnNavigationListener;

/**
 * @author Gerard Paligot
 */
public interface OnMainNavigationListener extends OnNavigationListener {
  String FRAGMENTS = "sample.fragments";

  String DESIGN = "sample.design";

  void goToFragmentsList();

  void goToDesignsList();
}
