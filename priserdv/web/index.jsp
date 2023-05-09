<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<html>
    <head>
        <title>Accueil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
    </head>
    <body>

        <jsp:include page="enTete.jsp"/>
        <main class="page_principal">
                
                
                <% if (request.getAttribute("deconnecte") != null) {%>
            <marquee><%= request.getAttribute("deconnecte")%></marquee> 
                <%} else {%>
            <marquee> Bienvenue sur le site web de la Clinique Médicale du Collège de Rosemont.</marquee>
                <%}%>
                
                
            

            <section class="centrale">
                
                <div class="boiteConnexion"> 
                    <h1>Connexion</h1>
                    
                    <h3><a href="connexionPatient.jsp">Patient</a></h3>
                    <h3><a href="connexionMedecin.jsp">Medecin</a></h3>
                    <h3><a href="connexionClinique.jsp">Clinique</a></h3>
                </div>
                <div class="boiteInscription"> 
                    <h1>Inscription</h1>
                    
                    <h3><a href="inscriptionPatient.jsp">Patient</a></h3>
                    <h3><a>Medecin</a></h3>
                    <h3><a>Clinique</a></h3>
                </div>

                
            </section>

        </main>

        <jsp:include page="pied.jsp"/>

    </body>
</html>
