package com.code.lahiri.basicbankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();
                try {
                    sleep(4000);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(SplashActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            }
        };
        thread.start();
    }
}