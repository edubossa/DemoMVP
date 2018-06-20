package com.demo.ews.demomvp.model;

import java.io.Serializable;


public class Livro implements Serializable {

    private final Integer cod;
    private final String nomeLivro;
    private final String nomeAutor;
    private final String descricao;
    private final Double preco;

    public Livro(Integer cod, String nomeLivro, String nomeAutor, String descricao, Double preco) {
        this.cod = cod;
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Integer getCod() {
        return cod;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "cod=" + cod +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
