package com.demo.ews.demomvp.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demo.ews.demomvp.BasePresenter;
import com.demo.ews.demomvp.BaseView;
import com.demo.ews.demomvp.model.Livro;

import java.util.List;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        RecyclerView getRecyclerView();

        /**
         * Chama a tela calculadora
         */
        void calculadora();

    }

    interface Presenter extends BasePresenter {

        void onItemClick(Livro livro);

        List<Livro> buscarLivros();

    }

}
