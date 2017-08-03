package com.sunfusheng.scrollable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.base.BaseFragment;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class Tab31Fragment extends BaseFragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab31, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
