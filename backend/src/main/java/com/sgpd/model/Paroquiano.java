package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOParoquiano;

public class Paroquiano extends Pessoa {

    private String senha;

    public Paroquiano(int id, String nome, String foto, String telefone, String email) {
        super(id, nome, foto, telefone, email);
    }

    public Paroquiano(String nome, String foto, String telefone, String email, String senha) {
        super(nome, foto, telefone, email);
        this.senha = senha;
    }

    public Paroquiano(int id, String nome, String foto, String telefone, String email, String senha) {
        super(id, nome, foto, telefone, email);
        this.senha = senha;
    }

    /**
     * 
     */
    public Paroquiano() {
        super();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean salvar() {
        DAOParoquiano dao = new DAOParoquiano();
        if (dao.salvar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean alterar() {
        DAOParoquiano dao = new DAOParoquiano();
        if (dao.alterar(this)) {
            return true;
        }
        return false;
    }

    public ArrayList<Paroquiano> buscarTodos(String filtro) {
        DAOParoquiano dao = new DAOParoquiano();
        return dao.buscarTodos(filtro);
    }

    @Override
    public boolean apagar(int id) {
        DAOParoquiano dao = new DAOParoquiano();
        return dao.apagar(id);
    }

    public Paroquiano buscarUm(int id) {
        DAOParoquiano dao = new DAOParoquiano();
        return dao.buscarUm(id);
    }
}
