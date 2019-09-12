package com.example.myreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }
    public void addListenerOnButton() {

        final TextView mnumber=(TextView) findViewById(R.id.mtime);
        final TextView result = (TextView) findViewById(R.id.done);
        Button buttonSum = (Button) findViewById(R.id.start);

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Not Done Yet !!!");
                 new CountDownTimer(10000,1000) {
                    public void onTick(long millisecondUntilDone) {
                        mnumber.setText("Time: "+String.valueOf(millisecondUntilDone/1000));

                    }

                    public void onFinish() {
                        result.setText("Done !!!");
                        ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
                        toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,1050);

                    }
                }.start();

            }
        });
    }

}
