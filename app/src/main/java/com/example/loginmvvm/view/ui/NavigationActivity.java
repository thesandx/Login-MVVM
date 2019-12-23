package com.example.loginmvvm.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.loginmvvm.R;
import com.example.loginmvvm.view.ui.Activity2.ActivityDemo;
import com.example.loginmvvm.view.ui.qrscan.QrScanFragment;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        //for hamburger menu
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //this is hamburger
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = findViewById(R.id.navigation_view);
        //annonymus class for interface callback
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.qr_scan) {
                openFragment("QR Scan",new QrScanFragment());

            }
            if (id==R.id.activity2){
                Intent intent = new Intent(NavigationActivity.this, ActivityDemo.class);
                startActivity(intent);
            }
            item.setChecked(true);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });




        openFragment("QR Scan",new QrScanFragment());









    }

    public void openFragment(String title, Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentnav, new QrScanFragment()).commit();
        getSupportActionBar().setTitle(title);
    }
}
