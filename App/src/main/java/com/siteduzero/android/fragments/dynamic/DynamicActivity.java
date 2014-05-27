package com.siteduzero.android.fragments.dynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.siteduzero.android.R;

public class DynamicActivity extends FragmentActivity {
    private static final String KEY_FRAGMENT = "fragment_save";

    private String mCurrentFragment;
    // We instantiate just one time fragments during the live of the activity.
    private final Dynamic1Fragment mDynamic1Fragment = new Dynamic1Fragment();
    private final Dynamic2Fragment mDynamic2Fragment = new Dynamic2Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);

        // Retrieve the fragment saved or we display a default fragment.
        if (savedInstanceState != null) {
            mCurrentFragment = savedInstanceState.getString(KEY_FRAGMENT);
        } else {
            mCurrentFragment = Dynamic1Fragment.TAG;
        }

        // Display the current fragment.
        if (Dynamic1Fragment.TAG.equals(mCurrentFragment)) {
            showFragment(this.mDynamic1Fragment, Dynamic1Fragment.TAG);
        } else if (Dynamic2Fragment.TAG.equals(mCurrentFragment)) {
            showFragment(this.mDynamic2Fragment, Dynamic2Fragment.TAG);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_FRAGMENT, mCurrentFragment != null ? mCurrentFragment : "");
        super.onSaveInstanceState(outState);
    }

    private void showFragment(final Fragment fragment, String tag) {
        if (fragment == null) {
            return;
        }

        // Update current fragment.
        mCurrentFragment = tag;
        // Begin a fragment transaction.
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        // We can also animate the changing of fragment.
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        // Replace current fragment by the new one.
        ft.replace(R.id.frameLayoutListView, fragment);
        // Null on the back stack to return on the previous fragment when user press on back button.
        ft.addToBackStack(null);

        // Commit changes.
        ft.commit();
    }

    public void goToFragment1(View v) {
        showFragment(this.mDynamic1Fragment, Dynamic1Fragment.TAG);
    }

    public void goToFragment2(View v) {
        showFragment(this.mDynamic2Fragment, Dynamic2Fragment.TAG);
    }
}
