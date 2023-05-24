/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.controller;

import com.crosemont.priserdv.model.DAO.PatientImpDAO;
import com.crosemont.priserdv.model.entities.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giguere julien
 */

public class InscriptionPatientController extends HttpServlet {

    private Patient unPatient;
    PatientImpDAO daoPatient = new PatientImpDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message;
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String numAssuranceMaladie = request.getParameter("numAssuranceMaladie");
        int numSequentiel = Integer.parseInt(request.getParameter("numSequentiel"));
        Date dateNaissance = Date.valueOf((request.getParameter("dateNaissance")));
        String sexe = request.getParameter("sexe");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //int numMedecin = Integer.parseInt(request.getParameter("numMedecin"));


        if (daoPatient.isEmailExist(email)) {
            request.setAttribute("message", "Cet email existe déjà ! Veuillez choisir un nouvel email.");
            request.getRequestDispatcher("inscriptionPatient.jsp").forward(request, response);
        }

        if (daoPatient.isNumExist(numAssuranceMaladie)) {
            request.setAttribute("message", "Ce numéro d'assurance existe déjà ! Veuillez choisir un autre numéro");
            request.getRequestDispatcher("inscriptionPatient.jsp").forward(request, response);
        }
        
        unPatient = new Patient();
        unPatient.setNom(nom);
        unPatient.setPrenom(prenom);
        unPatient.setCodeAssuranceMaladie(numAssuranceMaladie);
        unPatient.setNumeroAssuranceMaladie(numSequentiel);
        unPatient.setDateNaissance(dateNaissance);
        unPatient.setSexe(sexe);
        unPatient.setEmail(email);
        unPatient.setPassword(password);
        unPatient.setAdmin(false);

        
        boolean retour = daoPatient.create(unPatient);
        if (retour) {
            //if(fromadmin !=null){
            //    List<Patient> patients = ActionsPatient.findAll();
            //    request.setAttribute("mespatients", patients);
            //    List<Medecin> medecins = ActionsMedecin.findAll();
            //    request.setAttribute("mesmedecins", medecins);
            //    message = "Le patient a été ajouté avec succes";
            //    request.setAttribute("message", message);
            //    request.getRequestDispatcher("AfficherPatient.jsp").forward (request, response);
            //}else {
                HttpSession session = request.getSession(true);
                session.setAttribute("nom", unPatient.getNom());
                session.setAttribute("id", unPatient.getId());
                request.getRequestDispatcher("espacePatientController").include(request, response);
                
            //}

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
