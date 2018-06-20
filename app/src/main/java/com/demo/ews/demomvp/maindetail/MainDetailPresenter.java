package com.demo.ews.demomvp.maindetail;

public class MainDetailPresenter implements MainDetailContract.Presenter {

    private MainDetailContract.View view;

    public MainDetailPresenter(MainDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }
}
