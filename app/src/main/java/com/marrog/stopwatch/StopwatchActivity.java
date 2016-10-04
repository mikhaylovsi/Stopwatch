package com.marrog.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;



public class StopwatchActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;
    private boolean wasRunning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        if(savedInstanceState != null){

            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");

        }

        runTimer();
    }


//    @Override
//    public void onStop() {
//        super.onStop();
//        running = false;
//        wasRunning = true;
//    }


    @Override
    protected void onPause() {
        super.onPause();

        if(running) {
            wasRunning = true;
        }

        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        if(wasRunning){
//            running = true;
//        }
//    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

      savedInstanceState.putInt("seconds", seconds);
      savedInstanceState.putBoolean("running", running);
      savedInstanceState.putBoolean("wasRunning", wasRunning);


    }

    void runTimer(){

       // timeView.setText(String.valueOf(seconds));

        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%2d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);

                if (running) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);

            }
        });

    }

    public void onCLickStart(View view) {

        running = true;

    }

    public void onClickStop(View view) {

        running = false;

    }

    public void onCLickReset(View view) {

        running = false;
        seconds = 0;

    }
}
