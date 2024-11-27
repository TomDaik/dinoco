/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.PessoaFisica;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IPessoaFisicaCRUD {

    public ArrayList<PessoaFisica> obterListaDePessoaFisica() throws Exception;

    public void incluir(PessoaFisica objPessoaFisica) throws Exception;

    public void alterar(PessoaFisica objPessoaFisica) throws Exception;

    public void remover(int cpf) throws Exception;
}
