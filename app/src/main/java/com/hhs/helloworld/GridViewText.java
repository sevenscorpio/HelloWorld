
package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.hhs.helloworld.adapter.GridViewAdapter;
import com.hhs.helloworld.entity.Icon;

import java.util.ArrayList;
import java.util.List;


public class GridViewText extends AppCompatActivity {

    private Context mContext;
    private GridView gridPhoto;
    private GridViewAdapter gridViewAdapter = null;
    private List<Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_layout);

        mContext = this;

        // 视图层V
        gridPhoto = findViewById(R.id.gv_1);

        // 数据源M
        mData = new ArrayList<>();
        mData.add(new Icon(R.mipmap.iv_lol_icon1, "图标1"));
        mData.add(new Icon(R.mipmap.iv_lol_icon2, "图标2"));
        mData.add(new Icon(R.mipmap.iv_lol_icon3, "图标3"));
        mData.add(new Icon(R.mipmap.iv_lol_icon4, "图标4"));
        mData.add(new Icon(R.mipmap.iv_lol_icon5, "图标5"));
        mData.add(new Icon(R.mipmap.iv_lol_icon6, "图标6"));
        mData.add(new Icon(R.mipmap.iv_lol_icon7, "图标7"));
        mData.add(new Icon(R.mipmap.iv_lol_icon8, "图标8"));
        mData.add(new Icon(R.mipmap.iv_lol_icon9, "图标9"));
        mData.add(new Icon(R.mipmap.iv_lol_icon10, "图标10"));
        mData.add(new Icon(R.mipmap.iv_lol_icon11, "图标11"));

        // 控制层C
        gridViewAdapter = new GridViewAdapter(mData, mContext);

        gridPhoto.setAdapter(gridViewAdapter);

        gridPhoto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mContext, "你点击了~" + i + "~项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

