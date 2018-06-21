package com.demo.ews.demomvp.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Livro implements Parcelable {

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

    protected Livro(Parcel in) {
        if (in.readByte() == 0) {
            cod = null;
        } else {
            cod = in.readInt();
        }
        nomeLivro = in.readString();
        nomeAutor = in.readString();
        descricao = in.readString();
        if (in.readByte() == 0) {
            preco = null;
        } else {
            preco = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (cod == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cod);
        }
        dest.writeString(nomeLivro);
        dest.writeString(nomeAutor);
        dest.writeString(descricao);
        if (preco == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(preco);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Livro> CREATOR = new Creator<Livro>() {
        @Override
        public Livro createFromParcel(Parcel in) {
            return new Livro(in);
        }

        @Override
        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };

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
