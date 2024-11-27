/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Funcionario;
import com.modelos.crud.IFuncionarioCRUD;
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
public class FuncionarioDAO implements IFuncionarioCRUD {

    private Connection conexao = null;

    public FuncionarioDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Funcionario> obterListaDeFuncionario() throws Exception {
        ArrayList<Funcionario> listaDeFuncionario = new ArrayList<>();
        String sql = "select * from funcionario order by idfuncionario";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setIdFuncionario(rs.getInt("idfuncionario"));
                objFuncionario.setNome(rs.getString("nome"));
                objFuncionario.setEspecialidade(rs.getString("especialidade"));
                listaDeFuncionario.add(objFuncionario);
            }
            return listaDeFuncionario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Funcionario objFuncionario) throws Exception {
        try {
            String sql = "insert into funcionario(nome, especialidade)"
                    + "values(?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objFuncionario.getNome());
            preparedStatement.setString(2, objFuncionario.getEspecialidade());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Funcionario objFuncionario) throws Exception {
        try {
            String sql = "update funcionario set nome = ?, especialidade = ?"
                    + "where idfuncionario = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objFuncionario.getNome());
            preparedStatement.setString(2, objFuncionario.getEspecialidade());
            preparedStatement.setInt(3, objFuncionario.getIdFuncionario());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Alterar Servicos Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idFuncionario) throws Exception {
        String sql = "DELETE FROM funcionario WHERE idfuncionario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idFuncionario);
            stmt.executeUpdate();
        }
    }
}
