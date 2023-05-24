<%@page import="java.util.ArrayList"%>
<%@page import="com.crosemont.priserdv.model.entities.Clinique"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>

<html>
    <head>
        <title>Espace Patient</title>
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
                        <li style="box-sizing: border-box;  border-radius:0%;display: block;"><a href="">Prendre un Rendez-vous</a></li>
                        <li style="box-sizing: border-box;  border-radius:0%; display: block;"><a href="comptepatient">Mon Compte</a></li>
                        <li style="box-sizing: border-box;  border-radius:0%;display: block;"><a href="deconnexionController">Deconnexion</a></li>
                        <img id="rosemont" src="images/rosemont.png" alt="rosemont" />
                    </ul>
                </nav>

            </div>
        </header>
        <main class="page_principal">


            <% if (session.getAttribute("nom") != null) {%>
            <marquee> Bienvenue dans votre espace patient Mr/Mme <%= session.getAttribute("nom")%>.</marquee> 
                <%} else {%>
            <marquee> Bienvenue dans votre espace patient.</marquee>
                <%}%>

            <section class="centrale">
                
                <% if (session.getAttribute("nom") != null) {%>
            <h1 style="color: black;"> Bienvenue dans votre espace patient Mr/Mme <%= session.getAttribute("nom")%>.</h1> 
                <%} else {%>
                <h1 style="color: black"> Bienvenue dans votre espace patient.</h1>
                <%}%>
                <img src="images/Will Smith.jpg" alt="alt"/>
                
                <div class="container" style=" background-color: white;height: 256; border-radius: 20px;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
                    <img src="images/medecin.webp" style="height: 90px; width: 150" alt="alt"/>
                    <h1 style="color: black;text-align: left">Mon docteur</h1>
                    <h3>Réservez votre rendez-vous avec un docteur qui comblera votre besoin</h3>
                
                
                
                
                </div>

            </section>

        </main>
                

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
