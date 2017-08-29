package com.sunfusheng.scrollable.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.adapter.FragmentPagerItemAdapter;
import com.sunfusheng.scrollable.base.BaseFragment;
import com.sunfusheng.scrollable.widget.SmartTabLayout.SmartTabLayout;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class Tab11Fragment extends BaseFragment {

    private SmartTabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab11, container, false);
        tabLayout = (SmartTabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter.Builder(getContext(), getChildFragmentManager())
                .add("TAB22", new Tab22Fragment())
                .add("TAB23", new Tab23Fragment())
                .add("TAB21", new Tab21Fragment())
                .build();
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setViewPager(viewPager);
    }
}
