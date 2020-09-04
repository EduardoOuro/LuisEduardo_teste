/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.dao;

import com.conrado.luiseduardo_teste.jdbc.ConexaoFactory;
import com.conrado.luiseduardo_teste.model.Corrida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Conrado
 */
public class CorridaDao {
    
    public void inserirCorrida( Corrida corrida) throws SQLException{
        String sql = "INSERT INTO CORRIDA( CORRIDA_VALOR_TOTAL, CORRIDA_MOTORISTA_ID, CORRIDA_PASSAGEIRO_ID)"
                + "VALUES (?,?,?);";
                try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);

            if(corrida.getMotorista().getStatus()!= false){
                
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, corrida.getValorCorrida());
                stmt.setInt(3, corrida.getMotorista().getIdMotorista());
                stmt.setInt(4, corrida.getPassageiro().getIdPassageiro());

               int resultados = stmt.executeUpdate();

                //EXECUTA TODAS AS OPERAÇÕES NO BD
                conn.commit();
            } catch (Exception e) {
                //DEFAZ AS OPERAÇÕES REALIZADAS NO BANCO DE DADOS
                conn.rollback();
                throw new SQLException(e);
            }
            }   
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public int consultarCorrida(int id) throws SQLException{
        String sql = "SELECT * FROM CORRIDA WHERE CORRIDA_ID= ?;";
        int qt =0;
        try(Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try (ResultSet rs =stmt.executeQuery()){
                while(rs.next()){
                    qt = rs.getInt("corrida_id");
                }
            } 
        }
        return qt;
    }
    
}
