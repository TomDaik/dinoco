/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.ItensPeca;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IItensPecaCRUD {

    public ArrayList<ItensPeca> obterListaDeItensPeca() throws Exception;

    public void incluir(ItensPeca objItensPeca) throws Exception;

    public void alterar(ItensPeca objItensPeca) throws Exception;

    public void remover(int idItensPeca) throws Exception;
}
