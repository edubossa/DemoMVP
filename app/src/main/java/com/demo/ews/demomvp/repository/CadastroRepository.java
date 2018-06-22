package com.demo.ews.demomvp.repository;

import com.demo.ews.demomvp.model.Cadastro;

import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {

    static List<Cadastro> cadastros = new ArrayList<>();

    public static void add(Cadastro c) {
        cadastros.add(c);
    }

    public static void remove(Cadastro c) {
        cadastros.remove(c);
    }

    public static List<Cadastro> findAll() {
        return cadastros;
    }

}
