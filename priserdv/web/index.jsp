<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<html>
    <head>
        <title>Accueil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
    </head>
    <body>

        <jsp:include page="enTete.jsp"/>
        <main class="page_principal">
                
                
                <% if (request.getAttribute("deconnecte") != null) {%>
            <marquee><%= request.getAttribute("deconnecte")%></marquee> 
                <%} else {%>
            <marquee> Bienvenue sur le site web de la Clinique Médicale du Collège de Rosemont.</marquee>
                <%}%>
                
                
            

            <section class="centrale">
                
                
                <div style=" display: flex; align-items: center; justify-content: center;height:700px ; text-align: center;">
                <div class="content display-container" style="background-color: rgb(40, 92, 164);justify-content: center; align-items: center; text-align: center;">
                    <img class="mySlides" src="images/clinique1.jpeg" style="width: 700px;height:500px">
                    <img class="mySlides" src="images/clinique2.jpeg" style="width: 700px;height:500px ">
                    <img class="mySlides" src="images/medecin1.jpeg" style="width: 700px;height:500px ">
                    <img class="mySlides" src="images/rendezvous.png" style="width: 700px;height:500px ">
                    <h3 class="myh3">Bienvenue au portail des Cliniques Rosemont!</h3>
                    <h3 class="myh3">Choisissez le centre qui vous est le plus pratiques!</h3>
                    <h3 class="myh3">Prenez le rendez-vous avec un medecin qui vous convient!</h3>
                    <h3 class="myh3">Recevez la confirmation de votre rendez-vous!</h3>

  <button class="button black display-left" onclick="plusDivs(-1)">&#10094;</button>
  <button class="button black display-right" onclick="plusDivs(1)">&#10095;</button>
</div>
                    </div>

<script>
var slideIndex = 1;
var h3Index = 1;
showDivs(slideIndex);
showh3(h3Index)

function plusDivs(n) {
  showDivs(slideIndex += n);
  showh3(h3Index += n)
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}

function showh3(n) {
  var i;
  var x = document.getElementsByClassName("myh3");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>
            </section>
            
            <br>
            <br>
            <br>
            <br>
            <br>
            

        </main>

        <jsp:include page="pied.jsp"/>

    </body>
</html>
