package com.sunfusheng.scrollable.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunfusheng.scrollable.R;
import com.sunfusheng.scrollable.model.Item;

import java.util.List;

/**
 * Created by sunfusheng on 2017/8/2.
 */
public class ListViewAdapter extends BaseListAdapter<Item> {

    public ListViewAdapter(Context context, List<Item> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = getItem(position);

        holder.textView.setText(item.text);
        holder.textView.setBackgroundResource(item.colorResId);

        return convertView;
    }

    static class ViewHolder {
        public TextView textView;

        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
