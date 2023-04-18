<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Inscription - Clinique</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
        <script src="js/tabPages.js"></script>
    </head>
    <body>
        <jsp:include page="enTete.jsp"/>
        <main class="page_principal">

            <marquee> Bienvenue sur le site web de la Clinique MÃ©dicale du CollÃ¨ge de Rosemont</marquee>

            <section class="centrale">

                <h2>Inscription - Clinique</h2>

                <div>
                    <form action="" method="post">
                        Nom de la Clinique: <input type="text" name="nom" /> <br>
                        Adresse de la Clinique : <input type="text" name="adresse"> <br>
                        Ville : <input type="text" name="ville" /> <br>
                        Zip Code : <input type="text" name="zip" /> <br>
                        Email : <input type="email" name="email"/> <br>
                        Password : <input type="password" name="password"/> <br>
                        <input type="submit" value="S'inscrire"/>
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
