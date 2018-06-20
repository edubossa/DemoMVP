package com.demo.ews.demomvp.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.demo.ews.demomvp.R;
import com.demo.ews.demomvp.adapter.LivroAdapter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final String TAG = "AppCompatActivity";

    private RecyclerView recyclerView;
    private MainContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Passo a minha Activity como parametro para o meu presenter
        mPresenter = new MainPresenter(this);

        //Instanciando meu RecyclerView
        this.recyclerView = (RecyclerView) findViewById(R.id.livroRecyclerView);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //TODO ao inves de iniciar aqui esta chamando no mPresenter.start()
        //this.recyclerView.setAdapter(new LivroAdapter(mPresenter.buscarLivros(), mPresenter));

        mPresenter.start();


        FloatingActionButton newCalculator = (FloatingActionButton) findViewById(R.id.fab);
        newCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculadora(); //TODO ver se faz sentido chamar aqui
            }
        });
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


    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public RecyclerView getRecyclerView() { //TODO ver se faz sentido disponibilizei no MainContract.View
        return recyclerView;
    }

    @Override
    public void calculadora() {
        Log.d("TAG", "chamando tela calcularoda");
    }



}
