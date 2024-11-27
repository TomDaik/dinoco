/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IVeiculoCRUD {

    public ArrayList<Veiculo> obterListaDeVeiculo() throws Exception;

    public void incluir(Veiculo objVeiculo) throws Exception;

    public void alterar(Veiculo objVeiculo) throws Exception;

    public void remover(int idVeiculo) throws Exception;
}
