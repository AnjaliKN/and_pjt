package com.example.opentrends003.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.opentrends003.mvp.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        loadFragment();


    }

    public abstract void loadFragment();
}
