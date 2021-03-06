/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Conrado
 */
@WebServlet(name = "MFormServlet", urlPatterns = {"/motoristas/novo", "/motoristas/editar"})
public class MFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String urlInformada = request.getRequestURI();
        if (urlInformada.endsWith("/novo")) {
            // Significa que usuário está abrindo formulário para inclusão.
            request.setAttribute("acao", "incluir");
        } else {
            // Significa que usuário está abrindo formulário para edição.
            request.setAttribute("acao", "alterar");
            String idStr = request.getParameter("id");
            // TODO: Consultar o contato pelo ID e levar para JSP com o request.setAttribute
        }
        request.getRequestDispatcher("/WEB-INF/jsp/m-form-template.jsp").forward(request, response);
    }
}    