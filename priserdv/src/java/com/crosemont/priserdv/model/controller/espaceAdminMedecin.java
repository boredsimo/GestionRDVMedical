/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.controller;

import actions.ActionsClinique;
import actions.ActionsMedecin;
import actions.ActionsPatient;

import com.crosemont.priserdv.model.entities.Clinique;
import com.crosemont.priserdv.model.entities.Medecin;
import com.crosemont.priserdv.model.entities.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "espaceAdminMedecin", value = "/espaceAdminMedecin")
public class espaceAdminMedecin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String supprimer = request.getParameter("supprimer");
        String modifier = request.getParameter("modifier");
        String message= null ;
        if (id != null) {
            Medecin medecin = ActionsMedecin.findById(Integer.parseInt(id));
            if (medecin != null) {
                if (supprimer != null) {
                    boolean isSupprimer = ActionsMedecin.deleteMedecin(Integer.parseInt(id));
                    if (isSupprimer) {
                        List<Medecin> medecins = ActionsMedecin.findAll();
                        request.setAttribute("mesmedecin", medecins);
                        List<Clinique> mescliniques = ActionsClinique.findAll();
                        request.setAttribute("mescliniques", mescliniques);
                        message = "Le medecin avec le id: "+medecin.getId()+" a été supprimé";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("AfficherMedecin.jsp").forward (request, response);

                    }
                } else if (modifier != null) {
                    List<Clinique> mesClinique = ActionsClinique.findAll();
                    request.setAttribute("mesClinique", mesClinique);
                    request.setAttribute("medecin", medecin);
                    request.getRequestDispatcher("PageModifierMedecin.jsp").forward (request, response);
                } else {

                }

            } else {
                request.getRequestDispatcher("AfficherMedecin.jsp").forward (request, response);
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

