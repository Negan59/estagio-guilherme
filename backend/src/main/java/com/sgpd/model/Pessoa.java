package com.sgpd.model;

import java.util.ArrayList;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String foto;
    private String telefone;
    private String email;

    public Pessoa(String nome, String foto, String telefone, String email) {
        this.nome = nome;
        this.foto = foto;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa(int id, String nome, String foto, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa() {

    }

    public abstract boolean salvar();

    public abstract boolean alterar();

    public abstract boolean apagar(int id);

}
