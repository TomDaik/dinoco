/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

/**
 *
 * @author pedro
 */
public class Servico {
    private int idServico = 0;
    private String descricao = "";
    private double precoUnitario = 0;

    public Servico() {
    }

    public Servico(int idServico, String descricao, double precoUnitario){
        this.idServico = idServico;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
    }
    
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    
}
