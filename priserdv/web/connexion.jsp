<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Connexion</title>
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

                <h2>Connexion</h2>
                <!-- Tab links -->
                <div class="tab">
                    <button class="tablinks" onclick="openInscriptionPage(event, 'Client')" id="defaultOpen">Client</button>
                    <button class="tablinks" onclick="openInscriptionPage(event, 'Medecin')">Medecin</button>
                    <button class="tablinks" onclick="openInscriptionPage(event, 'Clinique')">Clinique</button>
                </div>

                <!-- Tab content Client -->
                <div id="Client" class="tabcontent">
                    <form action="" method="post">
                        Email : <input type="email" name="email"/> <br>
                        Password : <input type="password" name="password"/> <br>
                        <input type="submit" value="Se connecter en tant que Client"/>
                    </form>
                </div>

                <!-- Tab content Medecin -->
                <div id="Medecin" class="tabcontent">
                    <form action="" method="post">
                        Email : <input type="email" name="email"/> <br>
                        Password : <input type="password" name="password"/> <br>
                        <input type="submit" value="Se connecter en tant que Medecin"/>
                    </form>
                </div>

                <!-- Tab content Clinique -->
                <div id="Clinique" class="tabcontent">
                    <form action="" method="post">
                        Email : <input type="email" name="email"/> <br>
                        Password : <input type="password" name="password"/> <br>
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
