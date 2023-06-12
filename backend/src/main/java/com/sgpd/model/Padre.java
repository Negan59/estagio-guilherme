package com.sgpd.model;

import java.util.ArrayList;

public class Padre extends Pessoa {
    private String paroquia;

    public Padre(String nome, String foto, String telefone, String email, String paroquia) {
        super(nome, foto, telefone, email);
        this.paroquia = paroquia;
    }

    public Padre(int id, String nome, String foto, String telefone, String email, String paroquia) {
        super(id, nome, foto, telefone, email);
        this.paroquia = paroquia;
    }

    public String getParoquia() {
        return paroquia;
    }

    public void setParoquia(String paroquia) {
        this.paroquia = paroquia;
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
