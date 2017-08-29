package com.sunfusheng.scrollable.widget.NestedScrollingViews;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by sunfusheng on 2017/8/7.
 */
public class ParentView extends FrameLayout implements NestedScrollingParent {

    private NestedScrollingParentHelper mParentHelper;

    public ParentView(Context context) {
        this(context, null);
    }

    public ParentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.e("--->", "ParentView onStartNestedScroll()");
        return true;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        Log.e("--->", "ParentView onNestedScrollAccepted()");
        mParentHelper.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        Log.e("--->", "ParentView onStopNestedScroll()");
        mParentHelper.onStopNestedScroll(child);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        Log.e("--->", "ParentView onNestedPreScroll()");
        if (dx > 0) {
            if (target.getRight() + dx > getWidth()) {
                dx = target.getRight() + dx - getWidth();
                offsetLeftAndRight(dx);
                consumed[0] += dx; // 将消耗掉的距离返回给子类
            }
        } else {
            if (target.getLeft() + dx < 0) {
                dx = target.getLeft() + dx;
                offsetLeftAndRight(dx);
                consumed[0] += dx;
            }
        }

        if (dy > 0) {
            if (target.getBottom() + dy > getHeight()) {
                dy = target.getBottom() + dy - getHeight();
                offsetTopAndBottom(dy);
                consumed[1] += dy;
            }
        } else {
            if (target.getTop() + dy < 0) {
                dy = target.getTop() + dy;
                offsetTopAndBottom(dy);
                consumed[1] += dy;
            }
        }
    }

    @Override
    public int getNestedScrollAxes() {
        Log.e("--->", "ParentView getNestedScrollAxes()");
        return mParentHelper.getNestedScrollAxes();
    }
}
