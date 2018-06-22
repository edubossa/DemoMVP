package com.demo.ews.demomvp.cadastro;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.demo.ews.demomvp.R;
import com.demo.ews.demomvp.main.MainActivity;
import com.demo.ews.demomvp.model.Cadastro;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroActivity extends AppCompatActivity implements CadastroContract.View {

    public static final String TAG = "CadastroActivity";

    @BindView(R.id.nome_edit_text)
    TextInputEditText nome;

    @BindView(R.id.email_edit_text)
    TextInputEditText email;

    @BindView(R.id.telefone_edit_text)
    TextInputEditText telefone;

    CadastroContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);

        mPresenter = new CadastroPresenter(this);
    }

    @OnClick(R.id.bt_salvar)
    public void salvar(){
        Cadastro c = new Cadastro(nome.getText().toString(), email.getText().toString(), telefone.getText().toString());
        Log.d(TAG, "Salvando dados... --> " + c.toString());
        mPresenter.save(c);
    }

    @OnClick(R.id.bt_cancelar)
    public void cancelar() {
        Log.d(TAG, "Cancelando dados...");
        mPresenter.cancel();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMain() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void setPresenter(CadastroContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
