package com.hhs.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhs.helloworld.R;
import com.hhs.helloworld.entity.News;

import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private List<News> mDate;
    private Context mContext;


    public NewsAdapter(List<News> mDate, Context mContext) {
        this.mDate = mDate;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mDate.size();
    }

    @Override
    public Object getItem(int i) {
        return mDate.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//
//        view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, viewGroup, false);
//        ImageView imgIcon = view.findViewById(R.id.img_icon);
//        TextView title = view.findViewById(R.id.tv_title);
//        TextView content = view.findViewById(R.id.tv_content);
//        imgIcon.setBackgroundResource(mDate.get(i).getaIcon());
//        title.setText(mDate.get(i).getTitle());
//        content.setText(mDate.get(i).getContent());
//
//        return view;
//    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null){
            holder = new ViewHolder();

            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, viewGroup, false);
            holder.imgIcon = view.findViewById(R.id.img_icon);
            holder.title = view.findViewById(R.id.tv_title);
            holder.content = view.findViewById(R.id.tv_content);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.imgIcon.setBackgroundResource(mDate.get(i).getaIcon());
        holder.title.setText(mDate.get(i).getTitle());
        holder.content.setText(mDate.get(i).getContent());

        return view;
    }

    static class ViewHolder{
        ImageView imgIcon;
        TextView title, content;
    }
}
