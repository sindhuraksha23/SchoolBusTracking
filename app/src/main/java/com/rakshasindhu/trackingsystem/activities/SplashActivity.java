package com.rakshasindhu.trackingsystem.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rakshasindhu.trackingsystem.HomeActivity;
import com.rakshasindhu.trackingsystem.R;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = getBaseContext().getSharedPreferences("BusSharedPreference", Context.MODE_PRIVATE);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(5000);

                    if (sharedPreferences.getString("Phone", "").equals("")) {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        };

        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
