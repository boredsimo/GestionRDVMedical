<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Espace Medecin</title>
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
                                href="">Dossier de patient
                            </a>
                        </li>
                        <li>
                            <a
                                href="">Mon horaire
                            </a>
                        </li>
                        <li>
                            <a
                                href="">Mon Compte
                            </a>
                        </li>
                        <li>
                            <a
                                href="index.jsp">Deconnexion
                            </a>
                        </li>
                    </ul>
                </nav>

            </div>
        </header>
        <main class="page_principal">


            <% if (session.getAttribute("nom") != null) {%>
            <marquee> Bienvenue dans votre espace medecin Mr/Mme <%= session.getAttribute("nom")%>.</marquee> 
                <%} else {%>
            <marquee> Bienvenue dans votre espace medecin.</marquee>
                <%}%>

            <section class="centrale">

            </section>

        </main>

        <footer>

            <div class="foot">
                Clinique Médicale du Collège de Rosemont<br>
                6400 16e Avenue, Montréal, QC H1X 2S9
                <p id="copyright">© 2023 Collège de Rosemont  Cours : Applications Web 2 – Tous droits réservés</p>
            </div>
        </footer>      

    </body>
</html>
