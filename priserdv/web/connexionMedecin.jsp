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
  <!-- Email input -->
  <div class="form-outline mb-4">
    <input type="email" id="form2Example1" class="form-control" />
    <label class="form-label" for="form2Example1">Email address</label>
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
    <input type="password" id="form2Example2" class="form-control" />
    <label class="form-label" for="form2Example2">Password</label>
  </div>

  <!-- 2 column grid layout for inline styling -->
  <div class="row mb-4">
    <div class="col d-flex justify-content-center">
      <!-- Checkbox -->
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"> Remember me </label>
      </div>
    </div>

    <div class="col">
      <!-- Simple link -->
      <a href="#!">Forgot password?</a>
    </div>
  </div>

  <!-- Submit button -->
  <button type="button" class="btn btn-primary btn-block mb-4">Sign in</button>

  <!-- Register buttons -->
  <div class="text-center">
    <p>Not a member? <a href="#!">Register</a></p>
    <p>or sign up with:</p>
    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-facebook-f"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-google"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-twitter"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-github"></i>
    </button>
  </div>
</form>
                        </div>

        </main>

        <jsp:include page="pied.jsp"/>     

    </body>
</html>
