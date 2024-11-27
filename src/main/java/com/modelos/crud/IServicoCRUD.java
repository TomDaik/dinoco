/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Servico;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IServicoCRUD {

    public ArrayList<Servico> obterListaDeServico() throws Exception;

    public void incluir(Servico objServico) throws Exception;

    public void alterar(Servico objServico) throws Exception;

    public void remover(int idServico) throws Exception;
}
