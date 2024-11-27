/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Cliente;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IClienteCRUD {

    public ArrayList<Cliente> obterListaDeCliente() throws Exception;

    public void incluir(Cliente objCliente) throws Exception;

    public void alterar(Cliente objCliente) throws Exception;

    public void remover(int idCliente) throws Exception;
}
