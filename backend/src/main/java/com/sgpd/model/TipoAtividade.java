package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOTipoAtividade;

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

    public TipoAtividade(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public TipoAtividade(){
        
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
        DAOTipoAtividade dao = new DAOTipoAtividade();
        if (dao.salvar(this)) {
            return true;
        }
        return false;
    }

    public boolean alterar() {
        DAOTipoAtividade dao = new DAOTipoAtividade();
        if (dao.alterar(this)) {
            return true;
        }
        return false;
    }

    public boolean ativar(int id){
        DAOTipoAtividade dao = new DAOTipoAtividade();
        return dao.ativar(id);
    }

    public boolean desativar(int id){
        DAOTipoAtividade dao = new DAOTipoAtividade();
        return dao.desativar(id);
    }

    public ArrayList<TipoAtividade> buscarTodos() {
        DAOTipoAtividade dao = new DAOTipoAtividade();
        return dao.buscarTodos();
    }

    public ArrayList<TipoAtividade> buscarTodosInativos() {
        DAOTipoAtividade dao = new DAOTipoAtividade();
        return dao.buscarTodosInativos();
    }

    public TipoAtividade buscarUm(int id) {
        DAOTipoAtividade dao = new DAOTipoAtividade();
        return dao.buscarUm(id);
    }

}
