package com.rakshasindhu.trackingsystem;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rakshasindhu.trackingsystem.activities.CameraActivity;
import com.rakshasindhu.trackingsystem.activities.LoginActivity;
import com.rakshasindhu.trackingsystem.fragments.BusLocationFragment;
import com.rakshasindhu.trackingsystem.fragments.HelpFragment;
import com.rakshasindhu.trackingsystem.fragments.HomeFragment;
import com.rakshasindhu.trackingsystem.fragments.NotificationFragment;
import com.rakshasindhu.trackingsystem.fragments.SettingFragment;
import com.rakshasindhu.trackingsystem.fragments.StudentsFragment;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        hideScrollBar();
        setActionBar();
        setDrawerToggle();
        setListener();

        if (findViewById(R.id.home_container) != null) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.home_container, new HomeFragment()).commit();
            }
        }

    }

    //init view
    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    //setActionBar
    private void setActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void hideScrollBar() {
        mNavigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
    }

    private void setDrawerToggle() {
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // set navigation drawer items click listener
    private void setListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new HomeFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.students:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new StudentsFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new NotificationFragment()).addToBackStack(null).commit();
                        break;

                    case R.id.location:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new BusLocationFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.help:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new HelpFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.logout:
                        Intent it = new Intent(HomeActivity.this, LoginActivity.class);
                        getApplicationContext().getSharedPreferences("BusSharedPreference", Context.MODE_PRIVATE).edit().clear().commit();
                        startActivity(it);
                        break;
                    case R.id.camera:
                        Intent cam = new Intent(HomeActivity.this,CameraActivity.class);
                        getApplicationContext().getSharedPreferences("BusSharedPreference", Context.MODE_PRIVATE).edit().clear().commit();
                        startActivity(cam);
                        break;

                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new SettingFragment()).addToBackStack(null).commit();
                        break;

                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

}
