package com.example.opentrends003.mvp;

import com.example.opentrends003.mvp.model.UserModel;
import com.example.opentrends003.mvp.presenter.contract.HomePresenterContract;
import com.example.opentrends003.mvp.retrofit.Model.response.Datum;
import com.example.opentrends003.mvp.retrofit.Model.response.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by opentrends-003 on 23/5/18.
 */

public class UseCase implements IUsecase.UsecaseInterface {

    private IRepo.repo data;
    private HomePresenterContract.Presenter mPresenter;

    public UseCase() {
        data = new Repository();
        data.setDomain(this);
    }

    List<UserModel> list = new ArrayList<>();
    @Override
    public void getApi(String page) {
       data.callApi(page);

    }

    @Override
    public void setData(Response<UserResponse> response) {
        List<Datum> dataList = response.body().getData();
        if(dataList!=null) {
            for (int i = 0; i < dataList.size(); i++) {
                UserModel userModel = new UserModel();
                userModel.setFirstName(dataList.get(i).getFirstName());
                userModel.setLastName(dataList.get(i).getLastName());
                list.add(userModel);
            }
            mPresenter.setRecyclerData(list);
        }
        else {
            mPresenter.setRecyclerData(new ArrayList<UserModel>());
        }
    }

    @Override
    public void setPresenter(HomePresenterContract.Presenter presenter) {
        mPresenter =presenter;
    }
}
