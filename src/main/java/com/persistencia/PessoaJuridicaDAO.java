/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.PessoaJuridica;
import com.modelos.crud.IPessoaJuridicaCRUD;
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
public class PessoaJuridicaDAO implements IPessoaJuridicaCRUD {

    private Connection conexao = null;

    public PessoaJuridicaDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<PessoaJuridica> obterListaDePessoaJuridica() throws Exception {
        ArrayList<PessoaJuridica> listaDePessoaJuridica = new ArrayList<>();
        String sql = "select * from pessoajuridica order by idcliente";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PessoaJuridica objPessoaJuridica = new PessoaJuridica();
                objPessoaJuridica.setCnpj(rs.getString("cnpj"));
                objPessoaJuridica.setInscricaoEstadual(rs.getString("inscricaoestadual"));
                objPessoaJuridica.setContato(rs.getString("contato"));
                objPessoaJuridica.setRazaoSocial(rs.getString("razaosocial"));
                objPessoaJuridica.setIdCliente(rs.getInt("idcliente"));
                listaDePessoaJuridica.add(objPessoaJuridica);
            }
            return listaDePessoaJuridica;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(PessoaJuridica objPessoaJuridica) throws Exception {
        try {
            String sql = "insert into pessoajuridica (cnpj, inscricaoestadual,"
                    + "contato, razaosocial, idcliente)"
                    + "values(?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objPessoaJuridica.getCnpj());
            preparedStatement.setString(2, objPessoaJuridica.getInscricaoEstadual());
            preparedStatement.setString(3, objPessoaJuridica.getContato());
            preparedStatement.setString(4, objPessoaJuridica.getRazaoSocial());
            preparedStatement.setInt(5, objPessoaJuridica.getIdCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(PessoaJuridica objPessoaJuridica) throws Exception {
        try {
            String sql = "update pessoajuridica set cnpj = ?, inscricaoestadual = ?, "
                    + "contato = ?, razaosocial = ?"
                    + "where idcliente = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objPessoaJuridica.getCnpj());
            preparedStatement.setString(2, objPessoaJuridica.getInscricaoEstadual());
            preparedStatement.setString(3, objPessoaJuridica.getContato());
            preparedStatement.setString(4, objPessoaJuridica.getRazaoSocial());
            preparedStatement.setInt(5, objPessoaJuridica.getIdCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int cnpj) throws Exception {
        String sql = "DELETE FROM pessoajuridica WHERE cnpj = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cnpj);
            stmt.executeUpdate();
        }
    }
}
