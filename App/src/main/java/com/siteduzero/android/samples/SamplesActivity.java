package com.siteduzero.android.samples;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.siteduzero.android.R;

public class SamplesActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_samples);
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
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
