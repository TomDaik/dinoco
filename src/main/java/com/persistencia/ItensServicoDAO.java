/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.ItensServico;
import com.modelos.crud.IItensServicoCRUD;
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
public class ItensServicoDAO implements IItensServicoCRUD {

    private Connection conexao = null;

    public ItensServicoDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<ItensServico> obterListaDeItensServico() throws Exception {
        ArrayList<ItensServico> listaDeItensServico = new ArrayList<>();
        String sql = "select * from itenspeca order by iditenspeca";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ItensServico objItensServico = new ItensServico();
                objItensServico.setIdItensServico(rs.getInt("iditensservico"));
                objItensServico.setQuantidade(rs.getInt("quantidade"));
                objItensServico.setPrecoUnitario(rs.getDouble("precounitario"));
                objItensServico.setPrecoFinal(rs.getDouble("precofinal"));
                objItensServico.setIdFuncionario(rs.getInt("idfuncionario"));
                objItensServico.setIdServico(rs.getInt("idservico"));
                objItensServico.setNumeroOSFK(rs.getInt("numeroosfk"));
                listaDeItensServico.add(objItensServico);
            }
            return listaDeItensServico;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(ItensServico objItensServico) throws Exception {
        try {
            String sql = "insert into itensservico(quantidade, precounitario, "
                    + "precofinal, idfuncionario, idservico, numeroosfk)"
                    + "values(?,?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, objItensServico.getQuantidade());
            preparedStatement.setDouble(2, objItensServico.getPrecoUnitario());
            preparedStatement.setDouble(3, objItensServico.getPrecoFinal());
            preparedStatement.setInt(4, objItensServico.getIdFuncionario());
            preparedStatement.setInt(5, objItensServico.getIdServico());
            preparedStatement.setInt(6, objItensServico.getNumeroOSFK());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(ItensServico objItensServico) throws Exception {
        try {
            String sql = "update itensservico set quantidade = ?,"
                    + "precounitario = ?, precofinal = ?, idfuncionario = ?,"
                    + "idservico = ? , numeroosfk = ?"
                    + "where iditensservico = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, objItensServico.getQuantidade());
            preparedStatement.setDouble(2, objItensServico.getPrecoUnitario());
            preparedStatement.setDouble(3, objItensServico.getPrecoFinal());
            preparedStatement.setInt(4, objItensServico.getIdFuncionario());
            preparedStatement.setInt(5, objItensServico.getIdServico());
            preparedStatement.setInt(6, objItensServico.getNumeroOSFK());
            preparedStatement.setInt(7, objItensServico.getIdItensServico());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Alterar Servicos Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idItensServico) throws Exception {
        String sql = "DELETE FROM itensservico WHERE iditensservico = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idItensServico);
            stmt.executeUpdate();
        }
    }
}
