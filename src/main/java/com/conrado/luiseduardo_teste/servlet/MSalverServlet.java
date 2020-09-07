/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.servlet;

import com.conrado.luiseduardo_teste.controller.MotoristaService;
import com.conrado.luiseduardo_teste.exception.MotoristaException;
import com.conrado.luiseduardo_teste.model.Motorista;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Conrado
 */
@WebServlet(name = "MSalverServlet", urlPatterns = {"/motoristas/salvar"})
public class MSalverServlet extends HttpServlet {

    private MotoristaService service = new MotoristaService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //ABRE FORM PARA CADASTRAR
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("motoristas_nome");
        String cpf = request.getParameter("passageiro_cpf");
        String modeloCarro = request.getParameter("motorista_modelo_carro");
        String status = request.getParameter("motorista_status");
        String sexo = request.getParameter("motorista_sexo");
        String dataEmTexto = request.getParameter("motorista_dataNascimento");
        
        Date dtNascimento =null;
//
//        //FAZER A CONVERSÃO DA DATA
//        try{
//            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
//            dtNascimento =Calendar.getInstance();
//            dtNascimento.setTime(date);
//        }catch (ParseException e){
//            return;
//        }
        try {
           dtNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
        }catch (ParseException e){
            return;
        }


         Boolean s = false;
        if (status.equals("1")) {
            s = true;
        }
        
        //SALVAR MOTORISTA
        Motorista m = new Motorista();
        m.setNome(m.getNome());
        m.setDataNascimento(dtNascimento);
        m.setCpf(m.getCpf());
        m.setModeloCarro(modeloCarro);
        m.setStatus(s);
        m.setSexo(m.getSexo());

        HttpSession sessao = request.getSession();
        try {
            service.inserirMotorista(m);
            sessao.setAttribute("msgSucesso", "Motorista salvo com sucesso");
        } catch (MotoristaException ex) {
            sessao.setAttribute("msgErro", "Erro ao salvar Motorista - " + ex.getMessage());

        }
        response.sendRedirect(request.getContextPath() + "/motoristas");

    }
}
