
package com.conrado.luiseduardo_teste.controller;

import com.conrado.luiseduardo_teste.dao.MotoristaDao;
import com.conrado.luiseduardo_teste.exception.MotoristaException;
import com.conrado.luiseduardo_teste.model.Motorista;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Conrado
 */
public class MotoristaService {
    private MotoristaDao mDao = new MotoristaDao();

    public List<Motorista> listarMotorista() throws MotoristaException {
        try {
            System.out.println("LISTAGEM DE MOTORISTA");
            return mDao.listarMotorista();
        } catch (SQLException e) {
            throw new MotoristaException("ERRO NA LISTAGEM DE MOTORISTA", e);
        }
    }

    private boolean isValid(Motorista m) {
        return m != null && m.getNome() != null && m.getDataNascimento() != null && m.getModeloCarro() != null && m.getStatus() != null &&  m.getCpf() != null && m.getSexo() != null;
    }

    public void inserirMotorista(Motorista m) throws MotoristaException {
        try {
            if (isValid(m)) {
                System.out.println("CADASTRANDO UM MOTORISTA");
                mDao.inserirMotorista(m);
            } else {
                throw new MotoristaException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MotoristaException("ERRO NA INCLUSÃO DOS DADOS", e);
        }
    }

    public Motorista select(int id) throws MotoristaException {

        try {
            System.out.println("PESQUISANDO MOTORISTA PELO ID");
            return mDao.select(id);
        } catch (SQLException e) {
            throw new MotoristaException("ERRO AO PESQUISAR DADOS DO MOTORISTA", e);
        }

    }
    
    
    
}
