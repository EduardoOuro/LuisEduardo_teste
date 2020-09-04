package com.conrado.luiseduardo_teste.dao;

import com.conrado.luiseduardo_teste.jdbc.ConexaoFactory;
import com.conrado.luiseduardo_teste.model.Passageiro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Conrado
 */
public class PassageiroDao {

    public PassageiroDao() {

    }

    public void inserirPassageiro(Passageiro passageiro) throws SQLException {
        String sql = "INSERT INTO PASSAGEIRO(PASSAGEIRO_NOME, PASSAGEIRO_DATANASCIMENTO, PASSAGEIRO_CPF, PASSAGEIRO_SEXO)"
                + "VALUES (?,?,?,?);";
        try (Connection conn = ConexaoFactory.Conectar()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERAÇÕES NO BD CASO OCORRA ERRO
            conn.setAutoCommit(false);

            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR ID GERADO NO BD
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, passageiro.getNome());
                stmt.setDate(2, new Date(passageiro.getDataNascimento().getTimeInMillis()));
                stmt.setString(3, passageiro.getCpf());
                stmt.setString(4, passageiro.getSexo());

                stmt.executeUpdate();

                // EFETIVAR NO BD TODAS AS OPERACOES REALIZADAS
                conn.commit();
            } catch (Exception e) {
                // DESFAZ TODAS AS OPERAÇÕES REALIDAS CASO OCORRA ALGUM ERRO NA LÓGICA ACIMA.
                conn.rollback();
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    public List<Passageiro> listarPassageiro() throws SQLException {
        String sql = "SELECT * FROM PASSAGEIRO;";
        List<Passageiro> passageiros = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Passageiro p = new Passageiro();
                p.setIdPassageiro(rs.getInt("PASSAGEIRO_ID"));
                p.setNome(rs.getString("PASSAGEIRO_NOME"));
                p.setCpf(rs.getString("PASSAGEIRO_CPF"));
                p.setSexo(rs.getString("PASSAGEIRO_SEXO"));
                
                  //POPULA A DATA DE NASCIMENTO DO PASSAGEIRO, FAZENDO CONVERSAO
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("PASSAGEIRO_DATANASCIMENTO"));
                p.setDataNascimento(data);
                
                
                //ADICIONA O PASSAGEIRO NA LISTA
                passageiros.add(p);
            }
        }
        return passageiros;
    }

    public Passageiro select(int id) throws SQLException {
        String sql = "SELECT * FROM PASSAGEIRO WHERE FUNC_ID = ?;";
        Passageiro passageiro = new Passageiro();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    passageiro.setIdPassageiro(rs.getInt("PASSAGEIRO_ID"));
                    passageiro.setNome(rs.getString("PASSAGEIRO_NOME"));
                    
                    //popula a data de nascimento do contato, fazendo a conversao
                    Calendar data = Calendar.getInstance();
                    data.setTime(rs.getDate("dataNascimento"));
                    passageiro.setDataNascimento(data);

                    passageiro.setCpf(rs.getString("PASSAGEIRO_CPF"));
                    passageiro.setSexo(rs.getString("PASSAGEIRO_SEXO"));
                }
            }
        }
        return passageiro;

    }

}
