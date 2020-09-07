/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.dao;

import com.conrado.luiseduardo_teste.jdbc.ConexaoFactory;
import com.conrado.luiseduardo_teste.model.Motorista;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Conrado
 */
public class MotoristaDao {

    public void inserirMotorista(Motorista motorista) throws SQLException {

        String sql = "INSERT INTO MOTORISTA(motorista_nome, motorista_dataNascimento, motorista_cpf, motorista_modeloCarro, motorista_status, motorista_sexo)"
                + "VALUES (?,?,?,?,?,?)";

        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, motorista.getNome());
//                stmt.setDate(2, new Date(motorista.getDataNascimento().getTime()));
                stmt.setDate(2, new java.sql.Date(motorista.getDataNascimento().getTime()));
                stmt.setString(3, motorista.getCpf());
                stmt.setString(4, motorista.getModeloCarro());
                stmt.setBoolean(5, motorista.getStatus());
                stmt.setString(6, motorista.getSexo());
                stmt.executeUpdate();

                //EXECUTA TODAS AS OPERAÇÕES NO BD
                conn.commit();
            } catch (Exception e) {
                //DEFAZ AS OPERAÇÕES REALIZADAS NO BANCO DE DADOS
                conn.rollback();
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Motorista> listarMotorista() throws SQLException {
        String sql = "SELECT * FROM MOTORISTA;";
        List<Motorista> motoristas = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Motorista m = new Motorista();
                m.setIdMotorista(rs.getInt("MOTORISTA_ID"));
                m.setNome(rs.getString("MOTORISTA_NOME"));    
                m.setCpf(rs.getString("MOTORISTA_CPF"));
                m.setModeloCarro(rs.getString("MOTORISTA_MODELO_CARRO"));
                m.setStatus(rs.getBoolean("MOTORISTA_STATUS"));
                m.setSexo(rs.getString("MOTORISTA_SEXO"));
                m.setDataNascimento(rs.getDate("MOTORISTA_DATANASCIMENTO"));
                //POPULA A DATA DE NASCIMENTO DO MOTORISTA, FAZENDO CONVERSAO
//                Calendar data = Calendar.getInstance();
//                data.setTime(rs.getDate("MOTORISTA_DATANASCIMENTO"));
//                m.setDataNascimento(data);
                
                //ADICIONA O MOTORISTA NA LISTA
                motoristas.add(m);
            }
        }
        return motoristas;
    }

    public void feriasMotorista(Motorista motorista) throws SQLException {

        String sql = "UPDATE MOTORISTA SET MOTORISTA_STATUS = ?;";

        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setBoolean(1, motorista.getStatus());

                stmt.executeUpdate();

                //EXECUTA TODAS AS OPERAÇÕES NO BD
                conn.commit();
            } catch (Exception e) {
                //DEFAZ AS OPERAÇÕES REALIZADAS NO BANCO DE DADOS
                conn.rollback();
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Motorista select(int id) throws SQLException {
        String sql = "SELECT * FROM MOTORISTA WHERE MOTORISTA_ID= ?;";

        Motorista m = new Motorista();

        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    m.setIdMotorista(rs.getInt("motorista_id"));
                    m.setNome(rs.getString("motorista_nome"));
                    
//                    Calendar data = Calendar.getInstance();
//                    data.setTime(rs.getDate("dataNascimento"));
//                    m.setDataNascimento(data);
                    m.setDataNascimento(rs.getDate("motorista_dataNascimento"));
                    m.setModeloCarro(rs.getString("motorista_modeloCarro"));
                    m.setStatus(rs.getBoolean("motorista_status"));
                    m.setCpf(rs.getString("motorista_cpf"));
                    m.setSexo(rs.getString("motorista_sexo"));
                }

            }
        }
        return m;
    }
}
