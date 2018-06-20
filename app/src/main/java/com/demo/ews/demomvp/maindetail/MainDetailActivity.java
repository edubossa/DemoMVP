package com.demo.ews.demomvp.maindetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.ews.demomvp.R;

public class MainDetailActivity extends AppCompatActivity implements MainDetailContract.View {

    private MainDetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        this.mPresenter = new MainDetailPresenter(this);

    }

    @Override
    public void setPresenter(MainDetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
