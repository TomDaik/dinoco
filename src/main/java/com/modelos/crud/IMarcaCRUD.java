/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Marca;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IMarcaCRUD {
    
    public ArrayList<Marca> obterListaDeMarca() throws Exception;

    public void incluir(Marca objMarca) throws Exception;

    public void alterar(Marca objMarca) throws Exception;

    public void remover(int idMarca) throws Exception;
}
