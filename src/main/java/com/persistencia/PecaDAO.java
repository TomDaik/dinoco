/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Peca;
import com.modelos.crud.IPecaCRUD;
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
public class PecaDAO implements IPecaCRUD {

    private Connection conexao = null;

    public PecaDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Peca> obterListaDePeca() throws Exception {
        ArrayList<Peca> listaDePeca = new ArrayList<>();
        String sql = "select * from peca order by idpeca";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Peca objPeca = new Peca();
                objPeca.setIdPeca(rs.getInt("idpeca"));
                objPeca.setDescricao(rs.getString("descricao"));
                objPeca.setCodigoPeca(rs.getString("codigopeca"));
                objPeca.setQuantidade(rs.getInt("quantidade"));
                objPeca.setPrecoUnitario(rs.getDouble("precounitario"));
                listaDePeca.add(objPeca);
            }
            return listaDePeca;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Peca objPeca) throws Exception {
        try {
            String sql = "insert into peca (descricao, codigopeca, quantidade, "
                    + "precounitario)"
                    + "values(?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objPeca.getDescricao());
            preparedStatement.setString(2, objPeca.getCodigoPeca());
            preparedStatement.setInt(3, objPeca.getQuantidade());
            preparedStatement.setDouble(4, objPeca.getPrecoUnitario());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Peca objPeca) throws Exception {
        try {
            String sql = "update peca set descricao = ?, codigopeca = ?, "
                    + "quantidade = ?, precounitario = ? "
                    + "where idpeca = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objPeca.getDescricao());
            preparedStatement.setString(2, objPeca.getCodigoPeca());
            preparedStatement.setInt(3, objPeca.getQuantidade());
            preparedStatement.setDouble(4, objPeca.getPrecoUnitario());
            preparedStatement.setInt(5, objPeca.getIdPeca());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idPeca) throws Exception {
        String sql = "DELETE FROM peca WHERE idpeca = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPeca);
            stmt.executeUpdate();
        }
    }

}
