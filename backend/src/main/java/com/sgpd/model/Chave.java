package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOChave;

public class Chave {
    private int id;
    private String nome;
    private Sala sala;
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
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public Chave(int id, String nome, Sala sala) {
        this.id = id;
        this.nome = nome;
        this.sala = sala;
    }
    public Chave() {
    }
    public Chave(String nome, Sala sala) {
        this.nome = nome;
        this.sala = sala;
    }

    public boolean salvar() {
        DAOChave dao = new DAOChave();
        if (dao.salvar(this)) {
            return true;
        }
        return false;

    }

    public boolean alterar() {
        DAOChave dao = new DAOChave();
        if (dao.alterar(this)) {
            return true;
        }
        return false;

    }

    public ArrayList<Chave> buscarTodos() {
        DAOChave dao = new DAOChave();
        return dao.buscarTodos();

    }

    public boolean apagar(int id) {
        DAOChave dao = new DAOChave();
        return dao.apagar(id);

    }

    public Chave buscarUm(int id) {
        DAOChave dao = new DAOChave();
        return dao.buscarUm(id);

    }


}
