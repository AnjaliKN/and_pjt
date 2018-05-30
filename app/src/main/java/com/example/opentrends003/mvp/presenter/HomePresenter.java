package com.example.opentrends003.mvp.presenter;

import com.example.opentrends003.mvp.UseCase;
import com.example.opentrends003.mvp.IUsecase;
import com.example.opentrends003.mvp.model.UserModel;
import com.example.opentrends003.mvp.presenter.contract.HomePresenterContract;

import java.util.List;

/**
 * Created by opentrends-003 on 7/2/18.
 */

public class HomePresenter implements HomePresenterContract.Presenter {

    private HomePresenterContract.View mView;
    private IUsecase.UsecaseInterface domaiInterface;

    public void setView(HomePresenterContract.View mView) {
        this.mView = mView;
    }

    public HomePresenter() {
        this.domaiInterface = new UseCase();
        domaiInterface.setPresenter(this);
    }

    @Override
    public void getData(String page) {
        domaiInterface.getApi(page);
    }

    @Override
    public void setRecyclerData(List<UserModel> list) {
        mView.setRecyclerViewData(list);
    }

}

