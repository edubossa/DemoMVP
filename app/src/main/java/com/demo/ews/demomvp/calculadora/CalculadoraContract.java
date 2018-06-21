package com.demo.ews.demomvp.calculadora;

import com.demo.ews.demomvp.BasePresenter;
import com.demo.ews.demomvp.BaseView;

public interface CalculadoraContract {


    interface View extends BaseView<Presenter> {

       void showResult(int result);

       void initCalc();

       void validate(String message);

    }

    interface Presenter extends BasePresenter {

        void somar(int n1, int n2);

        void subtrair(int n1, int n2);

        void multiplicar(int n1, int n2);

        void dividir(int n1, int n2);

    }

}
