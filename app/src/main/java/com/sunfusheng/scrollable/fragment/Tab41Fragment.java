package com.sunfusheng.scrollable.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.base.BaseFragment;
import com.sunfusheng.scrollable.viewbinder.SingleViewBinder;
import com.sunfusheng.scrollable.widget.ScrollableLayout.ScrollableHelper;
import com.sunfusheng.wrapper.RecyclerViewWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class Tab41Fragment extends BaseFragment implements ScrollableHelper.ScrollableViewContainer, RecyclerViewWrapper.OnLoadMoreListener {

    private RecyclerViewWrapper recyclerViewWrapper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab41, container, false);
        recyclerViewWrapper = view.findViewById(R.id.recyclerViewWrapper);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewWrapper.register(Integer.class, new SingleViewBinder());
        recyclerViewWrapper.enableRefresh(false);
        recyclerViewWrapper.setOnLoadMoreListener(this);

        List<Object> items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            items.add(i);
        }

        recyclerViewWrapper.setItems(items);
    }

    @Override
    public View getScrollableView() {
        return recyclerViewWrapper.getRecyclerView();
    }

    @Override
    public void onLoadMore() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            recyclerViewWrapper.setLoadMoreEmpty();
        }, 3000);
    }
}
