package com.sgpd.model;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
    String senha;

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



    public Funcionario(int id, String nome, String foto, String telefone, String email, String senha) {
        super(id, nome, foto, telefone, email);
        this.senha = senha;
    }

    

    @Override
    public boolean salvar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public boolean alterar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }



    @Override
    public boolean apagar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apagar'");
    }
    
}
