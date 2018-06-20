package com.demo.ews.demomvp.main;

import android.support.v7.widget.RecyclerView;

import com.demo.ews.demomvp.BasePresenter;
import com.demo.ews.demomvp.BaseView;
import com.demo.ews.demomvp.model.Livro;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        //RecyclerView getRecyclerView();

        /**
         * Chama a tela calculadora
         */
        void addCalculadora();

        /**
         * Chama a tela MainDetailActivity
         *
         * @param livro
         */
        void detail(Livro livro);


    }

    interface Presenter extends BasePresenter {

        /**
         * Obtem o evento do click da lista, e redireciona pra tela de detalhe
         *
         * @param livro
         */
        void onItemClick(Livro livro);


    }

}
