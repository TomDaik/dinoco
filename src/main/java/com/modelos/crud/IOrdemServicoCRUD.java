/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.OrdemServico;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IOrdemServicoCRUD {

    public ArrayList<OrdemServico> obterListaDeOrdemServico() throws Exception;

    public void incluir(OrdemServico objOrdemServico) throws Exception;

    public void alterar(OrdemServico objOrdemServico) throws Exception;

    public void remover(int numeroOS) throws Exception;
}
