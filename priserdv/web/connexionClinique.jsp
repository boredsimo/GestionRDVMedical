<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<html>
    <head>
        <title>Connexion - Clinique</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
        <script src="js/tabPages.js"></script>
    </head>
    <body>
        <jsp:include page="enTete.jsp"/>
        <main class="page_principal">

            <marquee> Bienvenue sur le site web de la Clinique Médicale du Collège de Rosemont</marquee>

            <section class="centrale">

                <h2>Connexion - Clinique</h2>

                <!-- Tab content Clinique -->
                <div>
                    <form action="connexionCliniqueController" method="post">
                        Email : <input type="email" name="email"/> <br>
                        Password : <input type="password" name="password"/> <br>
                        <% if (request.getAttribute("invalide") != null) {%>
                        <p style="color:red;"><%=request.getAttribute("invalide")%></p>
                        <%}%>
                        <input type="submit" value="Se connecter en tant que Clinique"/>
                    </form>
                </div>

                <script>
                    // Click sur client pour que le form client soit affiche par default
                    document.getElementById("defaultOpen").click();
                </script>
            </section>

        </main>

        <jsp:include page="pied.jsp"/>     

    </body>
</html>
