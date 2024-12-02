/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Servico;
import com.modelos.crud.IServicoCRUD;
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
public class ServicoDAO implements IServicoCRUD {

    private Connection conexao = null;

    public ServicoDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Servico> obterListaDeServico() throws Exception {
        ArrayList<Servico> listaDeServico = new ArrayList<>();
        String sql = "select * from servico order by idservico";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Servico objServico = new Servico();
                objServico.setIdServico(rs.getInt("idservico"));
                objServico.setDescricao(rs.getString("descricao"));
                objServico.setPrecoUnitario(rs.getDouble("precounitario"));
                listaDeServico.add(objServico);
            }
            return listaDeServico;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Servico objServico) throws Exception {
        try {
            String sql = "insert into servico (descricao, precounitario)"
                    + "values(?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objServico.getDescricao());
            preparedStatement.setDouble(2, objServico.getPrecoUnitario());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Servico objServico) throws Exception {
        try {
            String sql = "update servico set descricao = ?, precounitario = ? "
                    + "where idservico = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objServico.getDescricao());
            preparedStatement.setDouble(2, objServico.getPrecoUnitario());
            preparedStatement.setInt(3, objServico.getIdServico());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idServico) throws Exception {
        String sql = "DELETE FROM servico WHERE idservico = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idServico);
            stmt.executeUpdate();
        }
    }

}
