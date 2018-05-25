package com.example.opentrends003.mvp.view.activity;

import com.example.opentrends003.mvp.R;
import com.example.opentrends003.mvp.presenter.HomePresenter;
import com.example.opentrends003.mvp.utils.ActivityUtils;
import com.example.opentrends003.mvp.view.fragment.HomeFragment;

public class HomeActivity extends BaseActivity {


    @Override
    public void loadFragment() {
        HomeFragment homeFragment = new HomeFragment();
        HomePresenter homePresenter = new HomePresenter(homeFragment);


        ActivityUtils.addFragmentToActivity(getFragmentManager(),homeFragment,R.id.container);
    }
}
