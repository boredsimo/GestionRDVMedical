<%@page import="java.util.ArrayList"%>
<%@page import="com.crosemont.priserdv.model.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<% ArrayList<Patient> listePatient = (ArrayList)request.getAttribute("listPatient");%>
<html>
    <head>
        <title>Espace Medecin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
        <script>
        function check() {
        if (document.getElementById("myCheck").checked === true){
            document.getElementById("tr").style.backgroundColor = "gray";
            
        } else{
            document.getElementById("tr").style.backgroundColor = "white";
        }
        }
            </script>
    </head>
    <body>
        <jsp:include page="espaceMedecinEnTete.jsp"/>
        <main class="page_principal">


            <% if (session.getAttribute("nom") != null) {%>
            <marquee> Bienvenue dans votre espace medecin Mr/Mme <%= session.getAttribute("nom")%>.</marquee> 
                <%} else {%>
            <marquee> Bienvenue dans votre espace medecin.</marquee>
                <%}%>
            
            <h1 style="align-content: center; color: black">Voila la liste de vos rendez vous avec le patient</h1>

            <section class="centrale">
                <table border="1" >
                    <thead>
                        <tr>
                            <th>nom </th>
                            <th>prenom</th>
                            <th>dtae de naissance</th>
                            <th>sexe</th>
                            <th>num assurence maladoe</th>
                            <th>Status de la demande</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Patient patient : listePatient) { %>
                        <tr id="tr">
                            <td><%= patient.getNom() %> </td>
                            <td><%= patient.getPrenom() %></td>
                            <td><%= patient.getDateNaissance() %></td>
                            <td><%= patient.getSexe() %></td>
                            <td><%= patient.getNumeroAssuranceMaladie() %></td>
                            <td style="align-content: center"> <input type="checkbox" id="myCheck" onclick="check()"></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>

            </section>
            

        </main>
                
                


        <jsp:include page="pied.jsp"/>    

    </body>
</html>
