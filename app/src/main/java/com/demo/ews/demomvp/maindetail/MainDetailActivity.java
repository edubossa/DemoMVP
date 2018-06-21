package com.demo.ews.demomvp.maindetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.demo.ews.demomvp.R;
import com.demo.ews.demomvp.model.Livro;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainDetailActivity extends AppCompatActivity implements MainDetailContract.View {

    @BindView(R.id.cod_text_view) TextView cod;
    @BindView(R.id.livro_text_view) TextView livro;
    @BindView(R.id.autor_text_view) TextView autor;
    @BindView(R.id.descricao_text_view) TextView descricao;
    @BindView(R.id.preco_text_view) TextView preco;

    private MainDetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);
        ButterKnife.bind(this);

        this.mPresenter = new MainDetailPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Livro livro = getIntent().getParcelableExtra("LIVRO_SELECTED");
        carregarLivro(livro);
    }

    @Override
    public void setPresenter(MainDetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void carregarLivro(Livro livro) {
        Log.d("MainDetailActivity", livro.toString());
        this.cod.setText(livro.getCod().toString());
        this.livro.setText(livro.getNomeLivro());
        this.autor.setText(livro.getNomeAutor());
        this.descricao.setText(livro.getDescricao());
        this.preco.setText("R$ "+ livro.getPreco().toString());
    }
}
