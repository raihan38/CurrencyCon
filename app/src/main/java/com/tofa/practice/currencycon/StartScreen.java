package com.tofa.practice.currencycon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        getSupportActionBar().hide();
        //By using android.support.v7.app.ActionBar, you can provide backward support for older Android versions.
        //If you are importing android.app.ActionBar then you have to use getActionBar()
        // and if you are importing android.support.v7.app.ActionBar then you have to use getSupportActionBar().
        Intent intent = new Intent(StartScreen.this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        },3000);




    }
}