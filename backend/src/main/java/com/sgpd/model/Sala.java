package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOSala;

public class Sala {
    private int id;
    private int numerosala;
    private String descricaosala;

    public Sala(int numerosala, String descricaosala) {
        this.numerosala = numerosala;
        this.descricaosala = descricaosala;
    }

    public Sala(int id, int numerosala, String descricaosala) {
        this.id = id;
        this.numerosala = numerosala;
        this.descricaosala = descricaosala;
    }

    public Sala() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumerosala() {
        return numerosala;
    }

    public void setNumerosala(int numerosala) {
        this.numerosala = numerosala;
    }

    public String getDescricaosala() {
        return descricaosala;
    }

    public void setDescricaosala(String descricaosala) {
        this.descricaosala = descricaosala;
    }

    public boolean salvar() {
        DAOSala dao = new DAOSala();
        if (dao.salvar(this)) {
            return true;
        }
        return false;

    }

    public boolean alterar() {
        DAOSala dao = new DAOSala();
        if (dao.alterar(this)) {
            return true;
        }
        return false;

    }

    public ArrayList<Sala> buscarTodos() {
        DAOSala dao = new DAOSala();
        return dao.buscarTodos();

    }

    public boolean apagar(int id) {
        DAOSala dao = new DAOSala();
        return dao.apagar(id);

    }

    public Sala buscarUm(int id) {
        DAOSala dao = new DAOSala();
        return dao.buscarUm(id);

    }

}
