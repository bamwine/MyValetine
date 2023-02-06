package com.example.eng.myvaletine;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen1 extends AppCompatActivity {

   // private Thread mSplashThread;
    MediaPlayer our_love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        our_love= MediaPlayer.create(this, R.raw.way);
        our_love.start();

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent openMainActivity= new Intent(SplashScreen1.this,SplashScreen2.class);
                    startActivity(openMainActivity);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        our_love.release();
        finish();
    }



}
