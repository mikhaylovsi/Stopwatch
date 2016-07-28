package com.marrog.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class StopwatchActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;
    private TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        timeView = (TextView)findViewById(R.id.time_view);


    }


    void runTimer(){

       // timeView.setText(String.valueOf(seconds));

        int hours = seconds / 3600;
        int minutes = (seconds%3600) / 60;
        int secs = seconds%60;

//        while(running){
//            seconds++;
//        }

        String time = String.format("Time is %d:%5d", 1, 2);
        timeView.setText(time);

    }

    public void onCLickStart(View view) {

        running = true;
        runTimer();

    }

    public void onClickStop(View view) {

        running = false;

    }

    public void onCLickReset(View view) {

        running = false;
        seconds = 0;
        timeView.setText(String.valueOf(seconds));


    }
}
