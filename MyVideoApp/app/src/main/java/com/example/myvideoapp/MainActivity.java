package com.example.myvideoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // basic of video

        //1. get video view
        VideoView videoView = findViewById(R.id.videoView);

        //2. point is video resource
        videoView.setVideoPath("android.resource://" + getPackageName()+"/" +R.raw.intro);

        //add media control
        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
    //run it
        videoView.start();
    }
}
