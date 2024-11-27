/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Peca;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IPecaCRUD {

    public ArrayList<Peca> obterListaDePeca() throws Exception;

    public void incluir(Peca objPeca) throws Exception;

    public void alterar(Peca objPeca) throws Exception;

    public void remover(int idPeca) throws Exception;
}
