<%@page import="com.crosemont.priserdv.model.entities.Medecin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<html>
    <title>Espace Medecin - Mon Compte</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
    <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <body>
        <jsp:include page="espaceMedecinEnTete.jsp"/>
        <main class="page_principal">

            <section class="centrale">
                <h2>Information sur votre compte:</h2>
                <div class="grid-container">

                    <% if (request.getAttribute("unMedecin") != null) {
                        Medecin med = (Medecin)request.getAttribute("unMedecin");
                    %>

                    <div>Nom: <%=med.getNom()%></div>
                    <div>Prenom: <%=med.getPrenom()%></div>
                    <div>Email: <%=med.getEmail()%></div>
                    <div>Numero de Medecin: <%=med.getNumeroMedecin()%></div>
                    <div>Specialisation: <%=request.getAttribute("nomSpecialisation")%></div>
                    <div>Clinique: <%=request.getAttribute("nomClinique")%></div>   


                    <form action="EspaceMedecinMonComptePrixController" method="post">
                        <label for="lname">Prix de consultation:</label><br>
                        <input type="text" id="prix" name="prix" value='<%=med.getAppointmentPrice()%>'>
                        <button class="btn btn-success" type="submit" >Modifier</button>
                    </form> 
                        
                    <%  } else {%>
                    <h1>Une erreur s'est produite.</h1>
                    <% } %>
                    
                </div>


            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
