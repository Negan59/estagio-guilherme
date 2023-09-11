package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOFuncionario;

public class Funcionario extends Pessoa {
    private String senha;
    private boolean status;

    public boolean isStatus() {
        return status;
    }



    public String getSenha() {
        return senha;
    }



    public void setSenha(String senha) {
        this.senha = senha;
    }



    public Funcionario(String nome, String foto, String telefone, String email, String senha) {
        super(nome, foto, telefone, email);
        this.senha = senha;
    }



    public Funcionario(int id, String nome, String foto, String telefone, String email, String senha,boolean status) {
        super(id, nome, foto, telefone, email);
        this.senha = senha;
        this.status = status;
    }

    public Funcionario(){

    }

    @Override
    public boolean salvar() {
        DAOFuncionario dao = new DAOFuncionario();
        if (dao.salvar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean alterar() {
        DAOFuncionario dao = new DAOFuncionario();
        if (dao.alterar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean apagar(int id) {
        DAOFuncionario dao = new DAOFuncionario();
        return dao.apagar(id);
    }

    public boolean ativar(int id){
        DAOFuncionario dao = new DAOFuncionario();
        return dao.ativar(id);
    }

    public boolean desativar(int id){
        DAOFuncionario dao = new DAOFuncionario();
        return dao.desativar(id);
    }

    public ArrayList<Funcionario> buscarTodos() {
        DAOFuncionario dao = new DAOFuncionario();
        return dao.buscarTodos();
    }

    public ArrayList<Funcionario> buscarTodosInativos() {
        DAOFuncionario dao = new DAOFuncionario();
        return dao.buscarTodosInativos();
    }

    public Funcionario buscarUm(int id) {
        DAOFuncionario dao = new DAOFuncionario();
        return dao.buscarUm(id);
    }
    
}
