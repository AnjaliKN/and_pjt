package com.example.opentrends003.mvp;

import android.app.Application;

import com.example.opentrends003.mvp.retrofit.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by opentrends-003 on 8/2/18.
 */

public class MyApplication extends Application {
    public static ApiService service;


    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

    }
}
