package com.example.opentrends003.mvp;

import android.app.Application;

import com.example.opentrends003.mvp.dagger.AppComponent;
import com.example.opentrends003.mvp.dagger.AppModule;
import com.example.opentrends003.mvp.dagger.DaggerAppComponent;
import com.example.opentrends003.mvp.dagger.PresenterComponent;
import com.example.opentrends003.mvp.dagger.PresenterModule;
import com.example.opentrends003.mvp.retrofit.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by opentrends-003 on 8/2/18.
 */

public class MyApplication extends Application {
    public static ApiService service;
    private AppComponent appComponent;
    private PresenterComponent presenterComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
        setBuilder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

    }

    public void setBuilder() {
        presenterComponent = appComponent.getBuilder().presenterModule(new PresenterModule()).build();
    }

}
