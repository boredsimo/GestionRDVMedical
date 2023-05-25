/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.controller;

import com.crosemont.priserdv.model.DAO.RendezvousImpDAO;
import com.crosemont.priserdv.model.entities.Rendezvous;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giguere Julien
 */
public class EspaceMedecinHoraireModifierController extends HttpServlet {

    Rendezvous unRendezvous;
    RendezvousImpDAO daoRendezvous = new RendezvousImpDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String chaineDateHeure = request.getParameter("dateHeure");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LocalDateTime dateTime = LocalDateTime.parse(chaineDateHeure, formatter);
        ZoneId defaultZoneId = ZoneId.systemDefault();

        Date date1 = Date.from(dateTime.atZone(defaultZoneId).toInstant());
        
        boolean result = false;

        int id = Integer.parseInt(request.getParameter("rendezvousID"));
        String raison = request.getParameter("raison");
        String precision = request.getParameter("precision");
        result = daoRendezvous.updateRaisonPrecision(id, raison, precision);

        String pattern = "H:mm dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (result) {
            request.setAttribute("message", "Rendez-vous attribué avec succès (" + simpleDateFormat.format(date1) + ").");
        }
        request.setAttribute("date", date1);
        request.getRequestDispatcher("EspaceMedecinHoraireController").include(request, response);
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
