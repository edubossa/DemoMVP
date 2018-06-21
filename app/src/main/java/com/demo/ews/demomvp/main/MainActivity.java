package com.demo.ews.demomvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.demo.ews.demomvp.R;
import com.demo.ews.demomvp.adapter.LivroAdapter;
import com.demo.ews.demomvp.calculadora.CalculadoraActivity;
import com.demo.ews.demomvp.maindetail.MainDetailActivity;
import com.demo.ews.demomvp.model.Livro;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final String TAG = "AppCompatActivity";

    private RecyclerView recyclerView;
    private MainContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instanciando meu RecyclerView
        this.recyclerView = (RecyclerView) findViewById(R.id.livroRecyclerView);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //TODO ao inves de iniciar aqui esta chamando no mPresenter.start()
        //this.recyclerView.setAdapter(new LivroAdapter(mPresenter.buscarLivros(), mPresenter));

        //Passo a minha Activity como parametro para o meu presenter
        mPresenter = new MainPresenter(this);

        FloatingActionButton newCalculator = (FloatingActionButton) findViewById(R.id.fab);
        newCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.openCalculadora();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    LivroAdapter.OnItemClickListener listener = new LivroAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Livro livro) {
            mPresenter.detalheLivro(livro);
        }
    };



    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void showListLivros(List<Livro> livros) {
        recyclerView.setAdapter(new LivroAdapter(livros, listener));
    }

    @Override
    public void addCalculadora() {
        Log.d("TAG", "chamando tela calculadora");
        //Toast.makeText(this, "TELA EM CONSTRUCAO", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, CalculadoraActivity.class));
    }

    @Override
    public void abrirTelaDetalhe(Livro livro) {
        Log.d("TAG", "chamando tela detalhe");
        Intent intent = new Intent(this, MainDetailActivity.class);
        intent.putExtra("LIVRO_SELECTED", livro);
        startActivity(intent);
    }


}
