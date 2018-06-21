package com.demo.ews.demomvp.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.demo.ews.demomvp.model.Livro;
import com.demo.ews.demomvp.repository.LivroRepository;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detalheLivro(Livro livro) {
        Log.d("MainPresenter", "Livro selecionado --> "+  livro.toString());
        Livro l = LivroRepository.findLivro(livro);
        view.abrirTelaDetalhe(l);
    }

    @Override
    public void loadLivros() {
        view.showListLivros(LivroRepository.livros());
    }

    @Override
    public void openCalculadora() {
        view.addCalculadora();
    }


    @Override
    public void start() {
        loadLivros();
    }
}
