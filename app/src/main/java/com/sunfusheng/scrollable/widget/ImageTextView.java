package com.sunfusheng.scrollable.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.sunfusheng.scrollable.R;

/**
 * Created by sunfusheng on 2017/7/31.
 */
public class ImageTextView extends android.support.v7.widget.AppCompatTextView {

    private int leftHeight = -1;
    private int leftWidth = -1;
    private int rightHeight = -1;
    private int rightWidth = -1;
    private int topHeight = -1;
    private int topWidth = -1;
    private int bottomHeight = -1;
    private int bottomWidth = -1;

    public ImageTextView(Context context) {
        this(context, null);
    }

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageTextView, defStyle, 0);
        if (a != null) {
            for (int i = 0; i < a.getIndexCount(); i++) {
                int index = a.getIndex(i);
                if (index == R.styleable.ImageTextView_bottom_height) {
                    bottomHeight = a.getDimensionPixelSize(index, -1);
                } else if (index == R.styleable.ImageTextView_bottom_width) {
                    bottomWidth = a.getDimensionPixelSize(index, -1);
                } else if (index == R.styleable.ImageTextView_left_height) {
                    leftHeight = a.getDimensionPixelSize(index, -1);
                } else if (index == R.styleable.ImageTextView_left_width) {
                    leftWidth = a.getDimensionPixelSize(index, -1);
                } else if (index == R.styleable.ImageTextView_right_height) {
                    rightHeight = a.getDimensionPixelSize(index, -1);
                } else if (index == R.styleable.ImageTextView_right_width) {
                    rightWidth = a.getDimensionPixelSize(index, -1);
                } else if (index == R.styleable.ImageTextView_top_height) {
                    topHeight = a.getDimensionPixelSize(index, -1);
                } else if (index == R.styleable.ImageTextView_top_width) {
                    topWidth = a.getDimensionPixelSize(index, -1);
                }
            }

            // 获取各个方向的图片，按照：左-上-右-下 的顺序存于数组中
            Drawable[] drawables = getCompoundDrawables();
            int dir = 0;
            // 0-left; 1-top; 2-right; 3-bottom;
            for (Drawable drawable : drawables) {
                setImageSize(drawable, dir++);
            }
            setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
            a.recycle();
        }
    }

    /**
     * 设定图片的大小
     */
    private void setImageSize(Drawable d, int dir) {
        if (d == null) {
            return;
        }

        int height = -1;
        int width = -1;
        // 根据方向给宽和高赋值
        switch (dir) {
            case 0:
                // left
                height = leftHeight;
                width = leftWidth;
                break;
            case 1:
                // top
                height = topHeight;
                width = topWidth;
                break;
            case 2:
                // right
                height = rightHeight;
                width = rightWidth;
                break;
            case 3:
                // bottom
                height = bottomHeight;
                width = bottomWidth;
                break;
        }
        // 如果有某个方向的宽或者高没有设定值，则不去设定图片大小
        if (width != -1 && height != -1) {
            d.setBounds(0, 0, width, height);
        }
    }

}
