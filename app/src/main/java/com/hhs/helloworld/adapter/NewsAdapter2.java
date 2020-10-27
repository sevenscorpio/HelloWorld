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

public class NewsAdapter2 extends BaseAdapter {

    private List<News> mDate;
    private Context mContext;

    private static final int TYPE_NEWS_0 = 0;
    private static final int TYPE_NEWS_1 = 1;

    public NewsAdapter2(List<News> mDate, Context mContext) {
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

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0){
            return TYPE_NEWS_0;
        }else{
            return TYPE_NEWS_1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        int type = getItemViewType(i);

        ViewHolder holder1 = null;
        ViewHolder2 holder2 = null;

        if (view == null){
            switch (type){
                case TYPE_NEWS_0:
                    holder1 = new ViewHolder();
                    view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, viewGroup, false);
                    holder1.imgIcon = view.findViewById(R.id.img_icon);
                    holder1.title = view.findViewById(R.id.tv_title);
                    holder1.content = view.findViewById(R.id.tv_content);
                    view.setTag(holder1);
                    break;
                case TYPE_NEWS_1:
                    holder2 = new ViewHolder2();
                    view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout_2, viewGroup, false);
                    holder2.imgIcon = view.findViewById(R.id.img_icon);
                    holder2.title = view.findViewById(R.id.tv_title);
                    holder2.content = view.findViewById(R.id.tv_content);
                    view.setTag(holder2);
                    break;
            }
        }else{
            switch (type){
                case TYPE_NEWS_0:
                    holder1 = (ViewHolder) view.getTag();
                    break;
                case TYPE_NEWS_1:
                    holder2 = (ViewHolder2) view.getTag();
                    break;
            }
        }

        switch (type){
            case TYPE_NEWS_0:
                holder1.imgIcon.setBackgroundResource(mDate.get(i).getaIcon());
                holder1.title.setText(mDate.get(i).getTitle());
                holder1.content.setText(mDate.get(i).getContent());
                break;
            case TYPE_NEWS_1:
                holder2.imgIcon.setBackgroundResource(mDate.get(i).getaIcon());
                holder2.title.setText(mDate.get(i).getTitle());
                holder2.content.setText(mDate.get(i).getContent());
                break;
        }


        return view;
    }

    static class ViewHolder{
        ImageView imgIcon;
        TextView title, content;
    }

    static class ViewHolder2{
        ImageView imgIcon;
        TextView title, content;
    }
}
