package com.sgpd.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {
    private int id;
    private String nomeevento;
    private LocalDate dataevento;
    private String horainicio;
    private String horafim;
    private String horainiarrumacao;
    private String horafimarrumacao;
    private LocalDate dataarrumacao;
    private String telefone;
    private String observacao;
    private Aluguel aluguel;

    public Evento(String nomeevento, LocalDate dataevento, String horainicio, String horafim, String horainiarrumacao,
            String horafimarrumacao, LocalDate dataarrumacao, String telefone, String observacao) {
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public Evento(String nomeevento, LocalDate dataevento, String horainicio, String horafim, String horainiarrumacao,
            String horafimarrumacao, LocalDate dataarrumacao, String telefone, String observacao, Aluguel aluguel) {
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
        this.aluguel = aluguel;
    }

    public Evento(int id, String nomeevento, LocalDate dataevento, String horainicio, String horafim,
            String horainiarrumacao, String horafimarrumacao, LocalDate dataarrumacao, String telefone,
            String observacao, Aluguel aluguel) {
        this.id = id;
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
        this.aluguel = aluguel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeevento() {
        return nomeevento;
    }

    public void setNomeevento(String nomeevento) {
        this.nomeevento = nomeevento;
    }

    public LocalDate getDataevento() {
        return dataevento;
    }

    public void setDataevento(LocalDate dataevento) {
        this.dataevento = dataevento;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafim() {
        return horafim;
    }

    public void setHorafim(String horafim) {
        this.horafim = horafim;
    }

    public String getHorainiarrumacao() {
        return horainiarrumacao;
    }

    public void setHorainiarrumacao(String horainiarrumacao) {
        this.horainiarrumacao = horainiarrumacao;
    }

    public String getHorafimarrumacao() {
        return horafimarrumacao;
    }

    public void setHorafimarrumacao(String horafimarrumacao) {
        this.horafimarrumacao = horafimarrumacao;
    }

    public LocalDate getDataarrumacao() {
        return dataarrumacao;
    }

    public void setDataarrumacao(LocalDate dataarrumacao) {
        this.dataarrumacao = dataarrumacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public boolean salvar() {
        return false;
    }

    public boolean alterar() {
        return false;
    }

    public ArrayList<Evento> buscarTodos() {
        return null;
    }

    public boolean apagar(int id) {
        return false;
    }

    public Evento buscarUm(int id) {
        return null;
    }

}
