package com.sunfusheng.scrollable.widget.CardSlideView;

import android.content.Context;
import android.view.View;

public interface CardHandler<T> {

    View onBind(Context context, T data, int position);
}
