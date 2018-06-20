package com.demo.ews.demomvp.main;

import com.demo.ews.demomvp.adapter.LivroAdapter;
import com.demo.ews.demomvp.model.Livro;
import com.demo.ews.demomvp.repository.LivroRepository;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onItemClick(Livro livro) {
        System.out.println("Livro selecionado --> "+ livro);
    }

    @Override
    public List<Livro> buscarLivros() {
        List<Livro> livros = LivroRepository.livros();
        return livros;
    }


    @Override
    public void start() {
        System.out.println("MainPresenter.start");
        this.view.getRecyclerView().setAdapter(new LivroAdapter(buscarLivros(), this));

    }
}
