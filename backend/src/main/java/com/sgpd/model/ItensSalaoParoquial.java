package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOItensSalaoParoquial;

public class ItensSalaoParoquial {
    private int id;
    private String nome;
    private boolean status;
    
    public ItensSalaoParoquial(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public ItensSalaoParoquial() {
    }
    public ItensSalaoParoquial(String nome) {
        this.nome = nome;
    }
    public ItensSalaoParoquial(String nome, boolean status) {
        this.nome = nome;
        this.status = status;
    }
    public ItensSalaoParoquial(int id, String nome, boolean status) {
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
        DAOItensSalaoParoquial dao = new DAOItensSalaoParoquial();
        if (dao.salvar(this)) {
            return true;
        }
        return false;
    }

    public boolean alterar() {
        DAOItensSalaoParoquial dao = new DAOItensSalaoParoquial();
        if (dao.alterar(this)) {
            return true;
        }
        return false;
    }

    public boolean ativar(int id){
        DAOItensSalaoParoquial dao = new DAOItensSalaoParoquial();
        return dao.ativar(id);
    }

    public boolean desativar(int id){
        DAOItensSalaoParoquial dao = new DAOItensSalaoParoquial();
        return dao.desativar(id);
    }

    public ArrayList<ItensSalaoParoquial> buscarTodos() {
        DAOItensSalaoParoquial dao = new DAOItensSalaoParoquial();
        return dao.buscarTodos();
    }

    public ArrayList<ItensSalaoParoquial> buscarTodosInativos() {
        DAOItensSalaoParoquial dao = new DAOItensSalaoParoquial();
        return dao.buscarTodosInativos();
    }

    public ItensSalaoParoquial buscarUm(int id) {
        DAOItensSalaoParoquial dao = new DAOItensSalaoParoquial();
        return dao.buscarUm(id);
    }
}
