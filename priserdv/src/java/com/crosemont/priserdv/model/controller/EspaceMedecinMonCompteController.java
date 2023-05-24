/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.controller;

import com.crosemont.priserdv.model.DAO.CliniqueImpDAO;
import com.crosemont.priserdv.model.DAO.MedecinImpDAO;
import com.crosemont.priserdv.model.DAO.SpecialisationImpDAO;
import com.crosemont.priserdv.model.entities.Clinique;
import com.crosemont.priserdv.model.entities.Medecin;
import com.crosemont.priserdv.model.entities.Specialisation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author julie
 */
public class EspaceMedecinMonCompteController extends HttpServlet {

    Medecin unMedecin;
    MedecinImpDAO daoMedecin = new MedecinImpDAO();
    
    List<Specialisation> listeSpec;
    SpecialisationImpDAO daoSpecialisation = new SpecialisationImpDAO();
    
    List<Clinique> listeClinique;
    CliniqueImpDAO daoClinique = new CliniqueImpDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        int medecin_id = (int) session.getAttribute("id");
        unMedecin = daoMedecin.findById(medecin_id);
        
        request.setAttribute("unMedecin", unMedecin);
        
       listeSpec = daoSpecialisation.findAll();
       String nomSpecialisation = "";
       for (Specialisation spec : listeSpec) {
           if (spec.getId() == unMedecin.getSpecialisation_id()) {
               nomSpecialisation = spec.getTitre();
           }
       }
        request.setAttribute("nomSpecialisation", nomSpecialisation);
       
       listeClinique = daoClinique.findAll();
       String nomClinique = "";
       for (Clinique clinique : listeClinique) {
           if (clinique.getId() == unMedecin.getClinique_id()) {
               nomClinique = clinique.getNomClinique();
           }
       }
        request.setAttribute("nomClinique", nomClinique);
       
       request.getRequestDispatcher("espaceMedecinMonCompte.jsp").include(request, response);
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
