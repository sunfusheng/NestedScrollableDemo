package com.sunfusheng.scrollable.widget.NestedScrollingViews;

import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by sunfusheng on 2017/8/7.
 */
public class MiddleView extends FrameLayout implements NestedScrollingParent, NestedScrollingChild {

    private NestedScrollingParentHelper mParentHelper;
    private NestedScrollingChildHelper mChildHelper;

    public MiddleView(Context context) {
        this(context, null);
    }

    public MiddleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MiddleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mParentHelper = new NestedScrollingParentHelper(this);
        mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    //*****************************************
    // NestedScrollingParent
    //*****************************************

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.w("--->", "MiddleView-ParentHelper onStartNestedScroll()");
        return startNestedScroll(ViewCompat.SCROLL_AXIS_HORIZONTAL | ViewCompat.SCROLL_AXIS_VERTICAL);
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        Log.w("--->", "MiddleView-ParentHelper onNestedScrollAccepted()");
        mParentHelper.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        Log.w("--->", "MiddleView-ParentHelper onStopNestedScroll()");
        stopNestedScroll();
        mParentHelper.onStopNestedScroll(child);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        Log.w("--->", "MiddleView-ParentHelper onNestedPreScroll()");
        if (dispatchNestedPreScroll(dx, dy, consumed, null)) {
            dx -= consumed[0];
            dy -= consumed[1];
        }

        if (dx > 0) {
            if (target.getRight() + dx > getWidth()) {
                dx = target.getRight() + dx - getWidth();
                offsetLeftAndRight(dx);
                consumed[0] += dx;
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
        Log.w("--->", "MiddleView-ParentHelper getNestedScrollAxes()");
        return mParentHelper.getNestedScrollAxes();
    }

    //*****************************************
    // NestedScrollingChild
    //*****************************************

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        mChildHelper.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return mChildHelper.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        Log.w("--->", "MiddleView-ChildHelper startNestedScroll()");
        return mChildHelper.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        Log.w("--->", "MiddleView-ChildHelper stopNestedScroll()");
        mChildHelper.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return mChildHelper.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        Log.w("--->", "MiddleView-ChildHelper dispatchNestedScroll()");
        return mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        Log.w("--->", "MiddleView-ChildHelper dispatchNestedPreScroll()");
        return mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        Log.w("--->", "MiddleView-ChildHelper dispatchNestedFling()");
        return mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        Log.w("--->", "MiddleView-ChildHelper  dispatchNestedPreFling()");
        return mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

}
