


package com.hhs.helloworld;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.os.Bundle;
        import android.widget.DatePicker;
        import android.widget.TimePicker;
        import android.widget.Toast;

        import java.sql.Time;
        import java.util.Calendar;

public class PickerText extends AppCompatActivity {

    Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicket_text);

        mContext = this;

        DatePicker datePicker = findViewById(R.id.dp_1);

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int mouthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMouth = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, mouthOfYear, dayOfMouth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(mContext, i + "年" + i1 + "月" + i2 + "日", Toast.LENGTH_SHORT).show();
            }
        });

        TimePicker timePicker1 = findViewById(R.id.tp_1);
        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(getApplicationContext(),"您选择的时间是："+i+"时"+i1+"分!",Toast.LENGTH_SHORT).show();
            }
        });

    }







}
