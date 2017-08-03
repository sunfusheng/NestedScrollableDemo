package com.sunfusheng.scrollable.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by sunfusheng on 2017/8/2.
 */
public class MultiItem implements MultiItemEntity {

    public int type;

    public MultiItem(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
