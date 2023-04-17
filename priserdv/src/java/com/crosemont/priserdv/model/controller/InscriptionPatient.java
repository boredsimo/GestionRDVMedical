
public class InscriptionPatient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException         if a servlet-specific error occurs
     * @throws IOException              if an I/O error occurs
     * @throws java.text.ParseException
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Patient patient;
        String message;
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String numAssuranceMaladie = request.getParameter("numAssuranceMaladie");
        int numSequentiel = Integer.parseInt(request.getParameter("numSequentiel"));
        Date dateNaissance = Date.valueOf((request.getParameter("dateNaissance")));
        String sexe = request.getParameter("sexe");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int numMedecin = Integer.parseInt(request.getParameter("numMedecin"));


        if (Helper.isEmailAlreadyExist(email)) {
            request.setAttribute("message", "Cet email existe déjà ! Veuillez choisir un nouvel email.");
            request.getRequestDispatcher("InscriptionPatientForm").forward(request, response);
        }

        if (ActionsPatient.isHINExist(numAssuranceMaladie)) {
            request.setAttribute("message", "Ce numéro d'assurance existe déjà ! Veuillez choisir un autre numéro");
            request.getRequestDispatcher("InscriptionPatientForm").forward(request, response);
        }

        patient = new Patient(prenom, nom, numAssuranceMaladie, numSequentiel, dateNaissance, sexe, email, password, false, numMedecin);
        boolean retour = ActionsPatient.ajouterUnPatient(patient);
        if (retour) {
            if(fromadmin !=null){
                List<Patient> patients = ActionsPatient.findAll();
                request.setAttribute("mespatients", patients);
                List<Medecin> medecins = ActionsMedecin.findAll();
                request.setAttribute("mesmedecins", medecins);
                message = "Le patient a été ajouté avec succes";
                request.setAttribute("message", message);
                request.getRequestDispatcher("AfficherPatient.jsp").forward (request, response);
            }else {
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
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

