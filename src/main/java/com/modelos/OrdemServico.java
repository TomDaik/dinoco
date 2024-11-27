/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class OrdemServico {

    private int numeroOS = 0;
    private Date inico;
    private Date fim;
    private double totalPago = 0;
    private double precoFinal = 0;
    private String status = "";
    /*Trocar depois para o Tipo status(Criar o Enum)*/
    private String placaFK = "";

    public OrdemServico() {
    }

    public OrdemServico(int numeroOS, Date inicio, Date fim, double totalPago,
            double precoFinal, String status, String placaFK) {
        this.numeroOS = numeroOS;
        this.inico = inicio;
        this.fim = fim;
        this.totalPago = totalPago;
        this.precoFinal = precoFinal;
        this.status = status;
        this.placaFK = placaFK;
    }

    public int getNumeroOS() {
        return numeroOS;
    }

    public void setNumeroOS(int numeroOS) {
        this.numeroOS = numeroOS;
    }

    public Date getInico() {
        return inico;
    }

    public void setInico(Date inico) {
        this.inico = inico;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlacaFK() {
        return placaFK;
    }

    public void setPlacaFK(String placaFK) {
        this.placaFK = placaFK;
    }

}
