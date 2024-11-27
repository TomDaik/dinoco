/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Acessorio;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IAcessorioCRUD {

    public ArrayList<Acessorio> obterListaDeAcessorio() throws Exception;

    public void incluir(Acessorio objAcessorio) throws Exception;

    public void alterar(Acessorio objAcessorio) throws Exception;

    public void remover(int idAcessorio) throws Exception;
}
