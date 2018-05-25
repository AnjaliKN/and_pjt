package com.example.opentrends003.mvp.retrofit;

import com.example.opentrends003.mvp.retrofit.Model.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by opentrends-003 on 8/2/18.
 */

public interface ApiService {
    @GET("api/users")
    Call<UserResponse> getUser(@Query("page") String page);


}
