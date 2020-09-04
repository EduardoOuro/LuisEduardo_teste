/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Conrado
 */
public class ConexaoFactory {
    
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String LOGIN = "root";
    private static final String SENHA = "";
    private static final String URL ="jdbc:mysql://localhost:3306/corridacompartilhada?"
            +"useUnicode=yes&"
            +"characterEconding=UTF-8&"
            +"useTimezone=true&"
            +"serverTimezone=UTC";
    
    public static final Connection Conectar() throws SQLException{
        java.sql.Connection conexao;
        
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException ex){
            throw new SQLException(ex);
        }
        Connection conn =DriverManager.getConnection(URL, LOGIN, SENHA);
        return conn;
    }    
    
    public static void CloseConnection(Connection conn) throws SQLException{
        try{
            if(conn !=null){
                conn.close();
            }
        }catch (Exception ErrorSQL){
            throw new SQLException(ErrorSQL);
        }
    }
}
