package com.hhs.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhs.helloworld.R;
import com.hhs.helloworld.entity.Hero;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    List<Hero> mData;
    Context mContext;

    public SpinnerAdapter(List<Hero> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    public SpinnerAdapter() {
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (holder == null){

            holder = new ViewHolder();

            view = LayoutInflater.from(mContext).inflate(R.layout.item_spin_hero, viewGroup, false);

            holder.imgIcon = view.findViewById(R.id.img_icon1);
            holder.name = view.findViewById(R.id.img_text1);
            view.setTag(holder);

        }else{
            holder = (ViewHolder)view.getTag();
        }

        holder.imgIcon.setImageResource(mData.get(i).gethIcon());
        holder.name.setText(mData.get(i).gethName());

        return view;
    }

    static class ViewHolder{
        ImageView imgIcon;
        TextView name;
    }
}
