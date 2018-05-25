package com.example.opentrends003.mvp.view.fragment;


import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.opentrends003.mvp.R;
import com.example.opentrends003.mvp.model.UserModel;
import com.example.opentrends003.mvp.presenter.HomePresenter;
import com.example.opentrends003.mvp.presenter.contract.HomePresenterContract;
import com.example.opentrends003.mvp.view.adapter.UserAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomePresenterContract.View {
    private HomePresenterContract.Presenter mPresenter;
    private Button clickMeButton;
    private EditText page;
    private LinearLayoutManager layoutManager;
    RecyclerView mRecyclerView;
    private UserAdapter userAdapter;
    private ProgressBar mprogressBar;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void startPresenter(HomePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews() {
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
