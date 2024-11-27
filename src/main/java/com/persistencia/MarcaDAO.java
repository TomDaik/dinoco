/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Marca;
import com.modelos.crud.IMarcaCRUD;
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
public class MarcaDAO implements IMarcaCRUD {

    private Connection conexao = null;

    public MarcaDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Marca> obterListaDeMarca() throws Exception {
        ArrayList<Marca> listaDeMarca = new ArrayList<>();
        String sql = "select * from marca order by idmarca";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Marca objMarca = new Marca();
                objMarca.setIdMarca(rs.getInt("idmarca"));
                objMarca.setDescricao(rs.getString("descricao"));
                listaDeMarca.add(objMarca);
            }
            return listaDeMarca;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Marca objMarca) throws Exception {
        try {
            String sql = "insert into marca (descricao)"
                    + "values(?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objMarca.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Marca objMarca) throws Exception {
        try {
            String sql = "update marca set descricao = ? "
                    + "where idmarca = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objMarca.getDescricao());
            preparedStatement.setInt(2, objMarca.getIdMarca());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idMarca) throws Exception {
        String sql = "DELETE FROM marca WHERE idmarca = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idMarca);
            stmt.executeUpdate();
        }
    }

}
