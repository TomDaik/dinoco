/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.ItensServico;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IItensServicoCRUD {

    public ArrayList<ItensServico> obterListaDeItensServico() throws Exception;

    public void incluir(ItensServico objItensServico) throws Exception;

    public void alterar(ItensServico objItensServico) throws Exception;

    public void remover(int idItensServico) throws Exception;
}
