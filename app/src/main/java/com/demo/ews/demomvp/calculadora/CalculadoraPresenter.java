package com.demo.ews.demomvp.calculadora;

public class CalculadoraPresenter implements CalculadoraContract.Presenter  {

    private CalculadoraContract.View view;

    public CalculadoraPresenter(CalculadoraContract.View view) {
        this.view = view;
    }

    @Override
    public void somar(int n1, int n2) {
        view.showResult(n1 + n2);
    }

    @Override
    public void subtrair(int n1, int n2) {
        view.showResult(n1 - n2);
    }

    @Override
    public void multiplicar(int n1, int n2) {
        view.showResult(n1 * n2);
    }

    @Override
    public void dividir(int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            view.validate("O numero não pode ser dividido por zero (0)");
            return;
        }
        view.showResult(n1 / n2);
    }

    @Override
    public void start() {
        view.initCalc();
    }
}
