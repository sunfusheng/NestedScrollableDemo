package com.sunfusheng.scrollable.adpater;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.model.MultiItem;

import java.util.List;

/**
 * Created by sunfusheng on 2017/8/3.
 */
public class MultiItemAdapter extends BaseMultiItemQuickAdapter<MultiItem, BaseViewHolder> {

    public MultiItemAdapter(List<MultiItem> data) {
        super(data);
        addItemType(-1, R.layout.layout_item);
        addItemType(0, R.layout.item_no_image);
        addItemType(1, R.layout.item_right_image);
        addItemType(2, R.layout.item_three_images);
        addItemType(3, R.layout.item_top_image);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItem item) {

    }
}
