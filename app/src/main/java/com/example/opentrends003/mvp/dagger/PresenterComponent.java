package com.example.opentrends003.mvp.dagger;

import com.example.opentrends003.mvp.view.fragment.HomeFragment;

import dagger.Subcomponent;

/**
 * Created by opentrends-003 on 29/5/18.
 */
@Subcomponent(modules = {PresenterModule.class})
public interface PresenterComponent {
    void inject(HomeFragment homeFragment);

    @Subcomponent.Builder
    interface Builder {
        Builder presenterModule(PresenterModule presenterModule);
        PresenterComponent build();
    }
}
