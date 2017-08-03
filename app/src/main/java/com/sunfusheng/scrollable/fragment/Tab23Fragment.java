package com.sunfusheng.scrollable.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.adpater.ListViewAdapter;
import com.sunfusheng.scrollable.base.BaseFragment;
import com.sunfusheng.scrollable.model.ModelUtil;
import com.sunfusheng.scrollable.widget.NestedListView;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class Tab23Fragment extends BaseFragment {

    private NestedListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab23, container, false);
        listView = (NestedListView) view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListViewAdapter adapter = new ListViewAdapter(getContext(), ModelUtil.getTab23Data());
        listView.setAdapter(adapter);
    }

}
