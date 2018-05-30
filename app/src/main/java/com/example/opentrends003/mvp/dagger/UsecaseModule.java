package com.example.opentrends003.mvp.dagger;

import com.example.opentrends003.mvp.IUsecase;
import com.example.opentrends003.mvp.UseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by opentrends-003 on 30/5/18.
 */
@Module
public class UsecaseModule {
    @Provides
    public IUsecase.UsecaseInterface getPresenter() {
        return new UseCase();
    }
}
