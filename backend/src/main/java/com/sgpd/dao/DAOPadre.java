package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.Padre;
import com.sgpd.model.SingletonConexao;

public class DAOPadre {
    public boolean salvar(Padre u) {
        try {
            System.out.println("chega aqui?");
            String sql = "insert into Pessoa (nome, foto, telefone, email) values ('$1', '$2', '$3', '$4')";
            sql = sql.replace("$1", u.getNome());
            sql = sql.replace("$2", u.getFoto());
            sql = sql.replace("$3", u.getTelefone());
            sql = sql.replace("$4", u.getEmail());
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            
            if (flag) {
                Padre p = buscarEmail(u.getEmail());
                sql = "insert into padre (paroquia, Pessoa_idPessoa) values ('$1', $2)";
                sql = sql.replace("$1", u.getParoquia());
                sql = sql.replace("$2", "" + p.getId());
                con = SingletonConexao.getConexao();
                flag = con.manipular(sql);
            }
            
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public Padre buscarEmail(String email){
        Padre novo = null;
        String sql = "select * from pessoa where email LIKE " + "'" + email + "'";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Padre(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),rs.getString("telefone"),rs.getString("email"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

    public boolean alterar(Padre p){
        String sql = "update pessoa set nome='$1',foto='$2',telefone='$3', email='$4' where idPessoa = "+p.getId();
        sql = sql.replace("$1", p.getNome());
        sql = sql.replace("$2", p.getFoto());
        sql = sql.replace("$3", p.getTelefone());
        sql = sql.replace("$4", p.getEmail());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        if(flag){
            sql = "update padre set senha='$1' where Pessoa_idPessoa = "+p.getId();
            sql = sql.replace("$1", p.getParoquia());
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

    public boolean desativar(int id){
        String sql = "update padre set padre_status = 0 where Pessoa_idPessoa = "+id;
        System.out.println(sql);
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean ativar(int id){
        String sql = "update padre set padre_status = 1 where Pessoa_idPessoa = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public ArrayList<Padre> buscarTodos() {
        ArrayList<Padre> Lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa PE inner join padre F where PE.idPessoa = F.Pessoa_idPessoa and F.padre_status = 1;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Padre(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),
                                rs.getString("telefone"), rs.getString("email"), rs.getString("paroquia"),rs.getBoolean("padre_status")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public ArrayList<Padre> buscarTodosInativos() {
        ArrayList<Padre> Lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa PE inner join padre F where PE.idPessoa = F.Pessoa_idPessoa and F.padre_status = 0;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Padre(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),
                                rs.getString("telefone"), rs.getString("email"), rs.getString("paroquia"),rs.getBoolean("padre_status")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public Padre buscarUm(int id){
        Padre novo = null;
        String sql = "SELECT * FROM pessoa PE inner join padre F where PE.idPessoa = F.Pessoa_idPessoa AND PE.idPessoa = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Padre(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),rs.getString("telefone"),rs.getString("email"),rs.getString("paroquia"),rs.getBoolean("padre_status"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }
}
