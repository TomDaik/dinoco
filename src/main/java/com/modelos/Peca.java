/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

/**
 *
 * @author pedro
 */
public class Peca {

    private int idPeca = 0;
    private String descricao = "";
    private String codigoPeca = "";
    private int quantidade = 0;
    private double precoUnitario = 0;

    public Peca() {
    }

    public Peca(int idPeca, String descricao, String codigoPeca, int quantidade, double precoUnitario) {
        this.idPeca = idPeca;
        this.descricao = descricao;
        this.codigoPeca = codigoPeca;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(String codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
