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
    private int idVeiculo = 0;
    private int idCliente = 0;

    public Propriedade() {
    }

    public Propriedade(int idPropriedade, Date dataInicio, Date dataFim,
            int idVeiculo, int idCliente) {
        this.idPropriedade = idPropriedade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idVeiculo = idVeiculo;
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

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
