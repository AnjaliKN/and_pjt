package com.example.opentrends003.mvp;

import com.example.opentrends003.mvp.model.UserModel;
import com.example.opentrends003.mvp.presenter.contract.HomePresenterContract;
import com.example.opentrends003.mvp.retrofit.Model.response.UserResponse;

import java.util.List;

import retrofit2.Response;

/**
 * Created by opentrends-003 on 23/5/18.
 */

public interface IUsecase {
    interface UsecaseInterface {
        void setData(Response<UserResponse> response);

        void getApi(String page);

        void setPresenter(HomePresenterContract.Presenter presenter);

    }
}
