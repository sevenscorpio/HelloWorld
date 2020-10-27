package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class ScrollviewText extends AppCompatActivity implements View.OnClickListener{

    Button buttonUp;
    Button buttonDown;
    ScrollView scrollView;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview_text);

        bindView();

    }

    public void bindView(){

        buttonDown = findViewById(R.id.button_1);
        buttonUp = findViewById(R.id.button_2);
        scrollView = findViewById(R.id.scrollview_1);
        textView4 = findViewById(R.id.text_4);

        buttonDown.setOnClickListener(this);
        buttonUp.setOnClickListener(this);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++){
            sb.append("文本" + i + "\n");
        }
        textView4.setText(sb.toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                break;
            case R.id.button_2:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                break;
        }
    }
}
