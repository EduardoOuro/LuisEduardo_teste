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
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;

/**
 *
 * @author Conrado
 */
@WebServlet(name = "PListaServlet", urlPatterns = {"/passageiros"})
public class PListaServlet extends HttpServlet {
    
    private PassageiroService service = new PassageiroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Passageiro> passageiros = service.listarPassageiro();
            request.setAttribute("listaPassageiros", passageiros);
        } catch(PassageiroException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        } 
        request.getRequestDispatcher("/WEB-INF/jsp/p-lista-template.jsp").forward(request, response);
    }

}
