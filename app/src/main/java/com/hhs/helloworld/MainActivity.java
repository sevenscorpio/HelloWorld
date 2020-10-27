package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_layout);

        mContext = this;

        final Toast toast = Toast.makeText(mContext, "提示框", Toast.LENGTH_SHORT);

        // 设置显示位置
        toast.setGravity(Gravity.BOTTOM, 0, 100);

        // 自定义布局
        LinearLayout layout = (LinearLayout)toast.getView();
        TextView tv = layout.findViewById(android.R.id.message);
        layout.setBackgroundColor(Color.YELLOW);
        ImageView image = new ImageView(mContext);
        image.setImageResource(R.mipmap.ic_launcher_round);
        layout.addView(image, 0);

        Button btn = findViewById(R.id.bt_7);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast.show();
            }
        });
    }


}
