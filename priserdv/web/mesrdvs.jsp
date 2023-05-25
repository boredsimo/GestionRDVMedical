<%@page import="com.crosemont.priserdv.model.entities.Rendezvous"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>


<%  Rendezvous rdv = (Rendezvous) session.getAttribute("rdv"); %> 
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
                
            <p><%= rdv.getId() %></p>  
            
            

        </main>

        <jsp:include page="pied.jsp"/>

    </body>
</html>
