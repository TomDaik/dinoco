/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Acessorio;
import com.modelos.crud.IAcessorioCRUD;
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
public class AcessorioDAO implements IAcessorioCRUD {

    private Connection conexao = null;

    public AcessorioDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Acessorio> obterListaDeAcessorio() throws Exception {
        ArrayList<Acessorio> listaDeAcessorio = new ArrayList<>();
        String sql = "select * from acessorio order by idacessorio";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Acessorio objAcessorio = new Acessorio();
                objAcessorio.setIdAcessorio(rs.getInt("idacessorio"));
                objAcessorio.setDescricao(rs.getString("descricao"));
                objAcessorio.setPlacaFK(rs.getString("placafk"));
                listaDeAcessorio.add(objAcessorio);
            }
            return listaDeAcessorio;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Acessorio objAcessorio) throws Exception {
        try {
            String sql = "insert into acessorio(descricao, placafk)"
                    + "values(?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objAcessorio.getDescricao());
            preparedStatement.setString(2, objAcessorio.getPlacaFK());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Acessorio objAcessorio) throws Exception {
        try {
            String sql = "update acessorio set descricao = ?, placafk = ?"
                    + "where idacessorio = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objAcessorio.getDescricao());
            preparedStatement.setString(2, objAcessorio.getPlacaFK());
            preparedStatement.setInt(3, objAcessorio.getIdAcessorio());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Alterar Servicos Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idAcessorio) throws Exception {
        String sql = "DELETE FROM acessorio WHERE idacessorio = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idAcessorio);
            stmt.executeUpdate();
        }
    }
}
