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
@WebServlet(name = "MListaServlet", urlPatterns = {"/motoristas"})
public class MListaServlet extends HttpServlet {
    
    private MotoristaService service = new MotoristaService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Motorista> motoristas = service.listarMotorista();
            request.setAttribute("listaMotoristas", motoristas);
        } catch(MotoristaException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        } 
        request.getRequestDispatcher("/WEB-INF/jsp/m-lista-template.jsp").forward(request, response);
    }

}
