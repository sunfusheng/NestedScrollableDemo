package com.sunfusheng.scrollable.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.adpater.MultiItemAdapter;
import com.sunfusheng.scrollable.base.BaseFragment;
import com.sunfusheng.scrollable.model.ModelUtil;

/**
 * Created by sunfusheng on 2017/8/2.
 */
public class Tab22Fragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    private MultiItemAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab22, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.red));
        swipeRefreshLayout.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new MultiItemAdapter(ModelUtil.getTab22Data());
        mAdapter.setOnLoadMoreListener(this, recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        mAdapter.setEnableLoadMore(false);
        new Handler().postDelayed(() -> {
            mAdapter.setEnableLoadMore(true);
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(getContext(), "刷新完成", Toast.LENGTH_SHORT).show();
        }, 2000);
    }

    @Override
    public void onLoadMoreRequested() {
        swipeRefreshLayout.setEnabled(false);
        new Handler().postDelayed(() -> {
            mAdapter.loadMoreEnd(true);
            swipeRefreshLayout.setEnabled(true);
            Toast.makeText(getContext(), "加载完成", Toast.LENGTH_SHORT).show();
        }, 2000);
    }
}
