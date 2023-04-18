<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Espace Medecin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
    </head>
    <body>
        <jsp:include page="espaceMedecinEnTete.jsp"/>
        <main class="page_principal">


            <% if (session.getAttribute("nom") != null) {%>
            <marquee> Bienvenue dans votre espace medecin Mr/Mme <%= session.getAttribute("nom")%>.</marquee> 
                <%} else {%>
            <marquee> Bienvenue dans votre espace medecin.</marquee>
                <%}%>

            <section class="centrale">

            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
