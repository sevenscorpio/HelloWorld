package com.hhs.helloworld;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.hhs.helloworld.adapter.NewsAdapter2;
import com.hhs.helloworld.entity.News;

import java.util.LinkedList;
import java.util.List;

public class ListViewText extends AppCompatActivity {

    private Context mContext;
    private ListView listView;
    private NewsAdapter2 newsAdapter;
    private List<News> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_text);

        mContext = this;

        listView = findViewById(R.id.list_1);

        mData = new LinkedList<News>();

        for (int i = 0; i < 10 ; i ++){

            mData.add(new News("我是标题", "我是内容", R.mipmap.news));
        }

        newsAdapter = new NewsAdapter2(mData, mContext);

        listView.setAdapter(newsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(mContext, "点击了第" + (i + 1) + "条数据", Toast.LENGTH_SHORT).show();
            }
        });


    }







}
