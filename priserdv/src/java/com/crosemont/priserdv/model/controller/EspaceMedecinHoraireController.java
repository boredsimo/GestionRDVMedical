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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giguere julien
 */
public class EspaceMedecinHoraireController extends HttpServlet {

    private Rendezvous unRendezvous;
    RendezvousImpDAO daoRendezvous = new RendezvousImpDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        int medecin_id = (int) session.getAttribute("id");
        
        Date uneDate = new Date();
        if (request.getParameter("dateHoraire") != null) {
            try {
                String strDate = (String) request.getParameter("dateHoraire");
                uneDate = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
            } catch (ParseException ex) {
                Logger.getLogger(EspaceMedecinHoraireController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.setAttribute("date", uneDate);
        
        List<Rendezvous> listeRendezvous = daoRendezvous.findByMedecinIdAndDate(medecin_id, new java.sql.Date(uneDate.getTime()));        
        request.setAttribute("listeRendezvous", listeRendezvous);
        
        request.getRequestDispatcher("espaceMedecinHoraire.jsp").include(request, response);
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
