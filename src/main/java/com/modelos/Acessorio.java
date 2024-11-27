/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

/**
 *
 * @author pedro
 */
public class Acessorio {

    private int idAcessorio = 0;
    private String descricao = "";
    private String placaFK = "";

    public Acessorio() {
    }

    public Acessorio(int idAcessorio, String descricao, String placaFK) {
        this.idAcessorio = idAcessorio;
        this.descricao = descricao;
        this.placaFK = placaFK;
    }

    public int getIdAcessorio() {
        return idAcessorio;
    }

    public void setIdAcessorio(int idAcessorio) {
        this.idAcessorio = idAcessorio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlacaFK() {
        return placaFK;
    }

    public void setPlacaFK(String placaFK) {
        this.placaFK = placaFK;
    }

}
