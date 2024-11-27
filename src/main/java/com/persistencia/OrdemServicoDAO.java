/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.OrdemServico;
import com.modelos.crud.IOrdemServicoCRUD;
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
public class OrdemServicoDAO implements IOrdemServicoCRUD {

    private Connection conexao = null;

    public OrdemServicoDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<OrdemServico> obterListaDeOrdemServico() throws Exception {
        ArrayList<OrdemServico> listaDeOrdemServico = new ArrayList<>();
        String sql = "select * from ordemservico order by numeroos";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                OrdemServico objOrdemServico = new OrdemServico();
                objOrdemServico.setNumeroOS(rs.getInt("numeroos"));
                objOrdemServico.setInico(rs.getDate("inicio"));
                objOrdemServico.setFim(rs.getDate("fim"));
                objOrdemServico.setTotalPago(rs.getDouble("totalpago"));
                objOrdemServico.setPrecoFinal(rs.getDouble("precofinal"));
                objOrdemServico.setStatus(rs.getString("status"));
                objOrdemServico.setIdVeiculo(rs.getInt("idveiculo"));
                listaDeOrdemServico.add(objOrdemServico);
            }
            return listaDeOrdemServico;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(OrdemServico objOrdemServico) throws Exception {
        try {
            String sql = "insert into ordemservico (inicio, fim, totalpago, "
                    + "precofinal, status, idveiculo)"
                    + "values(?,?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setDate(1, (Date) objOrdemServico.getInico());
            preparedStatement.setDate(2, (Date) objOrdemServico.getFim());
            preparedStatement.setDouble(3, objOrdemServico.getTotalPago());
            preparedStatement.setDouble(4, objOrdemServico.getPrecoFinal());
            preparedStatement.setString(5, objOrdemServico.getStatus());
            preparedStatement.setInt(6, objOrdemServico.getIdVeiculo());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(OrdemServico objOrdemServico) throws Exception {
        try {
            String sql = "update ordemservico set inicio = ?, fim = ?, "
                    + "totalpago = ?, precofinal = ?, status = ?, idveiculo = ?"
                    + "where numeroos = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setDate(1, (Date) objOrdemServico.getInico());
            preparedStatement.setDate(2, (Date) objOrdemServico.getFim());
            preparedStatement.setDouble(3, objOrdemServico.getTotalPago());
            preparedStatement.setDouble(4, objOrdemServico.getPrecoFinal());
            preparedStatement.setString(5, objOrdemServico.getStatus());
            preparedStatement.setInt(6, objOrdemServico.getIdVeiculo());
            preparedStatement.setInt(7, objOrdemServico.getNumeroOS());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int numeroOS) throws Exception {
        String sql = "DELETE FROM ordemservico WHERE numeroos = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numeroOS);
            stmt.executeUpdate();
        }
    }

}
