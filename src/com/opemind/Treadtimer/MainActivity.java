package com.opemind.Treadtimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MainActivity extends Activity {

    private Handler myHandler;
    boolean gameOn;
    long startTime;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // how many milliseconds is it since unix epoch
        startTime = System.currentTimeMillis();

        myHandler = new Handler(){

            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if(gameOn){
                    long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
                    Log.i("info", "senconds = " + seconds);

                }
                myHandler.sendEmptyMessageDelayed(0, 1000);
            }

        };

        gameOn = true;
        myHandler.sendEmptyMessage(0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
