/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.PessoaJuridica;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IPessoaJuridicaCRUD {

    public ArrayList<PessoaJuridica> obterListaDePessoaJuridica() throws Exception;

    public void incluir(PessoaJuridica objPessoaJuridica) throws Exception;

    public void alterar(PessoaJuridica objPessoaJuridica) throws Exception;

    public void remover(int cnpj) throws Exception;
}
