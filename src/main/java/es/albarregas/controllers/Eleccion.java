/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Normal;
import es.albarregas.beans.Persona;
import es.albarregas.beans.Programador;
import es.albarregas.beans.Tecnologo;
import es.albarregas.beans.Tester;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/eleccion"})
public class Eleccion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = null;
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO<Persona> gdao = daof.getGenericoDAO();
        switch (request.getParameter("op")) {
            case "add":
                url = "JSP/formularioAlta.jsp";
                break;
            case "persona":
                List<Persona> listaPers = gdao.selectAll(Persona.class);
                request.setAttribute("listado", listaPers);
                break;
            case "tecnologo":
                List<Tecnologo> listaTec = gdao.selectAll(Tecnologo.class);
                request.setAttribute("listadoTecnologo", listaTec);
                break;
            case "normal":
                List<Normal> listaNor = gdao.selectAll(Normal.class);
                request.setAttribute("listadoNormal", listaNor);
                break;
            case "tester":
                List<Tester> listaTes = gdao.selectAll(Tester.class);
                request.setAttribute("listadoTester", listaTes);
                break;
            case "programador":
                List<Programador> listaPro = gdao.selectAll(Programador.class);
                request.setAttribute("listadoProgramador", listaPro);
                break;
        }

        switch (request.getParameter("op")) {
            case "add":
                url = "JSP/formularioAlta.jsp";
                break;
            case "persona":
                url = "JSP/listado.jsp";
                break;
            case "tecnologo":
                url = "JSP/listadoTecnologo.jsp";
                break;
            case "normal":
                url = "JSP/listadoNormal.jsp";
                break;
            case "tester":
                url = "JSP/listadoTester.jsp";
                break;
            case "programador":
                url = "JSP/listadoProgramador.jsp";
                break;
        }

        request.getRequestDispatcher(url).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
