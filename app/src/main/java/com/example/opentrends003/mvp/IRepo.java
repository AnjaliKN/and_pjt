package com.example.opentrends003.mvp;

/**
 * Created by opentrends-003 on 23/5/18.
 */

public interface IRepo {
     interface repo {
         void callApi(String page);

         void setDomain(UseCase domain);
     }
}
