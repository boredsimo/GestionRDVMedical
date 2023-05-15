/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@WebServlet(name = "espaceAdminClinique", value = "/espaceAdminClinique")
public class espaceAdminClinique extends HttpServlet {    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String id = request.getParameter("id");
    String supprimer = request.getParameter("supprimer");
    String modifier = request.getParameter("modifier");
    String message= null ;
    if (id != null) {
        Clinique clinique = ActionsClinique.findById(Integer.parseInt(id));
        if (clinique != null) {
            if (supprimer != null) {
                boolean isSupprimer = ActionsClinique.deleteClinique(Integer.parseInt(id));
                if (isSupprimer) {
                    List<Clinique> cliniques = ActionsClinique.findAll();
                    request.setAttribute("mescliniques", cliniques);
                    message = "La clinique avec le id: "+clinique.getId()+" a été supprimé";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("AfficherClinique.jsp").forward (request, response);
                }
            } else if (modifier != null) {
                request.setAttribute("clinique", clinique);
                request.getRequestDispatcher("PageModifierClinique.jsp").forward (request, response);
            }
        } else {
            request.getRequestDispatcher("AfficherClinique.jsp").forward (request, response);
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