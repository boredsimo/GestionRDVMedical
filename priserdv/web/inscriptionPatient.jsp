<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<html>
    <head>
        <title>Inscription - Patient</title>
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

                <h2>Inscription - Patient</h2>
                
                <div>
                    <form action="InscriptionPatientController" method="post" style="text-align: center;" >
                        Nom : <input type="text" name="nom" /> <br>
                        Prénom : <input type="text" name="prenom" /> <br>
                        Numéro d'assurance maladie : <input type="text" name="numAssuranceMaladie" /> <br>
                        Numéro séquentiel : <input type="text" name="numSequentiel" /> <br>
                        Date Naissance : <input type="date" id="dateNaissanceInput" value="1990-06-01" name="dateNaissance" /> <br>
                        Sexe : <input type="text" name="sexe" /> <br>
                        Email : <input type="email" name="email"/> <br>
                        Password : <input type="password" name="password"/> <br>
                        <input type="submit" value="S'inscrire"/>
                    </form>
                </div>
            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
