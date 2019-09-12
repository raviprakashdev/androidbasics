package com.example.mystack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class SetupFetch extends AsyncTask<String , void, String>{

        @Override
        protected String doInBackground(String... strings) {

            URL url;
            String page= "";
            HttpURLConnection urlConnection = null;


            try{
                url = new URL(strings[0]);

                urlConnection= (HttpURLConnection) url.openConnection();

                InputStream input = urlConnection.getErrorStream();

                InputStreamReader read=new InputStreamReader(input);

                int data = read.read();

                while(data != -1){
                    char storeData=(char) data;
                    page += storeData;
                    data = read.read();
                }
                return page;
            }

            catch (Exception e){
                e.printStackTrace();
                return "cannot fetch web page";
            }
            
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
