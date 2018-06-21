package com.demo.ews.demomvp.calculadora;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.demo.ews.demomvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculadoraActivity extends AppCompatActivity implements CalculadoraContract.View {

    @BindView(R.id.n1_input_text) TextInputEditText n1;
    @BindView(R.id.n2_input_text) TextInputEditText n2;

    private CalculadoraContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        ButterKnife.bind(this);

        this.mPresenter = new CalculadoraPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(CalculadoraContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @OnClick(R.id.bt_somar)
    public void somarClick() {
        mPresenter.somar(Integer.valueOf(n1.getText().toString()), Integer.valueOf(n2.getText().toString()));
    }

    @OnClick(R.id.bt_subtrair)
    public void subtrairClick() {
        mPresenter.subtrair(Integer.valueOf(n1.getText().toString()), Integer.valueOf(n2.getText().toString()));
    }

    @OnClick(R.id.bt_multiplicar)
    public void multiplicarClick() {
        mPresenter.multiplicar(Integer.valueOf(n1.getText().toString()), Integer.valueOf(n2.getText().toString()));
    }

    @OnClick(R.id.bt_dividir)
    public void dividirClick() {
        mPresenter.dividir(Integer.valueOf(n1.getText().toString()), Integer.valueOf(n2.getText().toString()));
    }

    @OnClick(R.id.bt_ac)
    public void ac() {
        initCalc();
    }

    @Override
    public void showResult(int result) {
        Toast.makeText(this, "" + result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initCalc() {
        n1.setText("0");
        n2.setText("0");
    }

    @Override
    public void validate(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
