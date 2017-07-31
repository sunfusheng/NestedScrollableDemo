package com.sunfusheng.scrollable.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    private boolean isViewCreated = false;
    private boolean isPagerVisible = false;
    private boolean isLoaded = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isPagerVisible = isVisibleToUser;
        if (isVisibleToUser) {
            lazyLoad();
        }
    }

    public boolean isVisibleNow() {
        return isViewCreated && isPagerVisible;
    }

    private void lazyLoad() {
        if (isVisibleNow() && !isLoaded) {
            isLoaded = true;
            onLazyLoad();
        }
    }

    protected void onLazyLoad() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated = false;
        isPagerVisible = false;
    }

    public boolean onBackPressed() {
        return false;
    }
}

