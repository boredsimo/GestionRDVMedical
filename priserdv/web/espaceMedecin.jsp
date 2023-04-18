<%@page import="java.util.ArrayList"%>
<%@page import="com.crosemont.priserdv.model.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
<% ArrayList<Patient> listePatient = (ArrayList)request.getAttribute("listPatient");%>
-->
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
        <header>
            <div class="banniere">
                <img id="logo" src="images/logo.png" alt="logo" />
                <img id="rosemont" src="images/rosemont.png" alt="rosemont" />
                <h1>Clinique Médicale du Collège de Rosemont</h1>

            </div>
            <div>
                <nav>
                    <ul>
                        <li>
                            <a
                                href="">Dossier de patient
                            </a>
                        </li>
                        <li>
                            <a
                                href="">Mon horaire
                            </a>
                        </li>
                        <li>
                            <a
                                href="">Mon Compte
                            </a>
                        </li>
                        <li>
                            <a
                                href="index.jsp">Deconnexion
                            </a>
                        </li>
                    </ul>
                </nav>

            </div>
        </header>
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
