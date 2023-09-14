package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sgpd.model.Evento;
import com.sgpd.model.SingletonConexao;

public class DAOEvento {
    public boolean salvar(Evento u) {
        try {
            String sql = "insert into evento (nome_evento, data_evento, horainicio_evento," +
                    "horafim_evento,horainicio_arrumacao,horafim_arrumacao,data_arrumacao,telefone_evento," +
                    "observacao_evento,foto) values ('$1', '$2', '$3', '$4','$5','$6','$7','$8','$9','$A')";
            sql = sql.replace("$1", u.getNomeevento());
            sql = sql.replace("$2", "" + u.getDataevento());
            sql = sql.replace("$3", u.getHorainicio());
            sql = sql.replace("$4", u.getHorafim());
            sql = sql.replace("$5", u.getHorainiarrumacao());
            sql = sql.replace("$6", u.getHorafimarrumacao());
            sql = sql.replace("$7", "" + u.getDataarrumacao());
            sql = sql.replace("$8", u.getTelefone());
            sql = sql.replace("$9", u.getObservacao());
            sql = sql.replace("$A", u.getFoto());
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            return flag;
        } catch (Exception e) {
            // Aqui você pode tratar a exceção capturada
            System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        try {
            String sql = "DELETE FROM evento WHERE idEvento = " + id;
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao excluir evento no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public List<Evento> buscarTodos() {
        try {
            String sql = "SELECT * FROM evento";
            SingletonConexao con = SingletonConexao.getConexao();
            ResultSet rs = con.consultar(sql);

            List<Evento> eventos = new ArrayList<>();

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNomeevento(rs.getString("nome_evento"));
                evento.setDataevento(rs.getDate("data_evento").toLocalDate());
                evento.setHorainicio(rs.getString("horainicio_evento"));
                evento.setHorafim(rs.getString("horafim_evento"));
                evento.setHorainiarrumacao(rs.getString("horainicio_arrumacao"));
                evento.setHorafimarrumacao(rs.getString("horafim_arrumacao"));
                evento.setDataarrumacao(rs.getDate("data_arrumacao").toLocalDate());
                evento.setTelefone(rs.getString("telefone_evento"));
                evento.setObservacao(rs.getString("observacao_evento"));
                evento.setFoto(rs.getString("foto"));
                eventos.add(evento);
            }

            return eventos;
        } catch (Exception e) {
            System.out.println("Erro ao buscar eventos no banco de dados: " + e.getMessage());
            return null;
        }
    }

}
