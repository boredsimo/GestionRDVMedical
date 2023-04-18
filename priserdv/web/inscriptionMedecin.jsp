<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Inscription - Medecin</title>
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

                <h2>Inscription - Medecin</h2>
              
                <div>
                    <form action="" method="post">
                        Nom : <input type="text" name="nom" /> <br>
                        Prénom : <input type="text" name="prenom" /> <br>
                        Spécialité : <input type="text" name="Specialite" /> <br>
                        Numéro de Medecin : <input type="text" name="numMedecin" /> <br>
                        Attentes en matière de facturation : <input type="text" name="attente" /> <br>
                        Numéro de téléphone : <input type="text" name="numTel" /> <br>
                        Clinique : <input type="text" name="numClinique" /> <br>
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
