package com.example.opentrends003.mvp.dagger;

import dagger.Component;

/**
 * Created by opentrends-003 on 30/5/18.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {
    PresenterComponent.Builder getBuilder();

}
