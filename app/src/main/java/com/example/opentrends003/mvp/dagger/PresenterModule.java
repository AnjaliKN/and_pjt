package com.example.opentrends003.mvp.dagger;

import com.example.opentrends003.mvp.presenter.HomePresenter;
import com.example.opentrends003.mvp.presenter.contract.HomePresenterContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by opentrends-003 on 29/5/18.
 */
@Module
public class PresenterModule {


    @Provides
    public HomePresenterContract.Presenter getPresenter() {
        return new HomePresenter();
    }
}
