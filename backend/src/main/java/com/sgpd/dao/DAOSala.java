package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.Sala;
import com.sgpd.model.SingletonConexao;

public class DAOSala {
    public boolean salvar(Sala s) {
        String sql = "insert into sala (numero_sala, descricao_sala) values ($1,'$2')";
        sql = sql.replace("$1", ""+s.getNumerosala());
        sql = sql.replace("$2", s.getDescricaosala());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean alterar(Sala s){
        String sql = "update sala set numero_sala=$1,descricao_sala='$2' where idSala = "+s.getId();
        sql = sql.replace("$1", ""+s.getNumerosala());
        sql = sql.replace("$2", s.getDescricaosala());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean apagar(int id){
        String sql = "delete from sala where idSala = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public Sala buscarUm(int id){
        Sala novo = null;
        String sql = "select * from sala where idSala = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            if (rs.next())
                novo = new Sala(rs.getInt("idSala"), rs.getInt("numero_sala"), rs.getString("descricao_sala"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

    public ArrayList<Sala>buscarTodos(){
        ArrayList<Sala> Lista = new ArrayList<>();
        String sql = "select * from sala order by numero_sala ASC";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Sala(rs.getInt("idSala"), rs.getInt("numero_sala"), rs.getString("descricao_sala")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }
}
