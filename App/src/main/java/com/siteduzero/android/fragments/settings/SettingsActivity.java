package com.siteduzero.android.fragments.settings;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.siteduzero.android.R;

import java.util.List;

public class SettingsActivity extends PreferenceActivity {
  private static final String ACTION_PREF_EDIT = "com.siteduzero.android.fragments.settings.EDIT";
  private static final String ACTION_PREF_AGENDA = "com.siteduzero.android.fragments.settings.AGENDA";

  @SuppressWarnings("deprecation")
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Preferences for Android 2.3 and lower.
    final String settings = getIntent().getAction();
    // Show screen if a preference if header send an
    if (ACTION_PREF_EDIT.equals(settings)) {
      addPreferencesFromResource(R.xml.settings_edit);
    } else if (ACTION_PREF_AGENDA.equals(settings)) {
      addPreferencesFromResource(R.xml.settings_agenda);
    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
      // Show header if there aren't intent.
      addPreferencesFromResource(R.xml.settings_headers_legacy);
    }
  }

  // This methods is called with Android 3.0 and higher.
  @TargetApi(Build.VERSION_CODES.HONEYCOMB)
  @Override
  public void onBuildHeaders(List<Header> target) {
    loadHeadersFromResource(R.xml.settings_headers, target);
  }

  // AppCompact doesn't support PreferenceActivity.
  // see http://stackoverflow.com/a/27455363
  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    AppBarLayout bar;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      LinearLayout root = (LinearLayout) findViewById(android.R.id.list).getParent().getParent().getParent();
      bar = (AppBarLayout) LayoutInflater.from(this).inflate(R.layout.toolbar_settings, root, false);
      root.addView(bar, 0); // insert at top
    } else {
      ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
      ListView content = (ListView) root.getChildAt(0);

      root.removeAllViews();

      bar = (AppBarLayout) LayoutInflater.from(this).inflate(R.layout.toolbar_settings, root, false);

      TypedValue tv = new TypedValue();
      int height;
      if (getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
        height = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
      } else {
        height = bar.getHeight();
      }
      content.setPadding(0, height, 0, 0);

      root.addView(content);
      root.addView(bar);
    }

    ((Toolbar) bar.findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }

  @Override
  protected boolean isValidFragment(String fragmentName) {
    return SettingsFragment.class.getName().equals(fragmentName);
  }
}
