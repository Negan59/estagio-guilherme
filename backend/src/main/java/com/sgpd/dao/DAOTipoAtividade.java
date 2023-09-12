package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.TipoAtividade;
import com.sgpd.model.SingletonConexao;

public class DAOTipoAtividade {
    public boolean salvar(TipoAtividade u) {
        try {
            System.out.println("chega aqui?");
            String sql = "insert into tipoatividade (nomeTipoAtividade) values ('$1')";
            sql = sql.replace("$1", u.getNome());
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(TipoAtividade p){
        String sql = "update tipoatividade set nomeTipoAtividade='$1' where idtipoAtividade = "+p.getId();
        sql = sql.replace("$1", p.getNome());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean desativar(int id){
        String sql = "update tipoatividade set status = 0 where idtipoAtividade = "+id;
        System.out.println(sql);
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean ativar(int id){
        String sql = "update tipoatividade set status = 1 where idtipoAtividade = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public ArrayList<TipoAtividade> buscarTodos() {
        ArrayList<TipoAtividade> Lista = new ArrayList<>();
        String sql = "SELECT * FROM tipoatividade where status = 1;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new TipoAtividade(rs.getInt("idtipoAtividade"),rs.getString("nomeTipoAtividade")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public ArrayList<TipoAtividade> buscarTodosInativos() {
        ArrayList<TipoAtividade> Lista = new ArrayList<>();
        String sql = "SELECT * FROM tipoatividade where status = 0;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new TipoAtividade(rs.getInt("idtipoAtividade"),rs.getString("nomeTipoAtividade")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public TipoAtividade buscarUm(int id){
        TipoAtividade novo = null;
        String sql = "SELECT * FROM tipoatividade where idtipoAtividade = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new TipoAtividade(rs.getInt("idtipoAtividade"), rs.getString("nomeTipoAtividade"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }
}
