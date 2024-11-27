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
public class Propriedade {

    private int idPropriedade = 0;
    private Date dataInicio;
    private Date dataFim;
    private String placaFK = "";
    private int idCliente = 0;

    public Propriedade() {
    }

    public Propriedade(int idPropriedade, Date dataInicio, Date dataFim,
            String placaFK, int idCliente) {
        this.idPropriedade = idPropriedade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.placaFK = placaFK;
        this.idCliente = idCliente;
    }

    public int getIdPropriedade() {
        return idPropriedade;
    }

    public void setIdPropriedade(int idPropriedade) {
        this.idPropriedade = idPropriedade;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getPlacaFK() {
        return placaFK;
    }

    public void setPlacaFK(String placaFK) {
        this.placaFK = placaFK;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
