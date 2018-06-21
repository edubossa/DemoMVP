package com.demo.ews.demomvp.main;

import android.support.v7.widget.RecyclerView;

import com.demo.ews.demomvp.BasePresenter;
import com.demo.ews.demomvp.BaseView;
import com.demo.ews.demomvp.model.Livro;

import java.util.List;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void showListLivros(List<Livro> livros);

        /**
         * Chama a tela calculadora
         */
        void addCalculadora();

        /**
         * Chama a tela MainDetailActivity
         *
         * @param livro
         */
        void abrirTelaDetalhe(Livro livro);


    }

    interface Presenter extends BasePresenter {

        void detalheLivro(Livro livro);

        void loadLivros();

        void openCalculadora();

    }

}
