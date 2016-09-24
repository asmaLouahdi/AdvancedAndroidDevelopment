package org.randoomz.demo.design.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.randoomz.demo.R;
import org.randoomz.demo.fragments.fragments.fixe.FixeFragment;

/**
 * Created by gerard on 22/09/2016.
 */
public class ToolbarTabsActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_toolbar_tabs);

    // Get the ViewPager and set it's PagerAdapter so that it can display items
    final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

    // Give the TabLayout the ViewPager
    final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);
  }

  class PagerAdapter extends FragmentPagerAdapter {
    private final String tabTitles[] = new String[]{"Tab1", "Tab2", "Tab3"};
    private final int PAGE_COUNT = 3;

    PagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public int getCount() {
      return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
      return new FixeFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return tabTitles[position];
    }
  }
}
