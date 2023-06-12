package com.sgpd.model;

import java.util.ArrayList;

public class Local {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String bairro;
    private String cep;

    public Local(String nome, String endereco, String telefone, String bairro, String cep) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Local(int id, String nome, String endereco, String telefone, String bairro, String cep) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cep = cep;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean salvar() {
        return false;
    }

    public boolean alterar() {
        return false;
    }

    public ArrayList<Local> buscarTodos() {
        return null;
    }

    public boolean apagar(int id) {
        return false;
    }

    public Local buscarUm(int id) {
        return null;
    }
}
