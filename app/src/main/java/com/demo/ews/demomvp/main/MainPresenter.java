package com.demo.ews.demomvp.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.demo.ews.demomvp.adapter.LivroAdapter;
import com.demo.ews.demomvp.model.Livro;
import com.demo.ews.demomvp.repository.LivroRepository;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private RecyclerView recyclerView;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    public MainPresenter(MainContract.View view, RecyclerView recyclerView) {
        this.view = view;
        this.recyclerView = recyclerView;
    }

    @Override
    public void onItemClick(Livro livro) {
        Log.d("MainPresenter", "Livro selecionado --> "+  livro.toString());
        Livro l = LivroRepository.findLivro(livro);
        view.detail(l);
    }


    @Override
    public void start() {
        System.out.println("MainPresenter.start");
        recyclerView.setAdapter(new LivroAdapter(LivroRepository.livros(), this));

    }
}
