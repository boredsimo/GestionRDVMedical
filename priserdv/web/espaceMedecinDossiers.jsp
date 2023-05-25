<%@page import="com.crosemont.priserdv.model.entities.Medecin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
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
               


            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
