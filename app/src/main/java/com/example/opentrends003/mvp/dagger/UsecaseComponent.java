package com.example.opentrends003.mvp.dagger;

import com.example.opentrends003.mvp.presenter.HomePresenter;

import dagger.Subcomponent;

/**
 * Created by opentrends-003 on 30/5/18.
 */
@Subcomponent(modules = {UsecaseModule.class})
public interface UsecaseComponent {
    void inject(HomePresenter homePresenter);

    @Subcomponent.Builder
    interface Builder {
        UsecaseComponent.Builder usecaserModule(UsecaseModule usecaseModule);
        UsecaseComponent build();
    }
}
