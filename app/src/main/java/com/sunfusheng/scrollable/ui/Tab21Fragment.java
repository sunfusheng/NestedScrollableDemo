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
public class Tab21Fragment extends BaseFragment {

    private ViewPager viewPager;
    private SmartTabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab21, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (SmartTabLayout) view.findViewById(R.id.tabLayout);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter.Builder(getContext(), getChildFragmentManager())
                .add("TAB31", new Tab31Fragment())
                .add("TAB32", new Tab31Fragment())
                .add("TAB33", new Tab31Fragment())
                .add("TAB34", new Tab31Fragment())
                .add("TAB35", new Tab31Fragment())
                .add("TAB36", new Tab31Fragment())
                .build();
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
    }
}
