package com.sunfusheng.scrollable;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sunfusheng.scrollable.adpater.FragmentPagerItemAdapter;
import com.sunfusheng.scrollable.ui.Page11Fragment;
import com.sunfusheng.scrollable.widget.SmartTabLayout.SmartTabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (SmartTabLayout) findViewById(R.id.tabLayout);
    }

    private void initViewPager() {
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter.Builder(this, getSupportFragmentManager())
                .add("PAGE11", new Page11Fragment())
                .add("PAGE12", new Page11Fragment())
                .add("PAGE13", new Page11Fragment())
                .add("PAGE14", new Page11Fragment())
                .add("PAGE15", new Page11Fragment())
                .build();
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
    }

}
