package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.SingletonConexao;
import com.sgpd.model.ItensSalaoParoquial;

public class DAOItensSalaoParoquial {
    public boolean salvar(ItensSalaoParoquial u) {
        try {
            System.out.println("chega aqui?");
            String sql = "insert into itemsalao (nome_itemsalao) values ('$1')";
            sql = sql.replace("$1", u.getNome());
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(ItensSalaoParoquial p){
        String sql = "update itemsalao set nome_itemsalao='$1' where idItemSalao = "+p.getId();
        sql = sql.replace("$1", p.getNome());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean desativar(int id){
        String sql = "update itemsalao set status = 0 where idItemSalao = "+id;
        System.out.println(sql);
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean ativar(int id){
        String sql = "update itemsalao set status = 1 where idItemSalao = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public ArrayList<ItensSalaoParoquial> buscarTodos() {
        ArrayList<ItensSalaoParoquial> Lista = new ArrayList<>();
        String sql = "SELECT * FROM itemsalao where status = 1;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new ItensSalaoParoquial(rs.getInt("idItemSalao"),rs.getString("nome_itemsalao")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public ArrayList<ItensSalaoParoquial> buscarTodosInativos() {
        ArrayList<ItensSalaoParoquial> Lista = new ArrayList<>();
        String sql = "SELECT * FROM itemsalao where status = 0;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new ItensSalaoParoquial(rs.getInt("idItemSalao"),rs.getString("nome_itemsalao")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public ItensSalaoParoquial buscarUm(int id){
        ItensSalaoParoquial novo = null;
        String sql = "SELECT * FROM itemsalao where idItemSalao = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new ItensSalaoParoquial(rs.getInt("idItemSalao"), rs.getString("nome_itemsalao"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }
}
