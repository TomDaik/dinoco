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
public class Veiculo {

    private int idVeiculo = 0;
    private String placa = "";
    private String chassi = "";
    private int kilometragem = 0;
    private String nPatrimonio = "";
    private String ano;
    private int idAcessorio = 0;
    private int idModelo = 0;

    public Veiculo() {
    }

    public Veiculo(int idVeiculo, String placa, String chassi, int kilometragem,
            String nPatrimonio, String ano, int idAcessorio, int idModelo) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.chassi = chassi;
        this.kilometragem = kilometragem;
        this.nPatrimonio = nPatrimonio;
        this.ano = ano;
        this.idAcessorio = idAcessorio;
        this.idModelo = idModelo;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String getnPatrimonio() {
        return nPatrimonio;
    }

    public void setnPatrimonio(String nPatrimonio) {
        this.nPatrimonio = nPatrimonio;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getIdAcessorio() {
        return idAcessorio;
    }

    public void setIdAcessorio(int idAcessorio) {
        this.idAcessorio = idAcessorio;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

}
