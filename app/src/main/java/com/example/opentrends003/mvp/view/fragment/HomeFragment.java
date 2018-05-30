package com.example.opentrends003.mvp.view.fragment;


import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.opentrends003.mvp.MyApplication;
import com.example.opentrends003.mvp.R;
import com.example.opentrends003.mvp.dagger.PresenterComponent;
import com.example.opentrends003.mvp.dagger.UsecaseComponent;
import com.example.opentrends003.mvp.model.UserModel;
import com.example.opentrends003.mvp.presenter.contract.HomePresenterContract;
import com.example.opentrends003.mvp.view.adapter.UserAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomePresenterContract.View {
    private Button clickMeButton;
    private EditText page;
    private LinearLayoutManager layoutManager;
    RecyclerView mRecyclerView;
    private UserAdapter userAdapter;
    private ProgressBar mprogressBar;
    UsecaseComponent usecaseComponent;
    @Inject
    HomePresenterContract.Presenter mPresenter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void inject() {
        ((MyApplication) getActivity().getApplication()).getPresenterComponent().inject(this);
        usecaseComponent = ((MyApplication) getActivity().getApplication()).getUsecaseComponent();
    }


    @Override
    public void initViews() {
        inject();
        mPresenter.setView(this);
        mPresenter.setComponent(usecaseComponent);

        mprogressBar = getRootView().findViewById(R.id.progressbar);
        clickMeButton = getRootView().findViewById(R.id.button);
        page = getRootView().findViewById(R.id.page);
        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mprogressBar.setVisibility(View.VISIBLE);
                mPresenter.getData(page.getText().toString());
            }
        });

        mRecyclerView = getRootView().findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        userAdapter = new UserAdapter(null);
        mRecyclerView.setAdapter(userAdapter);

    }

    @Override
    public void setRecyclerViewData(List<UserModel> list) {
        mprogressBar.setVisibility(View.INVISIBLE);
        userAdapter.setData(list);
    }


}
