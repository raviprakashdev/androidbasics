package com.example.myaudio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

import static android.widget.SeekBar.*;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public void playme(View view){
        mediaPlayer.start();
    }
    public void pauseme(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.myaudio);

        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        int myMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int myCurrentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeRocker = findViewById(R.id.seekBar3);
        volumeRocker.setMax(myMaxVolume);
        volumeRocker.setProgress(myCurrentVolume);

        volumeRocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar timeline = (SeekBar) findViewById(R.id.timeline);
        timeline.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeline.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0, 1000);

        timeline.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
