package com.sunfusheng.scrollable.widget.CardSlideView;

import android.content.Context;
import android.support.v4.app.Fragment;

public class BaseCardItem<T> extends Fragment {

    protected CardHandler<T> mHandler;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public void bindHandler(CardHandler<T> handler) {
        mHandler = handler;
    }
}
