/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

/**
 *
 * @author pedro
 */
public class Modelo {

    private int idModelo = 0;
    private String descricao = "";
    private int idMarca = 0;

    public Modelo() {
    }

    public Modelo(int idModelo, String descricao, int idMarca) {
        this.idMarca = idModelo;
        this.descricao = descricao;
        this.idModelo = idMarca;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public String toString() {
        return idModelo + "-" + descricao + "-" + idMarca;
    }
}
