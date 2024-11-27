/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IFuncionarioCRUD {

    public ArrayList<Funcionario> obterListaDeFuncionario() throws Exception;

    public void incluir(Funcionario objFuncionario) throws Exception;

    public void alterar(Funcionario objFuncionario) throws Exception;

    public void remover(int idFuncionario) throws Exception;
}
