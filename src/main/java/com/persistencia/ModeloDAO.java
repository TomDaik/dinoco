/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Modelo;
import com.modelos.crud.IModeloCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class ModeloDAO implements IModeloCRUD {

    private Connection conexao = null;

    public ModeloDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Modelo> obterListaDeModelo() throws Exception {
        ArrayList<Modelo> listaDeModelo = new ArrayList<>();
        String sql = "select * from modelo order by idmodelo";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Modelo objModelo = new Modelo();
                objModelo.setIdModelo(rs.getInt("idmodelo"));
                objModelo.setDescricao(rs.getString("descricao"));
                objModelo.setIdMarca(rs.getInt("idmarca"));
                listaDeModelo.add(objModelo);
            }
            return listaDeModelo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Modelo objModelo) throws Exception {
        try {
            String sql = "insert into modelo (descricao, idmarca)"
                    + "values(?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objModelo.getDescricao());
            preparedStatement.setInt(2, objModelo.getIdMarca());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Modelo objModelo) throws Exception {
         try {
            String sql = "update modelo set descricao = ?, idmarca = ? "
                    + "where idmodelo = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objModelo.getDescricao());
            preparedStatement.setInt(2, objModelo.getIdMarca());
            preparedStatement.setInt(3, objModelo.getIdModelo());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idModelo) throws Exception {
        String sql = "DELETE FROM modelo WHERE idmodelo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idModelo);
            stmt.executeUpdate();
        }
    }
}
