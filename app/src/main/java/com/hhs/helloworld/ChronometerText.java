

package com.hhs.helloworld;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.os.SystemClock;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Chronometer;
        import android.widget.Toast;

public class ChronometerText extends AppCompatActivity implements View.OnClickListener, android.widget.Chronometer.OnChronometerTickListener{

    Button btStar;
    Button btStop;
    Button btRestart;
    Button btSetting;
    android.widget.Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronometer_text);

        initView();
    }

    public void initView(){
        btStar = findViewById(R.id.bt_star);
        btStop = findViewById(R.id.button_stop);
        btRestart = findViewById(R.id.button_restar);
        btSetting = findViewById(R.id.button_setting);

        chronometer = findViewById(R.id.chronometer_1);

        btStar.setOnClickListener(this);
        btStop.setOnClickListener(this);
        btRestart.setOnClickListener(this);
        btSetting.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_star:
                chronometer.start();
                break;
            case R.id.button_stop:
                chronometer.stop();
                break;
            case R.id.button_restar:
                chronometer.setBase(SystemClock.elapsedRealtime());
                break;
            case R.id.button_setting:
                chronometer.setFormat("Time: %s");
                break;
        }
    }

    @Override
    public void onChronometerTick(android.widget.Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if (time.equals("00:00")){
            Toast.makeText(this, "时间到了", Toast.LENGTH_SHORT).show();
        }
    }
}
