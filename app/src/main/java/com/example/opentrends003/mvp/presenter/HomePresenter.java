package com.example.opentrends003.mvp.presenter;

import com.example.opentrends003.mvp.IUsecase;
import com.example.opentrends003.mvp.dagger.PresenterComponent;
import com.example.opentrends003.mvp.dagger.UsecaseComponent;
import com.example.opentrends003.mvp.model.UserModel;
import com.example.opentrends003.mvp.presenter.contract.HomePresenterContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by opentrends-003 on 7/2/18.
 */

public class HomePresenter implements HomePresenterContract.Presenter {

    private HomePresenterContract.View mView;
    @Inject
    IUsecase.UsecaseInterface domaiInterface;

    public void setView(HomePresenterContract.View mView) {
        this.mView = mView;

    }

    @Override
    public void setComponent(UsecaseComponent component) {
        component.inject(this);
        domaiInterface.setPresenter(this);
    }

    public HomePresenter() {

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

