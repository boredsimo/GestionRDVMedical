<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<html>
    <head>
        <title>Connexion - Medecin</title>
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

                <h2>Connexion - Medecin</h2>
                <div>
            <form action="connexionMedecinController" method="post">
                    <div class="form-outline mb-4">
                    <input type="email" name="email" class="form-control" />
                    <label class="form-label" for="email">Adresse Email:</label>
                    </div>
                                            Password : <input type="password" name="password"/> <br>
                    <% if (request.getAttribute("invalide") != null) {%>
                    <p style="color:red;"><%=request.getAttribute("invalide")%></p>
                    <%}%>
                    <input type="submit" value="Se connecter en tant que Medecin"/>
            </form>
                </div>
                        
                        
                        <div>
                            <form>
  

        </main>

        <jsp:include page="pied.jsp"/>     

    </body>
</html>
