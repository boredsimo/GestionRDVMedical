/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.controller;

import com.crosemont.priserdv.model.DAO.MedecinImpDAO;
import com.crosemont.priserdv.model.DAO.PatientImpDAO;
import com.crosemont.priserdv.model.entities.Medecin;
import com.crosemont.priserdv.model.entities.Patient;
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
 * @author Giguere julien
 */
public class connexionMedecinController extends HttpServlet {

    private Medecin unMedecin;
    MedecinImpDAO daoMedecin = new MedecinImpDAO();
    PatientImpDAO daoPatient= new PatientImpDAO();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean connexion = false;
        PrintWriter out = response.getWriter();
        List<Patient> listPatient;
        
        //Recuperer l'email, le mot de passe
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        unMedecin = daoMedecin.existsByEmailAndPassword(email, password);
        //Vérifier si l'email et mot de passe de l'utilisateur existent
        //for (Patient patient : listePatients) {
        if (unMedecin != null) {
                connexion = true;
                HttpSession session = request.getSession(true);
                session.setAttribute("nom", unMedecin.getNom());
                session.setAttribute("id", unMedecin.getId());
                PatientImpDAO patientDao = new PatientImpDAO();
                listPatient= patientDao.findAll();
                request.setAttribute("listPatient", listPatient);
                request.getRequestDispatcher("espaceMedecinController").include(request, response);
        }

        if (!connexion) {
            request.setAttribute("invalide", "L'email ou mot de passe ne correspond pas à un compte Medecin.");
            request.getRequestDispatcher("connexionMedecin.jsp").include(request, response);
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
