package com.sunfusheng.scrollable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.sunfusheng.scrollable.base.BaseActivity;
import com.sunfusheng.scrollable.widget.BottomTabBar;

public class MainActivity extends BaseActivity {

    private BottomTabBar bottomTabBar;

    private Fragment[] fragments = {
            new Tab11Fragment(),
            new Tab12Fragment(),
            new Tab13Fragment(),
            new Tab14Fragment()
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
        bottomTabBar.setOnItemClickListener(position -> {
            showFragment(position, fragments[position]);
        });
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

}
