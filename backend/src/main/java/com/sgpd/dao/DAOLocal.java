package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.Local;
import com.sgpd.model.SingletonConexao;

public class DAOLocal {
    public boolean salvar(Local local) {
        String sql = "INSERT INTO local (nome_local, endereco_local, telefone_local, bairro_local, cep_local) VALUES ('$1', '$2', '$3', '$4', '$5')";
        sql = sql.replace("$1", local.getNome());
        sql = sql.replace("$2", local.getEndereco());
        sql = sql.replace("$3", local.getTelefone());
        sql = sql.replace("$4", local.getBairro());
        sql = sql.replace("$5", local.getCep());

        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean alterar(Local local) {
        String sql = "UPDATE local SET nome_local='$1', endereco_local='$2', telefone_local='$3', bairro_local='$4', cep_local='$5' WHERE idLocal = "
                + local.getId();
        sql = sql.replace("$1", local.getNome());
        sql = sql.replace("$2", local.getEndereco());
        sql = sql.replace("$3", local.getTelefone());
        sql = sql.replace("$4", local.getBairro());
        sql = sql.replace("$5", local.getCep());

        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean apagar(int id){
        String sql = "delete from local where idLocal = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public Local buscarUm(int idLocal) {
        Local novo = null;
        String sql = "SELECT * FROM local WHERE idLocal = " + idLocal;
    
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
    
        try {
            if (rs.next()) {
                novo = new Local(
                        rs.getInt("idLocal"),
                        rs.getString("nome_local"),
                        rs.getString("endereco_local"),
                        rs.getString("telefone_local"),
                        rs.getString("bairro_local"),
                        rs.getString("cep_local")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    
        return novo;
    }
    

    public ArrayList<Local> buscarTodos() {
        ArrayList<Local> locais = new ArrayList<>();
        String sql = "select * from local";
    
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
    
        try {
            while (rs.next()) {
                locais.add(
                        new Local(
                                rs.getInt("idLocal"),
                                rs.getString("nome_local"),
                                rs.getString("endereco_local"),
                                rs.getString("telefone_local"),
                                rs.getString("bairro_local"),
                                rs.getString("cep_local")
                        )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    
        return locais;
    }
    

}
