<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<html>
    <head>
        <title>Espace Administrateur</title>
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
                        <li>
                            <a
                                href="">Comptes Utilisateurs
                            </a>
                        </li>
                        <li>
                            <a
                                href="">Creer un Compte
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
            <marquee> Bienvenue dans votre espace administrateur <%= session.getAttribute("nom")%>.</marquee> 
                <%} else {%>
            <marquee> Bienvenue dans votre espace administrateur.</marquee>
                <%}%>

            <section class="centrale">

            </section>

        </main>
        <jsp:include page="pied.jsp"/>    

    </body>
</html>
