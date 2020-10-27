package com.hhs.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class ProgressBarText extends AppCompatActivity {

    private int currentProgress = 0;//当前进度值
    private android.widget.ProgressBar progressBar;
    private int maxProgress; //最大进度值

    Handler callbackHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            if (msg.what == 0){
                progressBar.setProgress(currentProgress);

            }
            return false;
        }
    });




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar_text);

        progressBar = findViewById(R.id.pb_4);

        maxProgress = progressBar.getMax();



    }

    @Override
    protected void onStart() {
        super.onStart();

        new Thread(){
            @Override
            public void run() {

                while(true){

                    try {
                        for(int i = 0; i <= 100; i++){
                            Thread.sleep(1000);
                            currentProgress += 10;
                            if (currentProgress > maxProgress){
                                break;
                            }

                            callbackHandler.sendEmptyMessage(0);

                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
