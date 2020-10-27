package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hhs.helloworld.adapter.SpinnerAdapter;
import com.hhs.helloworld.entity.Hero;

import java.util.ArrayList;
import java.util.List;


public class SpinnerText extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Context mContext;
    private Spinner spinOne;
    private Spinner spinTwo;

    // 判断是否构建页面时触发onItemSelected的标志
    private boolean oneSelected = false;
    private boolean twoSelected = false;
    private List<Hero> mData = null;
    private SpinnerAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_text);

        mContext = this;
        mData = new ArrayList<>();

        bindViews();
    }

    private void bindViews() {
        spinOne = (Spinner) findViewById(R.id.spin_1);
        spinTwo = (Spinner) findViewById(R.id.spin_2);

        mData.add(new Hero(R.mipmap.iv_lol_icon1, "迅捷斥候：提莫（Teemo）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon2, "诺克萨斯之手：德莱厄斯（Darius）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon3, "无极剑圣：易（Yi）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon4, "德莱厄斯：德莱文（Draven）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon5, "德邦总管：赵信（XinZhao）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon6, "狂战士：奥拉夫（Olaf）"));

        mAdapter = new SpinnerAdapter(mData, mContext);
        spinTwo.setAdapter(mAdapter);
        spinOne.setOnItemSelectedListener(this);
        spinTwo.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.spin_1:
                if (oneSelected){
                    Toast.makeText(mContext, "您的分段式：" + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                }else {
                    oneSelected = true;
                }
                break;
            case R.id.spin_2:
                if (twoSelected){
                    TextView textView = view.findViewById(R.id.img_text1);
                    Toast.makeText(mContext, "您选的英雄是：" + textView.getText().toString(), Toast.LENGTH_SHORT).show();
                }else {
                    twoSelected = true;
                }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
