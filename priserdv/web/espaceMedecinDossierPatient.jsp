<%@page import="com.crosemont.priserdv.model.entities.Clinique"%>
<%@page import="com.crosemont.priserdv.model.entities.Rendezvous"%>
<%@page import="java.util.List"%>
<%@page import="com.crosemont.priserdv.model.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<% Patient unPatient = (Patient) request.getAttribute("unPatient"); %>
<% List<Rendezvous> listeRendezvous = (List<Rendezvous>) request.getAttribute("listeRendezvous"); %>
<% List<Clinique> listeClinique = (List<Clinique>) request.getAttribute("listeClinique"); %>

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
                <h2>Dossier du Patient</h2>
                <div style="width:80%;padding-left:10%;padding-right:10%;">
                    <h3><%= unPatient.getNom()%>, <%= unPatient.getPrenom()%></h3>
                    <h4>ID: <%= unPatient.getId()%></h4>
                    <h3> Date de Naissance : <fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= unPatient.getDateNaissance()%>"/></h3>
                    <h3> Sexe : <%= unPatient.getSexe()%></h3>
                    <br>
                    <h3> Code Assurance Maladie : <%= unPatient.getCodeAssuranceMaladie()%></h3>
                    <h3> Numero Assurance Maladie : <%= unPatient.getNumeroAssuranceMaladie()%></h3>
                    <h3> Email : <%= unPatient.getEmail()%></h3>
                    
                    
                    <h3> Rendez-vous :</h3>
                    <br>
                    <% for (Rendezvous unRDV : listeRendezvous) {
                        
                        Clinique cliniqueTrouvee = new Clinique();
                        for (Clinique uneClinique : listeClinique) {
                            if (unRDV.getId() == uneClinique.getId()) {
                                cliniqueTrouvee = uneClinique;
                            }
                        }
                        %>
                    <h4><strong><fmt:formatDate pattern = "yyyy-MM-dd H:mm" value = "<%= unRDV.getHeure() %>"/></strong>: <%= cliniqueTrouvee.getNomClinique()%>, Dr. <%= cliniqueTrouvee.getEmail() %></h4>
                    <h4><%= cliniqueTrouvee.getAddresseRue()%>, <%= cliniqueTrouvee.getVille() %>, <%= cliniqueTrouvee.getProvince() %>, <%= cliniqueTrouvee.getZip() %></h4>
                    <br>
                    <% }%>
                </div>
                
                

            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
