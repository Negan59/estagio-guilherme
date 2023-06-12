package com.sgpd.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluguel {
    private int id;
    private String nomealuguel;
    private String documento;
    private double valor;
    private double valoradicional;
    private LocalDate data;
    private String telefone;

    public Aluguel(String nomealuguel, String documento, double valor, double valoradicional, LocalDate data,
            String telefone) {
        this.nomealuguel = nomealuguel;
        this.documento = documento;
        this.valor = valor;
        this.valoradicional = valoradicional;
        this.data = data;
        this.telefone = telefone;
    }

    public Aluguel(int id, String nomealuguel, String documento, double valor, double valoradicional, LocalDate data,
            String telefone) {
        this.id = id;
        this.nomealuguel = nomealuguel;
        this.documento = documento;
        this.valor = valor;
        this.valoradicional = valoradicional;
        this.data = data;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomealuguel() {
        return nomealuguel;
    }

    public void setNomealuguel(String nomealuguel) {
        this.nomealuguel = nomealuguel;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValoradicional() {
        return valoradicional;
    }

    public void setValoradicional(double valoradicional) {
        this.valoradicional = valoradicional;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean salvar() {
        return false;
    }

    public boolean alterar() {
        return false;
    }

    public ArrayList<Aluguel> buscarTodos() {
        return null;
    }

    public boolean apagar(int id) {
        return false;
    }

    public Aluguel buscarUm(int id) {
        return null;
    }

}
