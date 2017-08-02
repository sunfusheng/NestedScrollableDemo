package com.sunfusheng.scrollable.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.adpater.ListViewAdapter;
import com.sunfusheng.scrollable.base.BaseFragment;
import com.sunfusheng.scrollable.model.Item;
import com.sunfusheng.scrollable.widget.NestedListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class Tab21Fragment extends BaseFragment {

    private NestedListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab21, container, false);
        listView = (NestedListView) view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Item(i + "、NestedListView Item", R.color.md_blue_300));
        }
        ListViewAdapter adapter = new ListViewAdapter(getContext(), list);
        listView.setAdapter(adapter);
    }

}
