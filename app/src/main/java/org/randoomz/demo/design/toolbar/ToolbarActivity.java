package org.randoomz.demo.design.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import org.randoomz.demo.R;

/**
 * Created by gerard on 25/09/2016.
 */
public class ToolbarActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_toolbar);
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_toolbar, menu);
    return super.onCreateOptionsMenu(menu);
  }
}
