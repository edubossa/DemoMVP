package com.demo.ews.demomvp.cadastro;

import com.demo.ews.demomvp.BasePresenter;
import com.demo.ews.demomvp.BaseView;
import com.demo.ews.demomvp.model.Cadastro;

public interface CadastroContract {

    interface View extends BaseView<Presenter> {

        void showToastMessage(String message);

        void showMain();
    }

    interface Presenter extends BasePresenter {

        void save(Cadastro c);

        void cancel();

    }


}
