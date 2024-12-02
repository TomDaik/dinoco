/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.ferramentas.ConexaoBD;
import com.modelos.Veiculo;
import com.modelos.crud.IVeiculoCRUD;
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
public class VeiculoDAO implements IVeiculoCRUD {

    private Connection conexao = null;

    public VeiculoDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
        if (conexao == null) {
            throw new Exception("ERRO DE CONEXAO");
        }
    }

    @Override
    public ArrayList<Veiculo> obterListaDeVeiculo() throws Exception {
        ArrayList<Veiculo> listaDeVeiculo = new ArrayList<>();
        String sql = "select * from veiculo order by idveiculo";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Veiculo objVeiculo = new Veiculo();
                objVeiculo.setIdVeiculo(rs.getInt("idveiculo"));
                objVeiculo.setPlaca(rs.getString("placa"));
                objVeiculo.setChassi(rs.getString("chassi"));
                objVeiculo.setKilometragem(rs.getInt("kilometragem"));
                objVeiculo.setnPatrimonio(rs.getString("npatrimonio"));
                objVeiculo.setAno(rs.getString("ano"));
                objVeiculo.setIdAcessorio(rs.getInt("idacessorio"));
                objVeiculo.setIdModelo(rs.getInt("idmodelo"));
                listaDeVeiculo.add(objVeiculo);
            }
            return listaDeVeiculo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluir(Veiculo objVeiculo) throws Exception {
        try {
            String sql = "insert into veiculo (placa, chassi, kilometragem, "
                    + "npatrimonio, ano, idacessorio, idmodelo)"
                    + "values(?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objVeiculo.getPlaca());
            preparedStatement.setString(2, objVeiculo.getChassi());
            preparedStatement.setInt(3, objVeiculo.getKilometragem());
            preparedStatement.setString(4, objVeiculo.getnPatrimonio());
            preparedStatement.setString(5, objVeiculo.getAno());
            preparedStatement.setInt(6, objVeiculo.getIdAcessorio());
            preparedStatement.setInt(7, objVeiculo.getIdModelo());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void alterar(Veiculo objVeiculo) throws Exception {
        try {
            String sql = "update veiculo set placa = ?, chassi = ?, kilometragem = ?,"
                    + "npatrimonio = ?, ano = ?, idacessorio = ?, idmodelo = ? "
                    + "where idveiculo = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objVeiculo.getPlaca());
            preparedStatement.setString(2, objVeiculo.getChassi());
            preparedStatement.setInt(3, objVeiculo.getKilometragem());
            preparedStatement.setString(4, objVeiculo.getnPatrimonio());
            preparedStatement.setString(5, objVeiculo.getAno());
            preparedStatement.setInt(6, objVeiculo.getIdAcessorio());
            preparedStatement.setInt(7, objVeiculo.getIdModelo());
            preparedStatement.setInt(8, objVeiculo.getIdVeiculo());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw new Exception("Incluir Persistencia: " + erro);
        }
    }

    @Override
    public void remover(int idVeiculo) throws Exception {
        String sql = "DELETE FROM veiculo WHERE idveiculo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idVeiculo);
            stmt.executeUpdate();
        }
    }
}
