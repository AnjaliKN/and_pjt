package com.example.opentrends003.mvp.presenter.contract;

import com.example.opentrends003.mvp.model.UserModel;
import com.example.opentrends003.mvp.presenter.HomePresenter;
import com.example.opentrends003.mvp.view.fragment.HomeFragment;

import java.util.List;

/**
 * Created by opentrends-003 on 7/2/18.
 */

public interface HomePresenterContract {


    interface View {

        void setRecyclerViewData(List<UserModel> list);

    }

    interface Presenter {
        void getData(String page);

        void setRecyclerData(List<UserModel> list);

        void setView(View view);

    }
}
