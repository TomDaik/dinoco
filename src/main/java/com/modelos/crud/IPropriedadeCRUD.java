/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Propriedade;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IPropriedadeCRUD {

    public ArrayList<Propriedade> obterListaDePropriedade() throws Exception;

    public void incluir(Propriedade objPropriedade) throws Exception;

    public void alterar(Propriedade objPropriedade) throws Exception;

    public void remover(int idPropriedade) throws Exception;
}
