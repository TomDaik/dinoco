/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Propriedade;
import com.modelos.crud.IPropriedadeCRUD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class PropriedadeDAO implements IPropriedadeCRUD {

    private Connection conexao = null;

    public PropriedadeDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Propriedade> obterListaDePropriedade() throws Exception {
        ArrayList<Propriedade> listaDePropriedade = new ArrayList<>();
        String sql = "select * from propriedade order by idpropriedade";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Propriedade objPropriedade = new Propriedade();
                objPropriedade.setIdPropriedade(rs.getInt("idpropriedade"));
                objPropriedade.setDataInicio(rs.getDate("datainicio"));
                objPropriedade.setDataFim(rs.getDate("datafim"));
                objPropriedade.setIdVeiculo(rs.getInt("idveiculo"));
                objPropriedade.setIdCliente(rs.getInt("idcliente"));
                listaDePropriedade.add(objPropriedade);
            }
            return listaDePropriedade;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Propriedade objPropriedade) throws Exception {
        try {
            String sql = "insert into propriedade (datainicio, datafim, idveiculo,"
                    + "idcliente)"
                    + "values(?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setDate(1, (Date) objPropriedade.getDataInicio());
            preparedStatement.setDate(2, (Date) objPropriedade.getDataFim());
            preparedStatement.setInt(3, objPropriedade.getIdVeiculo());
            preparedStatement.setInt(4, objPropriedade.getIdCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Propriedade objPropriedade) throws Exception {
        try {
            String sql = "update propriedade set datainicio = ?, datafim = ?, "
                    + "idveiculo = ?, idcliente = ?"
                    + "where idpropriedade = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setDate(1, (Date) objPropriedade.getDataInicio());
            preparedStatement.setDate(2, (Date) objPropriedade.getDataFim());
            preparedStatement.setInt(3, objPropriedade.getIdVeiculo());
            preparedStatement.setInt(4, objPropriedade.getIdCliente());
            preparedStatement.setInt(5, objPropriedade.getIdPropriedade());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idPropriedade) throws Exception {
        String sql = "DELETE FROM propriedade WHERE idpropriedade = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPropriedade);
            stmt.executeUpdate();
        }
    }
}
