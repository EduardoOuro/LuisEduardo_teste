/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.servlet;

import com.conrado.luiseduardo_teste.controller.PassageiroService;
import com.conrado.luiseduardo_teste.exception.PassageiroException;
import com.conrado.luiseduardo_teste.model.Passageiro;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
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
@WebServlet(name = "PSalverServlet", urlPatterns = {"/passageiros/salvar"})
public class PSalverServlet extends HttpServlet {
    
    private PassageiroService service  = new PassageiroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //PEGAR OS PARAMETROS DE REQUEST
        String nome = request.getParameter("passageiro_nome");
        String cpf = request.getParameter("passageiro_cpf");
        String sexo = request.getParameter("passageiro_sexo");
        String dataEmTexto = request.getParameter("passageiro_dataNascimento");
        Calendar dtNascimento=null;
        
        //FAZER A CONVERSÃO DA DATA
        try{
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dtNascimento =Calendar.getInstance();
            dtNascimento.setTime(date);
        }catch (ParseException e){
            return;
        }
        //SALVAR PASSAGEIRO
        Passageiro p = new Passageiro();
        p.setNome(p.getNome());
        p.setDataNascimento(dtNascimento);        
        p.setCpf(p.getCpf());
        p.setSexo(p.getSexo());
        
        HttpSession sessao = request.getSession();
        try {
            service.inserirPassageiro(p);
            sessao.setAttribute("msgSucesso", "Passageiro salvo com sucesso");
        } catch (PassageiroException ex) {
            sessao.setAttribute("msgErro", "Erro ao salvar Passageiro - " + ex.getMessage());
            
        }
        response.sendRedirect(request.getContextPath() + "/passageiros");

    }
}