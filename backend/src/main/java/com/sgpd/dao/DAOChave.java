package com.sgpd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sgpd.model.Chave;
import com.sgpd.model.Sala;
import com.sgpd.model.SingletonConexao;

public class DAOChave {
    public boolean salvar(Chave chave) {
        String sql = "INSERT INTO chave (nome_chave, Sala_idSala) VALUES ('" + chave.getNome() + "', " + chave.getSala().getId() + ")";
        SingletonConexao con = SingletonConexao.getConexao();
        System.out.println(sql);
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean alterar(Chave chave) {
        String sql = "UPDATE chave SET nome_chave='" + chave.getNome() + "', Sala_idSala=" + chave.getSala().getId() + " WHERE idChave=" + chave.getId();
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean apagar(int idChave) {
        String sql = "DELETE FROM chave WHERE idChave=" + idChave;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public Chave buscarUm(int idChave) {
        Chave novaChave = null;
        String sql = "SELECT * FROM chave WHERE idChave=" + idChave;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            if (rs.next()) {
                int idSala = rs.getInt("Sala_idSala");
                DAOSala dao = new DAOSala();
                Sala sala = dao.buscarUm(idSala); // Supondo que você tenha um método para buscar uma Sala pelo ID
                novaChave = new Chave(rs.getInt("idChave"), rs.getString("nome_chave"), sala);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return novaChave;
    }

    public ArrayList<Chave> buscarTodos() {
        ArrayList<Chave> listaChaves = new ArrayList<>();
        String sql = "SELECT * FROM chave";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next()) {
                int idSala = rs.getInt("Sala_idSala");
                DAOSala dao = new DAOSala();
                Sala sala = dao.buscarUm(idSala); // Supondo que você tenha um método para buscar uma Sala pelo ID
                listaChaves.add(new Chave(rs.getInt("idChave"), rs.getString("nome_chave"), sala));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaChaves;
    }
}
