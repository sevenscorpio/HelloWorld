package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class SeekBarText extends AppCompatActivity {

    private SeekBar seekBar1, seekBar2;
    private TextView textView3;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_text);

        seekBar1 = findViewById(R.id.sb_1);
        seekBar2 = findViewById(R.id.sb_2);
        mContext = this;
        textView3 = findViewById(R.id.text_3);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView3.setText("当前进度值：" + i + "/100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(mContext, "触碰seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(mContext, "松开seekbar", Toast.LENGTH_SHORT).show();
            }
        });

        seekBar2.setSecondaryProgress(20);

    }
}

