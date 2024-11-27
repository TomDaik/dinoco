/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.modelos.crud;

import com.modelos.Oficina;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IOficinaCRUD {
    
    public ArrayList<Oficina> obterListaDeOficina() throws Exception;

    public void incluir(Oficina objOficina) throws Exception;

    public void alterar(Oficina objOficina) throws Exception;

    public void remover(int idOficina) throws Exception;
}
