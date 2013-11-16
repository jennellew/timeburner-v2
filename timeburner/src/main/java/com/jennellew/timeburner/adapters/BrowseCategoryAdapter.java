package com.jennellew.timeburner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jennellew.timeburner.R;

/**
 * Created by jwong on 11/11/13.
 */
public class BrowseCategoryAdapter extends BaseAdapter {
    private Context mContext;
    private ViewHolder holder;

    public BrowseCategoryAdapter(Context context) {
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder = (ViewHolder) convertView.getTag();
        if (holder == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.category_item, null);

            holder = new ViewHolder();
            holder.mImageView = (ImageView)convertView.findViewById(R.id.categoryIcon);
            holder.colourStrip = (ImageView) convertView.findViewById(R.id.colourStrip);
            holder.mTextView = (TextView) convertView.findViewById(R.id.categoryLabel);
            convertView.setTag(holder);
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        ImageView mImageView;
        ImageView colourStrip;
        TextView mTextView;
    }
}
