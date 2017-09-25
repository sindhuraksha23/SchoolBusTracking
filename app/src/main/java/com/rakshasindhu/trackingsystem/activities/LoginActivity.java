package com.rakshasindhu.trackingsystem.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rakshasindhu.trackingsystem.R;
import com.rakshasindhu.trackingsystem.fragments.LoginDefaultFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (findViewById(R.id.login_container) != null) {
            if (savedInstanceState == null) {
                LoginDefaultFragment loginDefaultFragment = new LoginDefaultFragment();
                loginDefaultFragment.setArguments(getIntent().getExtras());

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.login_container, loginDefaultFragment).commit();
            }
        }
    }
}
