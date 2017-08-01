package com.sunfusheng.scrollable.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by sunfusheng on 2017/8/1.
 */
public class NestedListView extends ListView implements NestedScrollingChild {

    private NestedScrollingChildHelper helper;
    private float mLastY;

    public NestedListView(Context context) {
        this(context, null);
    }

    public NestedListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        helper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            mLastY = ev.getY();
            startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    float deltaY = mLastY - ev.getY();
                    mLastY = ev.getY();
                    if (dispatchNestedPreScroll(0, (int) deltaY, consumed, offset)) {
                        mLastY -= offset[1];
                        return true;
                    }
                    break;
                case MotionEvent.ACTION_UP:

                    break;
            }
            return super.onTouchEvent(ev);
        } else {
            return super.onTouchEvent(ev);
        }
    }

    private int[] offset = new int[2], consumed = new int[2];

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        helper.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return helper.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        return helper.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        helper.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return helper.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return helper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }


    /**
     * 在子View的onInterceptTouchEvent或者onTouch中(一般在MotionEvent.ACTION_MOVE事件里)，
     * 调用该方法通知父View滑动的距离。
     * 如果父view接受了它的滚动参数，进行了部分消费，则这个函数返回true，否则为false。
     *
     * @param dx
     * @param dy
     * @param consumed       父view消费掉的scroll长度
     * @param offsetInWindow 子View的窗体偏移量
     * @return
     */
    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return helper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return false;
    }

}
