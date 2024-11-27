/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.PessoaFisica;
import com.modelos.crud.IPessoaFisicaCRUD;
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
public class PessoaFisicaDAO implements IPessoaFisicaCRUD {

    private Connection conexao = null;

    public PessoaFisicaDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<PessoaFisica> obterListaDePessoaFisica() throws Exception {
        ArrayList<PessoaFisica> listaDePessoaFisica = new ArrayList<>();
        String sql = "select * from pessoafisica order by idcliente";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PessoaFisica objPessoaFisica = new PessoaFisica();
                objPessoaFisica.setCpf(rs.getString("cpf"));
                objPessoaFisica.setIdCliente(rs.getInt("idcliente"));
                listaDePessoaFisica.add(objPessoaFisica);
            }
            return listaDePessoaFisica;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(PessoaFisica objPessoaFisica) throws Exception {
        try {
            String sql = "insert into pessoafisica (cpf, idcliente)"
                    + "values(?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objPessoaFisica.getCpf());
            preparedStatement.setInt(2, objPessoaFisica.getIdCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(PessoaFisica objPessoaFisica) throws Exception {
        try {
            String sql = "update peca set cpf = ?"
                    + "where idcliente = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objPessoaFisica.getCpf());
            preparedStatement.setInt(2, objPessoaFisica.getIdCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int cpf) throws Exception {
        String sql = "DELETE FROM pessoafisica WHERE cpf = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cpf);
            stmt.executeUpdate();
        }
    }
}
