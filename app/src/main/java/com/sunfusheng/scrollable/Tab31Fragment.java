package com.sunfusheng.scrollable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunfusheng.scrollable.adpater.MultiItemAdapter;
import com.sunfusheng.scrollable.base.BaseFragment;
import com.sunfusheng.scrollable.model.ModelUtil;
import com.sunfusheng.scrollable.widget.ScrollableLayout.ScrollableHelper;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class Tab31Fragment extends BaseFragment implements ScrollableHelper.ScrollableViewContainer {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab31, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MultiItemAdapter adapter = new MultiItemAdapter(ModelUtil.getTab23Data());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View getScrollableView() {
        return recyclerView;
    }
}
