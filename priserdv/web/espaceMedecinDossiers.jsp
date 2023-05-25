<%@page import="com.crosemont.priserdv.model.entities.Patient"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>

<% List<Patient> listPatient = (List<Patient>) request.getAttribute("listPatient"); %>
<html>
    <title>Espace Medecin - Dossier de Patient</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
    <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <body>
        <jsp:include page="espaceMedecinEnTete.jsp"/>
        <main class="page_principal">

            <section class="centrale">
                <h2>Patients</h2>

                <div class="grid-container">

                    <div class="grid-child">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th >id</th>
                                    <th >nom</th>
                                    <th >prenom</th>
                                    <th >codeAssurance Maladie</th>
                                    <th >Lien</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Patient unPatient : listPatient) {%>
                                <tr>
                                    <th ><strong><%= unPatient.getId()%></strong></th>
                                    <td><%= unPatient.getNom()%></td>
                                    <td><%= unPatient.getPrenom()%></td>
                                    <td><%= unPatient.getCodeAssuranceMaladie()%></td>
                                    <td>
                                        <form action="EspaceMedecinDossierPatientController" method="post" style="display: inline;">
                                            <input type="hidden" id="patient_id" value="<%=unPatient.getId()%>" placeholder="patient ID" name="patient_id" />
                                            <button class="btn btn-success" type="submit" >Consulter Dossier</button>
                                        </form>
                                    </td>
                                    
                                </tr> 
                                
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                </div>

            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
