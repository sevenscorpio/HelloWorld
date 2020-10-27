package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Checkbox extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_text);

        cb1 = findViewById(R.id.cb_one);
        cb2 = findViewById(R.id.cb_two);
        cb3 = findViewById(R.id.cb_three);

        button = findViewById(R.id.bt_4);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String choose = "";
        if (cb1.isChecked()) {
            choose += cb1.getText().toString() + "";
        }
        if (cb2.isChecked()) {
            choose += cb2.getText().toString() + "";
        }
        if (cb3.isChecked()) {
            choose += cb3.getText().toString() + "";
        }
        Toast.makeText(this, choose, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String s = compoundButton.getText().toString();
        if (compoundButton.isChecked()){
            Toast.makeText(getApplicationContext(), compoundButton.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
