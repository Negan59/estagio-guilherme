package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.Aluguel;
import com.sgpd.model.SingletonConexao;

public class DAOAluguel {
    public boolean salvar(Aluguel u) {
        try {
            String sql = "insert into aluguel (nome_aluguel,documento_aluguel,valor_aluguel,valoradicional_aluguel,data_contrato,telefone_aluguel) values ('$1','$2',$3,$4,'$5','$6')";
            sql = sql.replace("$1", u.getNomealuguel());
            sql = sql.replace("$2", u.getDocumento());
            sql = sql.replace("$3", ""+u.getValor());
            sql = sql.replace("$4", ""+u.getValoradicional());
            sql = sql.replace("$5", ""+u.getData());
            sql = sql.replace("$6", u.getTelefone());
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(Aluguel u){
        String sql = "update aluguel set nome_aluguel='$1', documento_aluguel='$2', valor_aluguel=$3, valoradicional_aluguel=$4, data_contrato='$5', telefone_aluguel='$6' where idAluguel = "+u.getId();
        sql = sql.replace("$1", u.getNomealuguel());
        sql = sql.replace("$2", u.getDocumento());
        sql = sql.replace("$3", ""+u.getValor());
        sql = sql.replace("$4", ""+u.getValoradicional());
        sql = sql.replace("$5", ""+u.getData());
        sql = sql.replace("$6", u.getTelefone());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public ArrayList<Aluguel> buscarTodos() {
        ArrayList<Aluguel> Lista = new ArrayList<>();
        String sql = "SELECT * FROM aluguel;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(new Aluguel(
                    rs.getInt("idAluguel"),
                    rs.getString("nome_aluguel"),
                    rs.getString("documento_aluguel"),
                    rs.getDouble("valor_aluguel"),
                    rs.getDouble("valoradicional_aluguel"),
                    rs.getDate("data_contrato").toLocalDate(),
                    rs.getString("telefone_aluguel")
                ));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }


    public Aluguel buscarUm(int id){
        Aluguel aluguel = null;
        String sql = "SELECT * FROM aluguel where idAluguel = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
    
        try {
            if (rs.next())
                aluguel = new Aluguel(
                    rs.getInt("idAluguel"),
                    rs.getString("nome_aluguel"),
                    rs.getString("documento_aluguel"),
                    rs.getDouble("valor_aluguel"),
                    rs.getDouble("valoradicional_aluguel"),
                    rs.getDate("data_contrato").toLocalDate(),
                    rs.getString("telefone_aluguel")
                );
        } catch (Exception e) {
            System.out.println(e);
        }
        return aluguel;
    }

    public boolean apagar(int id) {
        try {
            String sql = "DELETE FROM aluguel WHERE idAluguel = " + id;
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao apagar registro do banco de dados: " + e.getMessage());
            return false;
        }
    }
}
