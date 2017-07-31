package com.sunfusheng.scrollable.base;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {

    private BaseFragment mBackPressedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initToolbar(Toolbar toolbar, @StringRes int resId, boolean showHomeAsUp) {
        initToolbar(toolbar, getString(resId), showHomeAsUp);
    }

    protected void initToolbar(Toolbar toolbar, String title, boolean showHomeAsUp) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
    }

    @Override
    public void onBackPressed() {
        if (mBackPressedFragment == null || !mBackPressedFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void setBackPressedFragment(Fragment fragment) {
        if (fragment instanceof BaseFragment) {
            this.mBackPressedFragment = (BaseFragment) fragment;
        }
    }
}
