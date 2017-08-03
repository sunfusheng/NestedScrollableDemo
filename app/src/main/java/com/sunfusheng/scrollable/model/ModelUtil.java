package com.sunfusheng.scrollable.model;

import com.sunfusheng.scrollable.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunfusheng on 2017/8/2.
 */
public class ModelUtil {

    public static List<Item> getTab21Data() {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Item("", R.color.md_blue_300));
        }
        return list;
    }

    public static List<MultiItem> getTab22Data() {
        List<MultiItem> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MultiItem(0));
            list.add(new MultiItem(1));
            list.add(new MultiItem(1));
            list.add(new MultiItem(2));
            list.add(new MultiItem(2));
            list.add(new MultiItem(1));
            list.add(new MultiItem(2));
            list.add(new MultiItem(3));
        }
        return list;
    }
}
