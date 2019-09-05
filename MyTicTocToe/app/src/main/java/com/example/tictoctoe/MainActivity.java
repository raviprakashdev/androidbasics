package com.example.tictoctoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer = 0;

    // 0 for cross and 1 for circle
    //my game state
    int[] myGameState={2,2,2,2,2,2,2,2,2};
    public void ImageTapped(View view){
        ImageView myTapped = (ImageView) view;
        int tappedimageTag = Integer.parseInt(myTapped.getTag().toString());

        if (myGameState[ tappedimageTag ]==2) {
            myGameState[tappedimageTag]=myActivePlayer;

            if (myActivePlayer == 0) {
//                ImageView myTapped = (ImageView) view;
                myTapped.setImageResource(R.drawable.cross1);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;
            } else {
//                ImageView myTapped = (ImageView) view;
                myTapped.setImageResource(R.drawable.circle1);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 0;
            }
            if( myGameState[0]==1&&myGameState[1]==1&&myGameState[2]==1||
                    myGameState[3]==1&&myGameState[4]==1&&myGameState[5]==1 ||
            myGameState[6]==1&&myGameState[7]==1&&myGameState[8]==1||
                    myGameState[0]==1&&myGameState[3]==1&&myGameState[6]==1||
                    myGameState[1]==1&&myGameState[4]==1&&myGameState[7]==1 ||
                    myGameState[2]==1&&myGameState[5]==1&&myGameState[8]==1||
                    myGameState[0]==1&&myGameState[4]==1&&myGameState[8]==1||
                    myGameState[2]==1&&myGameState[4]==1&&myGameState[6]==1
                  ){
                Toast.makeText(getApplicationContext(), "circle win", Toast.LENGTH_SHORT).show();
            }
            if( myGameState[0]==0&&myGameState[1]==0&&myGameState[2]==0||
                    myGameState[3]==0&&myGameState[4]==0&&myGameState[5]==0||
                    myGameState[6]==10&&myGameState[7]==0&&myGameState[8]==0||
                    myGameState[0]==0&&myGameState[3]==0&&myGameState[6]==0||
                    myGameState[1]==0&&myGameState[4]==0&&myGameState[7]==0 ||
                    myGameState[2]==0&&myGameState[5]==0&&myGameState[8]==0||
                    myGameState[0]==0&&myGameState[4]==0&&myGameState[8]==0||
                    myGameState[2]==0&&myGameState[4]==0&&myGameState[6]==0
            ){
                Toast.makeText(getApplicationContext(), "cross win", Toast.LENGTH_SHORT).show();
            }

        }
//        TODO:add toast
        else{
            Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
        }
    }

    public void playAgain(View view){
//        Log.i("msg", "play again tapped");

        //Change Game state back to 2
        for (int i = 0; i < myGameState.length; i++){
            myGameState[i] = 2;
        }


        //Make active player 0 again
        myActivePlayer = 0;



        //change all images to ic_launcher
//        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
//        LinearLayout linearLayout = findViewById(R.id.lineone);
//        for (int i =0; i < linearLayout.getChildCount(); i++){
//            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.rectangle1);
//        }
//
//        LinearLayout linearLayoutOne = findViewById(R.id.linetwo);
//        for (int i =0; i < linearLayoutOne.getChildCount(); i++){
//            ((ImageView) linearLayoutOne.getChildAt(i)).setImageResource(R.mipmap.rectangle1);
//        }
//
//        LinearLayout linearLayoutTwo = findViewById(R.id.linethree);
//        for (int i =0; i < linearLayoutTwo.getChildCount(); i++){
//            ((ImageView) linearLayoutTwo.getChildAt(i)).setImageResource(R.mipmap.rectangle1);
//        }
        int[] ids ={R.id.lineone,R.id.linetwo,R.id.linethree};
        for(int j=0;j<ids.length;j++)
        {
            LinearLayout linearLayout =findViewById(ids[j]);
            for(int i=0;i<linearLayout.getChildCount();i++)
                ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.drawable.rectangle1);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

