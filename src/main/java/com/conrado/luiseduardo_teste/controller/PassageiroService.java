/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.controller;

import com.conrado.luiseduardo_teste.dao.PassageiroDao;
import com.conrado.luiseduardo_teste.exception.PassageiroException;
import com.conrado.luiseduardo_teste.model.Passageiro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Conrado
 */
public class PassageiroService {
     private PassageiroDao pDao = new PassageiroDao();

    public List<Passageiro> listarPassageiro() throws PassageiroException {
        try {
            System.out.println("LISTAGEM DE PASSAGEIROS");
            return pDao.listarPassageiro();
        } catch (SQLException e) {
            throw new PassageiroException("ERRO NA LISTAGEM DE PASSAGEIROS", e);
        }
    }

    private boolean isValid(Passageiro p) {
        return p != null && p.getNome() != null && p.getDataNascimento() != null && p.getCpf() != null && p.getSexo() != null;
    }

    public void inserirPassageiro(Passageiro p) throws PassageiroException {
        try {
            if (isValid(p)) {
                System.out.println("CADASTRANDO UM PASSAGEIRO");
                pDao.inserirPassageiro(p);
            } else {
                throw new PassageiroException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PassageiroException("ERRO NA INCLUSÃO DOS DADOS", e);
        }
    }

    public Passageiro select(int id) throws PassageiroException {

        try {
            System.out.println("PESQUISANDO PASSAGEIRO PELO ID");
            return pDao.select(id);
        } catch (SQLException e) {
            throw new PassageiroException("ERRO AO PESQUISAR DADOS DO PASSAGEIRO", e);
        }

    }
}
