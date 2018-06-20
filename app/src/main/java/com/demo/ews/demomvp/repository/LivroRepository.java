package com.demo.ews.demomvp.repository;

import com.demo.ews.demomvp.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    private static List<Livro> livros = new ArrayList<>();

    static {
        livros.add(new Livro(231, "JSF in Action", "JP. LIKORG", "DESCRICAO LIVRO X1", 89.88));
        livros.add(new Livro(232, "Struts in Action", "Wallace ME.", "DESCRICAO LIVRO X2", 67.54));
        livros.add(new Livro(233, "Android v1", "Wallace", "DESCRICAO LIVRO V1", 110.23));
        livros.add(new Livro(234, "Android v2", "Wallace", "DESCRICAO LIVRO V2", 56.76));
        livros.add(new Livro(235, "Android v3", "Wallace", "DESCRICAO LIVRO V3", 98.78));
        livros.add(new Livro(236, "Android v4", "Wallace", "DESCRICAO LIVRO V4", 112.43));
        livros.add(new Livro(237, "Android v5", "Wallace", "DESCRICAO LIVRO V5", 223.34));
        livros.add(new Livro(238, "Android v6", "Wallace", "DESCRICAO LIVRO V6", 98.45));
        livros.add(new Livro(239, "Android v7", "Wallace", "DESCRICAO LIVRO V7", 99.99));
        livros.add(new Livro(240, "Android v8", "Wallace", "DESCRICAO LIVRO V8", 232.23));
    }

    public static List<Livro> livros() {
        return livros;
    }

    public static Livro findLivro(final Livro livro) {
        for(Livro l : livros) {
            if (l.getCod() == livro.getCod()) return l;
        }
        return null;
    }

}
