/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.ItensPeca;
import com.modelos.crud.IItensPecaCRUD;
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
public class ItensPecaDAO implements IItensPecaCRUD {

    private Connection conexao = null;

    public ItensPecaDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<ItensPeca> obterListaDeItensPeca() throws Exception {
        ArrayList<ItensPeca> listaDeItensPeca = new ArrayList<>();
        String sql = "select * from itenspeca order by iditenspeca";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ItensPeca objItensPeca = new ItensPeca();
                objItensPeca.setIdItensPeca(rs.getInt("iditenspeca"));
                objItensPeca.setQuantidade(rs.getInt("quantidade"));
                objItensPeca.setPrecoUnitario(rs.getDouble("precounitario"));
                objItensPeca.setPrecoFinal(rs.getDouble("precofinal"));
                objItensPeca.setIdPeca(rs.getInt("idpeca"));
                objItensPeca.setNumeroOSFK(rs.getInt("numeroosfk"));
                listaDeItensPeca.add(objItensPeca);
            }
            return listaDeItensPeca;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(ItensPeca objItensPeca) throws Exception {
        try {
            String sql = "insert into itenspeca(quantidade, precounitario, "
                    + "precofinal, idpeca, numeroosfk)"
                    + "values(?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, objItensPeca.getQuantidade());
            preparedStatement.setDouble(2, objItensPeca.getPrecoUnitario());
            preparedStatement.setDouble(3, objItensPeca.getPrecoFinal());
            preparedStatement.setInt(4, objItensPeca.getIdPeca());
            preparedStatement.setInt(5, objItensPeca.getNumeroOSFK());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(ItensPeca objItensPeca) throws Exception {
        try {
            String sql = "update itenspeca set quantidade = ?, precounitario = ?,"
                    + " precofinal = ?, idpeca = ?, numeroosfk = ?"
                    + "where iditenspeca = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, objItensPeca.getQuantidade());
            preparedStatement.setDouble(2, objItensPeca.getPrecoUnitario());
            preparedStatement.setDouble(3, objItensPeca.getPrecoFinal());
            preparedStatement.setInt(4, objItensPeca.getIdPeca());
            preparedStatement.setInt(5, objItensPeca.getNumeroOSFK());
            preparedStatement.setInt(6, objItensPeca.getIdItensPeca());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Alterar Servicos Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idItensPeca) throws Exception {
        String sql = "DELETE FROM itenspeca WHERE iditenspeca = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idItensPeca);
            stmt.executeUpdate();
        }
    }

}
