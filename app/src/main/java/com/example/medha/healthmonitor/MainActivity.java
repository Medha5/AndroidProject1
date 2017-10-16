package com.example.medha.healthmonitor;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button bt;
    EditText time1,time2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get reference of button
        bt=(Button)this.findViewById(R.id.button);

        // Get reference of edit text fields.
        time1=(EditText)this.findViewById(R.id.totalTime);
        time2=(EditText)this.findViewById(R.id.intervalTime);

        // Get the input values.
         String time1_str=time1.getText().toString();
         String time2_str=time2.getText().toString();

        // Convert the string values into long.
        final long intervaltime_long=Long.valueOf(time1_str)*1000;
        final long totaltime_long=Long.valueOf(time2_str)*1000;



        // Initializing a MediaPlayer - a media player uses Static Factory Method  design pattern.
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.beep_sound);
        final MediaPlayer mp_end=MediaPlayer.create(this, R.raw.beep_to_stop);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(totaltime_long,intervaltime_long){
                    @Override
                    public void onTick(long millisUntilFinished){
                        mp.start();
                    }
                    public void onFinish(){
                        mp_end.start();
                    }

                }.start();
            }
        });


    }
}
