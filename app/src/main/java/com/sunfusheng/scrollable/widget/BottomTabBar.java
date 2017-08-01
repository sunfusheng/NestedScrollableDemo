package com.sunfusheng.scrollable.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sunfusheng.scrollable.R;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class BottomTabBar extends FrameLayout {

    private TextView tab11;
    private TextView tab12;
    private TextView tab13;
    private TextView tab14;

    public BottomTabBar(Context context) {
        this(context, null);
    }

    public BottomTabBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomTabBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_bottom_tab, this);
        tab11 = (TextView) view.findViewById(R.id.tab11);
        tab12 = (TextView) view.findViewById(R.id.tab12);
        tab13 = (TextView) view.findViewById(R.id.tab13);
        tab14 = (TextView) view.findViewById(R.id.tab14);
    }

    public void setSelected(int position) {
        tab11.setSelected(false);
        tab12.setSelected(false);
        tab13.setSelected(false);
        tab14.setSelected(false);
        switch (position) {
            case 0:
                tab11.setSelected(true);
                break;
            case 1:
                tab12.setSelected(true);
                break;
            case 2:
                tab13.setSelected(true);
                break;
            case 3:
                tab14.setSelected(true);
                break;
        }
    }

}
