package org.randoomz.demo.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.randoomz.demo.R;
import org.randoomz.demo.design.DesignController;
import org.randoomz.demo.fragments.FragmentsController;
import org.randoomz.demo.samples.common.SampleListFragment;

public class MainActivity extends AppCompatActivity implements OnMainNavigationListener {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .replace(R.id.content, MainFragment.newInstance())
          .commit();
    }
  }

  @Override public void goToFragmentsList() {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, SampleListFragment.newInstance(R.string.title_fragment, R.string.menu_fragment_github, R.string.menu_fragment_zds, FragmentsController.get().items))
        .addToBackStack(null)
        .commit();
  }

  @Override public void goToDesignsList() {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, SampleListFragment.newInstance(R.string.title_design, R.string.menu_design_github, R.string.menu_design_zds, DesignController.get().items))
        .addToBackStack(null)
        .commit();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        getSupportFragmentManager().popBackStack();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
