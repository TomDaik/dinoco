/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

/**
 *
 * @author pedro
 */
public class Funcionario {

    private int idFuncionario = 0;
    private String nome = "";
    private String especialidade = "";

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String nome, String especialidade) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
