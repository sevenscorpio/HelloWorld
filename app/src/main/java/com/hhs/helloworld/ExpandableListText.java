
package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.hhs.helloworld.adapter.MExpandableAdapter;
import com.hhs.helloworld.entity.Group;
import com.hhs.helloworld.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListText extends AppCompatActivity {

    private Context mContext;
    private List<Group> gData = null;
    private ArrayList<List<Item>> iData = null;
    private List<Item> lData = null;
    private ExpandableListView exList;
    private MExpandableAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_listview_text);

        mContext = this;

        exList = findViewById(R.id.exlist_1);

        // 数据
        gData = new ArrayList<>();
        iData = new ArrayList<List<Item>>();
        gData.add(new Group("AD"));
        gData.add(new Group("AP"));
        gData.add(new Group("TANK"));

        lData = new ArrayList<Item>();

        //AD组
        lData.add(new Item(R.mipmap.iv_lol_icon3, "剑圣"));
        lData.add(new Item(R.mipmap.iv_lol_icon4, "德莱文"));
        lData.add(new Item(R.mipmap.iv_lol_icon13, "男枪"));
        lData.add(new Item(R.mipmap.iv_lol_icon14, "韦鲁斯"));
        iData.add(lData);
        //AP组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.iv_lol_icon1, "提莫"));
        lData.add(new Item(R.mipmap.iv_lol_icon7, "安妮"));
        lData.add(new Item(R.mipmap.iv_lol_icon8, "天使"));
        lData.add(new Item(R.mipmap.iv_lol_icon9, "泽拉斯"));
        lData.add(new Item(R.mipmap.iv_lol_icon11, "狐狸"));
        iData.add(lData);
        //TANK组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.iv_lol_icon2, "诺手"));
        lData.add(new Item(R.mipmap.iv_lol_icon5, "德邦"));
        lData.add(new Item(R.mipmap.iv_lol_icon6, "奥拉夫"));
        lData.add(new Item(R.mipmap.iv_lol_icon10, "龙女"));
        lData.add(new Item(R.mipmap.iv_lol_icon12, "狗熊"));
        iData.add(lData);

        mAdapter = new MExpandableAdapter(mContext, gData, iData);
        exList.setAdapter(mAdapter);

        // 为列表设置点击事件
        exList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                Toast.makeText(mContext, "你点击了：" + iData.get(i).get(i1).getiName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


}
