package com.demo.ews.demomvp.cadastro;

import android.util.Log;

import com.demo.ews.demomvp.model.Cadastro;
import com.demo.ews.demomvp.repository.CadastroRepository;

public class CadastroPresenter implements CadastroContract.Presenter {

    private CadastroContract.View view;

    public CadastroPresenter(CadastroContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void save(Cadastro c) {
        Log.d("CadastroPresenter", CadastroRepository.findAll().toString());
        CadastroRepository.add(c);
        view.showToastMessage("Dados inseridos com sucesso!");
        view.showMain();
    }

    @Override
    public void cancel() {
        view.showMain();
    }
}
