package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOPadre;

public class Padre extends Pessoa {
    private String paroquia;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Padre(String nome, String foto, String telefone, String email, String paroquia) {
        super(nome, foto, telefone, email);
        this.paroquia = paroquia;
    }

    public Padre(int id, String nome, String foto, String telefone, String email, String paroquia,boolean status) {
        super(id, nome, foto, telefone, email);
        this.paroquia = paroquia;
        this.status = status;
    }

    public Padre(int id, String nome, String foto, String telefone, String email) {
        super(id, nome, foto, telefone, email);
    }

    public Padre(){
        
    }

    public String getParoquia() {
        return paroquia;
    }

    public void setParoquia(String paroquia) {
        this.paroquia = paroquia;
    }

    @Override
    public boolean salvar() {
        DAOPadre dao = new DAOPadre();
        if (dao.salvar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean alterar() {
        DAOPadre dao = new DAOPadre();
        if (dao.alterar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean apagar(int id) {
        DAOPadre dao = new DAOPadre();
        return dao.apagar(id);
    }

    public boolean ativar(int id){
        DAOPadre dao = new DAOPadre();
        return dao.ativar(id);
    }

    public boolean desativar(int id){
        DAOPadre dao = new DAOPadre();
        return dao.desativar(id);
    }

    public ArrayList<Padre> buscarTodos() {
        DAOPadre dao = new DAOPadre();
        return dao.buscarTodos();
    }

    public ArrayList<Padre> buscarTodosInativos() {
        DAOPadre dao = new DAOPadre();
        return dao.buscarTodosInativos();
    }

    public Padre buscarUm(int id) {
        DAOPadre dao = new DAOPadre();
        return dao.buscarUm(id);
    }

}
