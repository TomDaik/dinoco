/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

/**
 *
 * @author pedro
 */
public class ItensServico {

    private int idItensServico = 0;
    private int quantidade = 0;
    private double precoUnitario = 0;
    private double precoFinal = 0;
    private int idFuncionario = 0;
    private int idServico = 0;
    private int numeroOSFK = 0;

    public ItensServico() {
    }

    public ItensServico(int idItensServico, int quantidade, double precoUnitario,
            double precoFinal, int idFuncionario, int idServico, int numeroOSFK) {
        this.idItensServico = idItensServico;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoFinal = precoFinal;
        this.idFuncionario = idFuncionario;
        this.idServico = idServico;
        this.numeroOSFK = numeroOSFK;
    }

    public int getIdItensServico() {
        return idItensServico;
    }

    public void setIdItensServico(int idItensServico) {
        this.idItensServico = idItensServico;
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

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getNumeroOSFK() {
        return numeroOSFK;
    }

    public void setNumeroOSFK(int numeroOSFK) {
        this.numeroOSFK = numeroOSFK;
    }

}
