package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.Paroquiano;
import com.sgpd.model.SingletonConexao;



public class DAOParoquiano {
    public boolean salvar(Paroquiano u) {
        System.out.println("chega aqui?");
        String sql = "insert into Pessoa (nome, foto, telefone,email) values ('$1','$2','$3','$4')";
        sql = sql.replace("$1", u.getNome());
        sql = sql.replace("$2", u.getFoto());
        sql = sql.replace("$3", u.getTelefone());
        sql = sql.replace("$4", u.getEmail());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        if(flag){
            Paroquiano p = buscarEmail(u.getEmail());
            sql = "insert into paroquiano (senha,Pessoa_idPessoa) values ('$1',$2)";
            sql = sql.replace("$1", u.getSenha());
            sql = sql.replace("$2", ""+p.getId());
            con = SingletonConexao.getConexao();
            flag = con.manipular(sql);
        }
        return flag;
    }

    public Paroquiano buscarEmail(String email){
        Paroquiano novo = null;
        String sql = "select * from pessoa where email LIKE " + "'" + email + "'";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Paroquiano(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),rs.getString("telefone"),rs.getString("email"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

    public boolean alterar(Paroquiano p){
        String sql = "update pessoa set nome='$1',foto='$2',telefone='$3', email='$4' where idPessoa = "+p.getId();
        sql = sql.replace("$1", p.getNome());
        sql = sql.replace("$2", p.getFoto());
        sql = sql.replace("$3", p.getTelefone());
        sql = sql.replace("$4", p.getEmail());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        if(flag){
            sql = "update paroquiano set senha-'$1' where Pessoa_idPessoa = "+p.getId();
            sql = sql.replace("$1", p.getSenha());
            con = SingletonConexao.getConexao();
            flag = con.manipular(sql);
        }
        return flag;
    }

    public boolean apagar(int id){
        String sql = "delete from paroquiano where Pessoa_idPessoa = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        if(flag){
            sql = "delete from pessoa where idPessoa = "+id;
            con = SingletonConexao.getConexao();
            flag = con.manipular(sql);
        }
        return flag;

    }

    public ArrayList<Paroquiano> buscarTodos(String filtro) {
        ArrayList<Paroquiano> Lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa PE inner join paroquiano PA where PE.idPessoa = PA.Pessoa_idPessoa;";
        if (!filtro.isEmpty()) {
            sql = "SELECT * FROM pessoa PE inner join paroquiano PA where PE.idPessoa = PA.Pessoa_idPessoa and upper(nome) LIKE " + "'%" + filtro.toUpperCase() + "%'";
        }
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Paroquiano(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),
                                rs.getString("telefone"), rs.getString("email"), rs.getString("senha")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public Paroquiano buscarUm(int id){
        Paroquiano novo = null;
        String sql = "SELECT * FROM pessoa PE inner join paroquiano PA where PE.idPessoa = PA.Pessoa_idPessoa AND PE.idPessoa = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Paroquiano(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),rs.getString("telefone"),rs.getString("email"),rs.getString("senha"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

    

}
