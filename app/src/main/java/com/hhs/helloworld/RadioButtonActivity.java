package com.hhs.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton_text);

        Button button3 = findViewById(R.id.bt_3);
        final RadioGroup radioGroup = findViewById(R.id.radio_group1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                Toast.makeText(getApplicationContext(), "你选了：" + radioButton.getText(), Toast.LENGTH_LONG).show();
                System.out.println(i);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < radioGroup.getChildCount(); i ++){
                    RadioButton rd = (RadioButton) radioGroup.getChildAt(i);
                    if(rd.isChecked()){
                        Toast.makeText(getApplicationContext(), "你选的是:" + rd.getText(), Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });
    }
}
