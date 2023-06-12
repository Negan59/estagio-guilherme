package com.sgpd.dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import com.sgpd.model.Pastoral;
import com.sgpd.model.SingletonConexao;

public class DAOPastoral {
    public boolean salvar(Pastoral p) {
        String sql = "insert into pastoral (nome_pastoral, descricao_pastoral,Coordenador_idPessoa,datacriacao_pastoral,dataencerramento_pastoral) values ('$1','$2',$3,'$4','$5')";
        sql = sql.replace("$1", p.getNomepastoral());
        sql = sql.replace("$2", p.getDescricaopastoral());
        sql = sql.replace("$3", ""+p.getCoordenador().getId());
        sql = sql.replace("$4", ""+p.getDatacriacao());
        sql = sql.replace("$5", ""+p.getDataencerramento());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean alterar(Pastoral p){
        String sql = "update pastoral set nome_pastoral=$1,descricao_pastoral='$2',Coordenador_idPessoa=$3,datacriacao_pastoral='$4',dataencerramento_pastoral='$5' where idPastoral = "+p.getId();
        sql = sql.replace("$1", p.getNomepastoral());
        sql = sql.replace("$2", p.getDescricaopastoral());
        sql = sql.replace("$3", ""+p.getCoordenador().getId());
        sql = sql.replace("$4", ""+p.getDatacriacao());
        sql = sql.replace("$5", ""+p.getDataencerramento());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean apagar(int id){
        String sql = "update pastoral set dataencerramento_pastoral = '$1' where idPastoral = "+id;
        sql = sql.replace("$1", ""+LocalDate.now());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean ativar(int id){
        String sql = "update pastoral set dataencerramento_pastoral = '$1' where idPastoral = "+id;
        sql = sql.replace("$1", null);
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public Pastoral buscarUm(int id){
        Pastoral novo = null;
        String sql = "select * from pastoral where idPastoral = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            if (rs.next())
                novo = new Pastoral(rs.getInt("idPastoral"), rs.getString("nome_pastoral"), rs.getString("descricao_pastoral"),new DAOParoquiano().buscarUm(rs.getInt("Coordenador_idPessoa")),rs.getDate("datacriacao_pastoral").toLocalDate(),rs.getDate("dataencerramento_pastoral").toLocalDate());
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

    public ArrayList<Pastoral>buscarAtivas(){
        ArrayList<Pastoral> Lista = new ArrayList<>();
        String sql = "select * from pastoral where dataencerramento_pastoral = NULL";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                    new Pastoral(rs.getInt("idPastoral"), rs.getString("nome_pastoral"), rs.getString("descricao_pastoral"),new DAOParoquiano().buscarUm(rs.getInt("Coordenador_idPessoa")),rs.getDate("datacriacao_pastoral").toLocalDate(),rs.getDate("dataencerramento_pastoral").toLocalDate()));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public ArrayList<Pastoral>buscarInativas(){
        ArrayList<Pastoral> Lista = new ArrayList<>();
        String sql = "select * from pastoral where dataencerramento_pastoral != NULL";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                    new Pastoral(rs.getInt("idPastoral"), rs.getString("nome_pastoral"), rs.getString("descricao_pastoral"),new DAOParoquiano().buscarUm(rs.getInt("Coordenador_idPessoa")),rs.getDate("datacriacao_pastoral").toLocalDate(),rs.getDate("dataencerramento_pastoral").toLocalDate()));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    
}
