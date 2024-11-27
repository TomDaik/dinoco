/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

/**
 *
 * @author pedro
 */
public class ItensPeca {

    private int idItensPeca;
    private int quantidade;
    private double precoUnitario;
    private double precoFinal;
    private int idPeca;
    private int numeroOSFK;

    public ItensPeca() {
    }

    public ItensPeca(int idItensPeca, int quantidade, double precoUnitario, double precoFinal, int idPeca, int numeroOSFK) {
        this.idItensPeca = idItensPeca;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoFinal = precoFinal;
        this.idPeca = idPeca;
        this.numeroOSFK = numeroOSFK;
    }

    public int getIdItensPeca() {
        return idItensPeca;
    }

    public void setIdItensPeca(int idItensPeca) {
        this.idItensPeca = idItensPeca;
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

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getNumeroOSFK() {
        return numeroOSFK;
    }

    public void setNumeroOSFK(int numeroOSFK) {
        this.numeroOSFK = numeroOSFK;
    }

}
