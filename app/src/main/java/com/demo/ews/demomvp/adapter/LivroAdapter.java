package com.demo.ews.demomvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.ews.demomvp.R;
import com.demo.ews.demomvp.model.Livro;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.LivroViewHolder> {

    private List<Livro> livros;
    private OnItemClickListener onItemClickListener;

    public LivroAdapter(List<Livro> livros,OnItemClickListener onItemClickListener) {
        this.livros = livros;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public LivroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.livro, parent, false);
        return new LivroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LivroViewHolder holder, int position) {
        final Livro livro = this.livros.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(livro);
            }
        });

        holder.cod.setText(livro.getCod().toString());
        holder.nomeLivro.setText(livro.getNomeLivro());
        holder.nomeAutor.setText(livro.getNomeAutor());
        holder.descricao.setText(livro.getDescricao());
        holder.preco.setText("R$ "+ livro.getPreco().toString());
    }

    @Override
    public int getItemCount() {
        return this.livros.size();
    }


    static class LivroViewHolder extends RecyclerView.ViewHolder {

        final TextView cod;
        final TextView nomeLivro;
        final TextView nomeAutor;
        final TextView descricao;
        final TextView preco;

        public LivroViewHolder(View itemView) {
            super(itemView);
            this.cod = (TextView) itemView.findViewById(R.id.codLivro);
            this.nomeLivro = (TextView) itemView.findViewById(R.id.nomeLivro);
            this.nomeAutor = (TextView) itemView.findViewById(R.id.nomeAutor);
            this.descricao = (TextView) itemView.findViewById(R.id.descricao);
            this.preco = (TextView) itemView.findViewById(R.id.preco);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(Livro livro);
    }


}
