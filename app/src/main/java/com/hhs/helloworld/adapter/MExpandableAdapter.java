package com.hhs.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhs.helloworld.R;
import com.hhs.helloworld.entity.Group;
import com.hhs.helloworld.entity.Item;

import java.util.List;

public class MExpandableAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<Group> gData = null;
    private List<List<Item>> iData = null;

    public MExpandableAdapter(Context mContext, List<Group> gData, List<List<Item>> iData) {
        this.mContext = mContext;
        this.gData = gData;
        this.iData = iData;
    }

    public MExpandableAdapter() {
    }

    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return iData.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return gData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return iData.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    // 取得用于给定分组的视图，这个方法返回视图的分组对象
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        ViewHolderGroup holderGroup;

        if (view == null){

            view = LayoutInflater.from(mContext).inflate(R.layout.item_exlist_group, viewGroup, false);

            holderGroup = new ViewHolderGroup();
            holderGroup.tv_group_name = view.findViewById(R.id.tv_group_name);
            view.setTag(holderGroup);
        }else {
            holderGroup = (ViewHolderGroup)view.getTag();
        }

        holderGroup.tv_group_name.setText(gData.get(i).getName());

        return view;
    }

    // 取得给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        ViewHolderItem holderItem;
        if (view == null){

            view = LayoutInflater.from(mContext).inflate(R.layout.item_exlist_item, viewGroup, false);

            holderItem = new ViewHolderItem();
            holderItem.img_icon = view.findViewById(R.id.img_icon2);
            holderItem.tv_name = view.findViewById(R.id.tv_name);
            view.setTag(holderItem);
        }else {
            holderItem = (ViewHolderItem)view.getTag();
        }

        holderItem.img_icon.setImageResource(iData.get(i).get(i1).getiId());
        holderItem.tv_name.setText(iData.get(i).get(i1).getiName());

        return view;
    }

    // 设置子列表是否可用
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private static class ViewHolderGroup {
        private TextView tv_group_name;
    }

    private static class ViewHolderItem {
        private ImageView img_icon;
        private TextView tv_name;
    }
}
