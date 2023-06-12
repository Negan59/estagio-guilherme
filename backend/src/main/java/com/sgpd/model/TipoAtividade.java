package com.sgpd.model;

import java.util.ArrayList;

public class TipoAtividade {
    private int id;
    private String nome;
    private boolean status;

    public TipoAtividade(String nome, boolean status) {
        this.nome = nome;
        this.status = status;
    }

    public TipoAtividade(int id, String nome, boolean status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean salvar() {
        return false;
    }

    public boolean alterar() {
        return false;
    }

    public ArrayList<TipoAtividade> buscarTodos() {
        return null;
    }

    public boolean apagar(int id) {
        return false;
    }

    public TipoAtividade buscarUm(int id) {
        return null;
    }

}
