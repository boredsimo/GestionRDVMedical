<%-- 
    Document   : moncompte
    Created on : 18 avr. 2023, 12 h 44 min 33 s
    Author     : mfate
--%>
<%@page import="com.crosemont.priserdv.model.entities.Patient"%>
<% Patient patient = (Patient) request.getAttribute("patient"); %>
<html>
    <head>
        <title>Connexion - Patient</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
    </head>
    <body>
        <header>
            
            <div class="container-fluid" style="background-color: white; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
                                    rgba(0, 0, 0, 0.19); border-radius: 0%; ">
                <nav>
                    <ul>
                        <img src="images/logo.png" alt="Logo" style="border-radius:0%;" width="47px" height="47px">
                        <li style="box-sizing: border-box;  border-radius:0%;display: block;"><a href="espacePatient.jsp" class="active">Mes Rendez-vous</a></li>
                        <li style="box-sizing: border-box;  border-radius:0%;display: block;"><a href="controllerVersMesRendezvous">Prendre un Rendez-vous</a></li>
                        <li style="box-sizing: border-box;  border-radius:0%; display: block;"><a href="comptepatient">Mon Compte</a></li>
                        <li style="box-sizing: border-box;  border-radius:0%;display: block;"><a href="deconnexionController">Deconnexion</a></li>
                        <img id="rosemont" src="images/rosemont.png" alt="rosemont" />
                    </ul>
                </nav>

            </div>
        </header>
        <main class="page_principal">

            <marquee> Bienvenue sur le site web de la Clinique Médicale du Collège de Rosemont</marquee>

            <section class="centrale">

                <h2>Connexion - Patient</h2>
                <div style="display: flex; width: 100%; list-style: none;margin: 0; padding: 0;   background-color: rgb(40, 92, 164);">
                    <div style="flex: 1;
                         text-align: center;"> <img src="images/Alfred.png" > </div>
                    <div style="flex: 1;
                         text-align: center;"> <h3>Nom: </h3>
                        <br> <h2><%= patient.getNom() %> </h2>                  
                    </div>
                    <div style="flex: 1;
  text-align: center;"><h3>Prenom: </h3>
                        <br> <h2><%= patient.getPrenom() %> </h2></div>
                </div>
                <div style="display: flex; width: 100%; list-style: none;margin: 0; padding: 0;   background-color: rgb(40, 92, 164);">
                    <div style="flex: 1;
                         text-align: center;"><h3>Date de naissance: </h3> 
                        <h2><%= patient.getDateNaissance() %> </h2></div>
                    <div style="flex: 1;
                         text-align: center;"> <h3>Sexe: </h3>
                        <br> <h2><%= patient.getSexe() %> </h2>                  
                    </div>
                    <div style="flex: 1;
  text-align: center;"><h3>NUmero d'assurance maladie: </h3>
                        <br> <h2><%= patient.getNumeroAssuranceMaladie() %> </h2></div>
                </div>
                
            </section>

        </main>

        <jsp:include page="pied.jsp"/>     

    </body>
</html>

