/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Oficina;
import com.modelos.crud.IOficinaCRUD;
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
public class OficinaDAO implements IOficinaCRUD {

    private Connection conexao = null;

    public OficinaDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Oficina> obterListaDeOficina() throws Exception {
        ArrayList<Oficina> listaDeOficina = new ArrayList<>();
        String sql = "select * from oficina order by idoficina";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Oficina objOficina = new Oficina();
                objOficina.setIdOficina(rs.getInt("idoficina"));
                objOficina.setEmail(rs.getString("email"));
                objOficina.setTelefone(rs.getString("telefone"));
                objOficina.setEndereco(rs.getString("endereco"));
                objOficina.setNomeFantasia(rs.getString("nomefantasia"));
                objOficina.setRazaoSocial(rs.getString("razaosocial"));
                listaDeOficina.add(objOficina);
            }
            return listaDeOficina;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Oficina objOficina) throws Exception {
        try {
            String sql = "insert into oficina (email, telefone, endereco, "
                    + "nomefantasia, razaosocial)"
                    + "values(?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objOficina.getEmail());
            preparedStatement.setString(2, objOficina.getTelefone());
            preparedStatement.setString(3, objOficina.getEndereco());
            preparedStatement.setString(4, objOficina.getNomeFantasia());
            preparedStatement.setString(5, objOficina.getRazaoSocial());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Oficina objOficina) throws Exception {
        try {
            String sql = "update modelo set email = ?, telefone = ?, "
                    + "endereco = ?, nomefantasia = ?, razaosocial = ?"
                    + "where idoficina = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objOficina.getEmail());
            preparedStatement.setString(2, objOficina.getTelefone());
            preparedStatement.setString(3, objOficina.getEndereco());
            preparedStatement.setString(4, objOficina.getNomeFantasia());
            preparedStatement.setString(5, objOficina.getRazaoSocial());
            preparedStatement.setInt(6, objOficina.getIdOficina());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idOficina) throws Exception {
        String sql = "DELETE FROM oficina WHERE idoficina = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idOficina);
            stmt.executeUpdate();
        }
    }
}
