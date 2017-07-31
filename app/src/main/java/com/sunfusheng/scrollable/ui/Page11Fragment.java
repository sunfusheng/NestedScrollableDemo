package com.sunfusheng.scrollable.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.adpater.FragmentPagerItemAdapter;
import com.sunfusheng.scrollable.base.BaseFragment;
import com.sunfusheng.scrollable.widget.SmartTabLayout.SmartTabLayout;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class Page11Fragment extends BaseFragment {

    private ViewPager viewPager;
    private SmartTabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page11, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (SmartTabLayout) view.findViewById(R.id.tabLayout);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter.Builder(getContext(), getChildFragmentManager())
                .add("PAGE21", new Page21Fragment())
                .add("PAGE22", new Page21Fragment())
                .add("PAGE23", new Page21Fragment())
                .add("PAGE24", new Page21Fragment())
                .add("PAGE25", new Page21Fragment())
                .build();
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
    }
}
