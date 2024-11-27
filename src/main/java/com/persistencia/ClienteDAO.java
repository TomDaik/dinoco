/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Cliente;
import com.modelos.crud.IClienteCRUD;
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
public class ClienteDAO implements IClienteCRUD {

    private Connection conexao = null;

    public ClienteDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Cliente> obterListaDeCliente() throws Exception {
        ArrayList<Cliente> listaDeCliente = new ArrayList<>();
        String sql = "select * from cliente order by idcliente";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Cliente objCliente = new Cliente();
                objCliente.setIdCliente(rs.getInt("idcliente"));
                objCliente.setNome(rs.getString("nome"));
                objCliente.setDdi1(rs.getString("ddi1"));
                objCliente.setDdd1(rs.getString("ddd1"));
                objCliente.setNumero1(rs.getString("numero1"));
                objCliente.setDdi2(rs.getString("ddi2"));
                objCliente.setDdd2(rs.getString("ddd2"));
                objCliente.setNumero2(rs.getString("numero2"));
                objCliente.setEmail(rs.getString("email"));
                objCliente.setLogradouro(rs.getString("logradouro"));
                objCliente.setComplemento(rs.getString("complemento"));
                objCliente.setBairro(rs.getString("bairro"));
                objCliente.setCep(rs.getString("cep"));
                objCliente.setMunicipio(rs.getString("municipio"));
                objCliente.setUf(rs.getString("uf"));
                listaDeCliente.add(objCliente);
            }
            return listaDeCliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Cliente objCliente) throws Exception {
        try {
            String sql = "insert into cliente(nome, ddi1, ddd1, numero1, ddi2, "
                    + "ddd2, numero2, email, logradouro, complemento, bairro, "
                    + "cep, municipio, uf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objCliente.getNome());
            preparedStatement.setString(2, objCliente.getDdi1());
            preparedStatement.setString(3, objCliente.getDdd1());
            preparedStatement.setString(4, objCliente.getNumero1());
            preparedStatement.setString(5, objCliente.getDdi2());
            preparedStatement.setString(6, objCliente.getDdd2());
            preparedStatement.setString(7, objCliente.getNumero2());
            preparedStatement.setString(8, objCliente.getEmail());
            preparedStatement.setString(9, objCliente.getLogradouro());
            preparedStatement.setString(10, objCliente.getComplemento());
            preparedStatement.setString(11, objCliente.getBairro());
            preparedStatement.setString(12, objCliente.getCep());
            preparedStatement.setString(13, objCliente.getMunicipio());
            preparedStatement.setString(14, objCliente.getUf());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Cliente objCliente) throws Exception {
        try {
            String sql = "update cliente set nome = ?, ddi1 = ?, ddd1 = ?, "
                    + "numero1 = ?, ddi2 = ?, ddd2 = ?, numero2 = ?, email = ?,"
                    + " logradouro = ?, complemento = ?, bairro = ?, cep = ?,"
                    + " muunicipio = ?, uf = ? where idcliente = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objCliente.getNome());
            preparedStatement.setString(2, objCliente.getDdi1());
            preparedStatement.setString(3, objCliente.getDdd1());
            preparedStatement.setString(4, objCliente.getNumero1());
            preparedStatement.setString(5, objCliente.getDdi2());
            preparedStatement.setString(6, objCliente.getDdd2());
            preparedStatement.setString(7, objCliente.getNumero2());
            preparedStatement.setString(8, objCliente.getEmail());
            preparedStatement.setString(9, objCliente.getLogradouro());
            preparedStatement.setString(10, objCliente.getComplemento());
            preparedStatement.setString(11, objCliente.getBairro());
            preparedStatement.setString(12, objCliente.getCep());
            preparedStatement.setString(13, objCliente.getMunicipio());
            preparedStatement.setString(14, objCliente.getUf());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Alterar Servicos Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idCliente) throws Exception {
        String sql = "DELETE FROM cliente WHERE idcliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }
}
