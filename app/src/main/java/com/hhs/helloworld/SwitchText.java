package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SwitchText extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private ToggleButton button5;

    private android.widget.Switch button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_text);

        button5 = findViewById(R.id.bt_5);

        button6 = findViewById(R.id.bt_6);

        button5.setOnCheckedChangeListener(this);
        button6.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.bt_5:
                if (compoundButton.isChecked()){
                    Toast.makeText(this, "打开声音", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "关闭声音", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_6:
                if (compoundButton.isChecked()){
                    Toast.makeText(this, "开关：NO", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "开关：OFF", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}