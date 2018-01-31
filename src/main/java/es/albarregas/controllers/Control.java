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
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Simon
 */
@WebServlet(name = "Control", urlPatterns = {"/control"})
public class Control extends HttpServlet {

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
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            DAOFactory daof = DAOFactory.getDAOFactory();
            IGenericoDAO<Persona> gdao = daof.getGenericoDAO();
            Persona persona = null;

            String tipo = request.getParameter("tipo");

            switch (tipo) {
                case "normal":
                    persona = new Normal();
                    break;
                case "tecnologo":
                    persona = new Tecnologo();
                    break;
                case "programador":
                    persona = new Programador();
                    break;
                case "tester":
                    persona = new Tester();
                    break;
            }
            BeanUtils.populate(persona, request.getParameterMap());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = format.parse(request.getParameter("fechaNac"));
            
            persona.setFechaNacimiento(fecha);
            gdao.insertUpdate(persona);

            request.getRequestDispatcher("index.html").forward(request, response);
        }
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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
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
