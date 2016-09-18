package org.randoomz.demo.fragments.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.siteduzero.android.R;

public class UsingSettingsActivity extends AppCompatActivity {
  private TextView mTextViewPref1;
  private TextView mTextViewPref2;
  private TextView mTextViewPref3;
  private TextView mTextViewPref4;
  private TextView mTextViewPref5;
  private TextView mTextViewPref6;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_using_settings);
    mTextViewPref1 = (TextView) findViewById(R.id.textViewPref1);
    mTextViewPref2 = (TextView) findViewById(R.id.textViewPref2);
    mTextViewPref3 = (TextView) findViewById(R.id.textViewPref3);
    mTextViewPref4 = (TextView) findViewById(R.id.textViewPref4);
    mTextViewPref5 = (TextView) findViewById(R.id.textViewPref5);
    mTextViewPref6 = (TextView) findViewById(R.id.textViewPref6);
  }

  @Override
  protected void onResume() {
    super.onResume();
    refresh();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_using_settings, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_settings:
        startActivity(new Intent(this, SettingsActivity.class));
        return true;
    }
    return false;
  }

  private void refresh() {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    boolean pref1 = prefs.getBoolean("pref_key_pref_1", false);
    mTextViewPref1.setText("" + pref1);
    String pref2 = prefs.getString("pref_key_pref_2", "Nothing");
    mTextViewPref2.setText("" + pref2);
    boolean pref3 = prefs.getBoolean("pref_key_pref_3", false);
    mTextViewPref3.setText("" + pref3);
    String pref4 = prefs.getString("pref_key_pref_4", "Nothing");
    mTextViewPref4.setText("" + pref4);
    String pref5 = prefs.getString("pref_key_pref_5", "Nothing");
    mTextViewPref5.setText("" + pref5);
    String pref6 = prefs.getString("pref_key_pref_6", "Nothing");
    mTextViewPref6.setText("" + pref6);
  }
}
