package com.sunfusheng.scrollable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.sunfusheng.scrollable.base.BaseActivity;
import com.sunfusheng.scrollable.ui.Tab11Fragment;
import com.sunfusheng.scrollable.widget.BottomTabBar;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private BottomTabBar bottomTabBar;
    private TextView tab11;
    private TextView tab12;
    private TextView tab13;
    private TextView tab14;

    private Fragment[] fragments = {
            new Tab11Fragment(),
            new Tab11Fragment(),
            new Tab11Fragment(),
            new Tab11Fragment()
    };

    private static final String[] TAGS = {
            "tab11",
            "tab12",
            "tab13",
            "tab14"
    };

    private static int lastPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bottomTabBar.setSelected(lastPosition);
        showFragment(lastPosition, fragments[lastPosition]);
    }

    private void initView() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);
        tab11 = (TextView) findViewById(R.id.tab11);
        tab12 = (TextView) findViewById(R.id.tab12);
        tab13 = (TextView) findViewById(R.id.tab13);
        tab14 = (TextView) findViewById(R.id.tab14);

        tab11.setOnClickListener(this);
        tab12.setOnClickListener(this);
        tab13.setOnClickListener(this);
        tab14.setOnClickListener(this);
    }

    private void showFragment(int position, Fragment fragment) {
        setBackPressedFragment(fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment oldFragment = fragmentManager.findFragmentByTag(TAGS[lastPosition]);
        if (oldFragment != null) {
            fragmentTransaction.hide(oldFragment);
        }
        lastPosition = position;
        Fragment curFragment = fragmentManager.findFragmentByTag(TAGS[position]);
        if (curFragment != null) {
            fragmentTransaction.show(curFragment);
        } else {
            fragmentTransaction.add(R.id.fl_container, fragment, TAGS[position]);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab11:
                bottomTabBar.setSelected(0);
                showFragment(0, fragments[0]);
                break;
            case R.id.tab12:
                bottomTabBar.setSelected(1);
                showFragment(1, fragments[1]);
                break;
            case R.id.tab13:
                bottomTabBar.setSelected(2);
                showFragment(2, fragments[2]);
                break;
            case R.id.tab14:
                bottomTabBar.setSelected(3);
                showFragment(3, fragments[3]);
                break;
        }
    }
}
