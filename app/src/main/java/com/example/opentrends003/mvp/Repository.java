package com.example.opentrends003.mvp;

import android.widget.Toast;

import com.example.opentrends003.mvp.retrofit.Model.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by opentrends-003 on 23/5/18.
 */

public class Repository implements IRepo.repo {
    private IUsecase.UsecaseInterface domaiInterface;

    public Repository() {
        //this.domaiInterface = new UseCase();
    }

    //List<UserModel> list = new ArrayList<>();

    @Override
    public void callApi(String page) {

        Call<UserResponse> call = MyApplication.service.getUser(page);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                domaiInterface.setData(response);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                //default implementation ignored
            }
        });
    }

    @Override
    public void setDomain(UseCase domain) {
        domaiInterface = domain;
    }
}
