package com.example.mytaptap;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void playMusic(View view) {
        int id=view.getId();
        Log.i("ID","Id value is"+ id);

        String nameId;
        nameId = view.getResources().getResourceEntryName(id);

        Log.i("nameId","my nameId is"+nameId);
//        Toast.makeText(MainActivity.this,
//                "Your Message "+nameId , Toast.LENGTH_LONG).show();

        int myMusic = getResources().getIdentifier(nameId, "raw","com.example.mytaptap" );
        MediaPlayer mediaPlayer = MediaPlayer.create(this,myMusic);
        mediaPlayer.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
