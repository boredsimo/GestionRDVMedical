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
            <div class="banniere">
                <img id="logo" src="images/logo.png" alt="logo" />
                <img id="rosemont" src="images/rosemont.png" alt="rosemont" />
                <h1>Clinique Médicale du Collège de Rosemont</h1>

            </div>
            <div>
                <nav>
                    <ul>
                        <li><a href="espacePatient.jsp" class="active">Mes Rendez-vous</a></li>
                        <li>
                            <a
                                href="">Prendre un Rendez-vous
                            </a>
                        </li>
                        <li>
                            <a
                                href="comptepatient">Mon Compte
                            </a>
                        </li>
                        <li>
                            <a
                                href="deconnexionController">Deconnexion
                            </a>
                        </li>
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
                

            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
