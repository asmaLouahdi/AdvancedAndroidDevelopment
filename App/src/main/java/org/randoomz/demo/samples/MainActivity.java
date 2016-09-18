package org.randoomz.demo.samples;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.randoomz.demo.R;
import org.randoomz.demo.fragments.SamplesFragment;

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
        .replace(R.id.content, SamplesFragment.newInstance())
        .addToBackStack(null)
        .commit();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        getSupportFragmentManager().popBackStack();
        return true;
      case R.id.menu_github:
        goToSourceCodes();
        return true;
      case R.id.menu_zds:
        goToZdS();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void goToZdS() {
    Intent i = new Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://zestedesavoir.com/tutoriels/609/aller-plus-loin-dans-le-developpement-android-1/"));
    startActivity(i);
  }

  private void goToSourceCodes() {
    Intent i = new Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://github.com/GerardPaligot/AdvancedAndroidDevelopment"));
    startActivity(i);
  }
}
