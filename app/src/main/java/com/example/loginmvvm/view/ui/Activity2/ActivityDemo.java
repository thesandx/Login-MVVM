package com.example.loginmvvm.view.ui.Activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.loginmvvm.R;

public class ActivityDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.demo_container,new DemoFragment())
                .commit();
    }
}
