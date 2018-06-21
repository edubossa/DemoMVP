package com.demo.ews.demomvp.maindetail;

import com.demo.ews.demomvp.BasePresenter;
import com.demo.ews.demomvp.BaseView;
import com.demo.ews.demomvp.model.Livro;

public interface MainDetailContract {

    interface View extends BaseView<Presenter> {

        void carregarLivro(Livro livro);

    }

    interface Presenter extends BasePresenter {

    }

}
