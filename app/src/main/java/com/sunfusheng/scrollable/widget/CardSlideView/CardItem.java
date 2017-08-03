package com.sunfusheng.scrollable.widget.CardSlideView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardItem<T> extends BaseCardItem<T> {

    private T mData;
    private int mPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mHandler == null) {
            throw new RuntimeException("please bind the handler !");
        }
        return mHandler.onBind(mContext, mData, mPosition);
    }

    public void bindData(T data, int position) {
        mData = data;
        mPosition = position;
    }
}
