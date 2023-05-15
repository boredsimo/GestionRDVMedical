/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.controller;


import actions.ActionsMedecin;
import actions.ActionsPatient;

import com.crosemont.priserdv.model.entities.Medecin;
import com.crosemont.priserdv.model.entities.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "espaceAdminPatient", value = "/espaceAdminPatient")
public class espaceAdminPatient extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String supprimer = request.getParameter("supprimer");
        String modifier = request.getParameter("modifier");
        String admin = request.getParameter("admin");
        String message= null ;
        if (id != null) {
            Patient patient = ActionsPatient.findById(Integer.parseInt(id));
            if (patient != null) {
                if (supprimer != null) {
                    boolean isSupprimer = ActionsPatient.deletePatient(Integer.parseInt(id));
                    if (isSupprimer) {
                        List<Patient> patients = ActionsPatient.findAll();
                        message = "Le patient avec le id: "+patient.getId()+" a été supprimé";
                        request.setAttribute("message", message);
                        request.setAttribute("mespatients", patients);
                        request.getRequestDispatcher("AfficherPatient.jsp").forward (request, response);

                    }
                } else if (modifier != null) {
                    request.setAttribute("patient", patient);
                    List<Medecin> medecins = ActionsMedecin.findAll();
                    request.setAttribute("mesmedecin", medecins);
                    request.getRequestDispatcher("PageModifierPatient.jsp").forward (request, response);

                }else if (admin != null) {
                    Boolean fromadmin = true;
                    request.setAttribute("fromadmin", fromadmin);
                    request.getRequestDispatcher("PageInscriptionPatient.jsp").forward (request, response);
                }

            } else {
                request.getRequestDispatcher("AfficherPatient.jsp").forward (request, response);
            }

        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
