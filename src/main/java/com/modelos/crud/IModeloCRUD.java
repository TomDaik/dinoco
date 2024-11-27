/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Modelo;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IModeloCRUD {
    
    public ArrayList<Modelo> obterListaDeModelo() throws Exception;

    public void incluir(Modelo objModelo) throws Exception;

    public void alterar(Modelo objModelo) throws Exception;

    public void remover(int idModelo) throws Exception;
}
