package com.sunfusheng.scrollable.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.adapter.FragmentPagerItemAdapter;
import com.sunfusheng.scrollable.base.BaseFragment;
import com.sunfusheng.scrollable.util.ColorUtil;
import com.sunfusheng.scrollable.widget.ScrollableLayout.ScrollableHelper;
import com.sunfusheng.scrollable.widget.ScrollableLayout.ScrollableLayout;
import com.sunfusheng.scrollable.widget.SmartTabLayout.SmartTabLayout;

/**
 * Created by sunfusheng on 2017/8/3.
 */
public class Tab14Fragment extends BaseFragment {

    private ScrollableLayout scrollableLayout;
    private SmartTabLayout tabLayout;
    private ViewPager viewPager;
    private View headerView;

    private boolean hasInstantiate = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab14, container, false);
        scrollableLayout = view.findViewById(R.id.scrollableLayout);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        headerView = view.findViewById(R.id.headerView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter.Builder(getContext(), getChildFragmentManager())
                .add("TAB31", new Tab41Fragment())
                .add("TAB32", new Tab41Fragment())
                .add("TAB33", new Tab41Fragment())
                .add("TAB34", new Tab41Fragment())
                .add("TAB35", new Tab41Fragment())
                .add("TAB36", new Tab41Fragment())
                .build();
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);

        scrollableLayout.setOnScrollListener((scrollY, offsetY, maxY) -> {
            float fraction = offsetY * 1f / maxY;
            Log.d("--->", "offsetY:" + offsetY + " maxY:" + maxY + " fraction:" + fraction);
            headerView.setBackgroundColor(ColorUtil.getNewColorByStartEndColor(getContext(), fraction, R.color.c6, R.color.c5));
        });

        adapter.setOnInstantiateFragmentListener((position, fragment, args) -> {
            if (!hasInstantiate) {
                hasInstantiate = true;
                scrollableLayout.getHelper().setScrollableViewContainer((ScrollableHelper.ScrollableViewContainer) adapter.getFragment(0));
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                scrollableLayout.getHelper().setScrollableViewContainer((ScrollableHelper.ScrollableViewContainer) adapter.getFragment(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
