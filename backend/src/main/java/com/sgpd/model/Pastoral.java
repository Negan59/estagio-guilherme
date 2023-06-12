package com.sgpd.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.sgpd.dao.DAOPastoral;

public class Pastoral {
    private int id;
    private String nomepastoral;
    private String descricaopastoral;
    private Paroquiano coordenador;
    private LocalDate datacriacao;
    private LocalDate dataencerramento;

    public Pastoral(String nomepastoral, String descricaopastoral, Paroquiano coordenador, LocalDate datacriacao) {
        this.nomepastoral = nomepastoral;
        this.descricaopastoral = descricaopastoral;
        this.coordenador = coordenador;
        this.datacriacao = datacriacao;
    }

    public Pastoral(String nomepastoral, String descricaopastoral, Paroquiano coordenador, LocalDate datacriacao,
            LocalDate dataencerramento) {
        this.nomepastoral = nomepastoral;
        this.descricaopastoral = descricaopastoral;
        this.coordenador = coordenador;
        this.datacriacao = datacriacao;
        this.dataencerramento = dataencerramento;
    }

    public Pastoral(int id, String nomepastoral, String descricaopastoral, Paroquiano coordenador,
            LocalDate datacriacao, LocalDate dataencerramento) {
        this.id = id;
        this.nomepastoral = nomepastoral;
        this.descricaopastoral = descricaopastoral;
        this.coordenador = coordenador;
        this.datacriacao = datacriacao;
        this.dataencerramento = dataencerramento;
    }

    public Pastoral() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomepastoral() {
        return nomepastoral;
    }

    public void setNomepastoral(String nomepastoral) {
        this.nomepastoral = nomepastoral;
    }

    public String getDescricaopastoral() {
        return descricaopastoral;
    }

    public void setDescricaopastoral(String descricaopastoral) {
        this.descricaopastoral = descricaopastoral;
    }

    public Paroquiano getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Paroquiano coordenador) {
        this.coordenador = coordenador;
    }

    public LocalDate getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDate datacriacao) {
        this.datacriacao = datacriacao;
    }

    public LocalDate getDataencerramento() {
        return dataencerramento;
    }

    public void setDataencerramento(LocalDate dataencerramento) {
        this.dataencerramento = dataencerramento;
    }

    public boolean salvar(){
        DAOPastoral dao = new DAOPastoral();
        if(dao.salvar(this)){
            return true;
        }else{
            return false;
        }

    }

    public boolean alterar(){
        DAOPastoral dao = new DAOPastoral();
        if(dao.alterar(this)){
            return true;
        }else{
            return false;
        }

    }

    public ArrayList<Pastoral> buscarAtivas(){
        return new DAOPastoral().buscarAtivas();

    }

    public ArrayList<Pastoral> buscarInativas(){
        return new DAOPastoral().buscarInativas();

    }

    public boolean desativar(int id){
        DAOPastoral dao = new DAOPastoral();
        if(dao.apagar(id)){
            return true;
        }else{
            return false;
        }

    }

    public boolean ativar(int id){
        DAOPastoral dao = new DAOPastoral();
        if(dao.ativar(id)){
            return true;
        }else{
            return false;
        }
    }

    public Pastoral buscarUm(int id){
        return new DAOPastoral().buscarUm(id);

    }

}
