/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos;

/**
 *
 * @author pedro
 */
public class Cliente {

    private int idCliente = 0;
    private String nome = "";
    private String ddi1 = "";
    private String ddd1 = "";
    private String numero1 = "";
    private String telefone1 = "";
    private String ddi2 = "";
    private String ddd2 = "";
    private String numero2 = "";
    private String email = "";
    private String logradouro = "";
    private String complemento = "";
    private String bairro = "";
    private String cep = "";
    private String municipio = "";
    private String uf = "";
    private String tipoCliente = "";

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String ddi1, String ddd1,
            String numero1, String telefone1, String ddi2, String ddd2, String numero2,
            String email, String logradouro, String complemento, String bairro,
            String cep, String municipio, String uf, String tipoCliente) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.ddi1 = ddi1;
        this.ddd1 = ddd1;
        this.numero1 = numero1;
        this.telefone1 = telefone1;
        this.ddi2 = ddi2;
        this.ddd2 = ddd2;
        this.numero2 = numero2;
        this.email = email;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.municipio = municipio;
        this.uf = uf;
        this.tipoCliente = tipoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDdi1() {
        return ddi1;
    }

    public void setDdi1(String ddi1) {
        this.ddi1 = ddi1;
    }

    public String getDdd1() {
        return ddd1;
    }

    public void setDdd1(String ddd1) {
        this.ddd1 = ddd1;
    }

    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getDdi2() {
        return ddi2;
    }

    public void setDdi2(String ddi2) {
        this.ddi2 = ddi2;
    }

    public String getDdd2() {
        return ddd2;
    }

    public void setDdd2(String ddd2) {
        this.ddd2 = ddd2;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}
