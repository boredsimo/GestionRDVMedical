<%@page import="com.crosemont.priserdv.model.entities.Medecin"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.crosemont.priserdv.model.entities.Rendezvous"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.crosemont.priserdv.model.entities.Clinique"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>

<% List<Rendezvous> list= (List<Rendezvous>)session.getAttribute("listDispo");
%>

<html>
    <head>
        <title>Espace Patient</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <header>
            
            <div class="container-fluid" style="background-color: white; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
                                    rgba(0, 0, 0, 0.19); border-radius: 0%; ">
                <nav>
                    <ul>
                        <img src="images/logo.png" alt="Logo" style="border-radius:0%;" width="47px" height="47px">
                        <li style="box-sizing: border-box;  border-radius:0%;display: block;"><a href="espacePatient.jsp" class="active">Mes Rendez-vous</a></li>
                        <li style="box-sizing: border-box;  border-radius:0%;display: block;"><a href="">Prendre un Rendez-vous</a></li>
                        <li style="box-sizing: border-box;  border-radius:0%; display: block;"><a href="comptepatient">Mon Compte</a></li>
                        <li style="box-sizing: border-box;  border-radius:0%;display: block;"><a href="deconnexionController">Deconnexion</a></li>
                        <img id="rosemont" src="images/rosemont.png" alt="rosemont" />
                    </ul>
                </nav>

            </div>
        </header>
        <main class="page_principal">
            
            <%! Date today = new Date();%>
                <%
                    if (request.getAttribute("date") != null) {
                        today = (Date) request.getAttribute("date");
                    }
                %>

                <%! DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate uneLocalDate = today.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    String date = uneLocalDate.format(formatter);%>


            <% if (session.getAttribute("nom") != null) {%>
            <marquee> Bienvenue dans votre espace patient Mr/Mme <%= session.getAttribute("nom")%>.</marquee> 
                <%} else {%>
            <marquee> Bienvenue dans votre espace patient.</marquee>
                <%}%>

            <section class="centrale">
                
                <% if (session.getAttribute("nom") != null) {%>
            <h1 style="color: black;"> Bienvenue dans votre espace patient Mr/Mme <%= session.getAttribute("nom")%>.</h1> 
                <%} else {%>
                <h1 style="color: black"> Bienvenue dans votre espace patient.</h1>
                <%}%>
                
                <div class="grid-child">
                        <div>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col"></th>
                                        <%!  Locale locale = new Locale("fr", "FR"); 
                                            SimpleDateFormat sdf = new SimpleDateFormat("E d MMMMMMMM yyyy", locale);  %> 
                                        <th scope="col"><%= sdf.format(today)%></th>
                                    </tr>
                                </thead>
                                
                                <table class="table table-striped">
                                    <tr>
                                        <th>IdRdv</th>
                                        <th>HeureRdv</th>
                                        <th>Status</th>
                                        <th>Reserver maintenant</th>
                                        
                                    </tr>
                                    
                                    
                                    
                                    <% for(Rendezvous rdv:list){%>
                                    <tr>
                                        
                                        <td> <%= rdv.getId()  %></td>
                                        <td> <fmt:formatDate pattern = "H:mm" value = "<%= rdv.getHeure()%>" />  </td>
                                        <td>Disponible</td>
                                        <td>
                                            <form action="espcaceClientReserverHoraire" method="post" style="display: inline;">
                                                    <input type="hidden" id="rendezvousID" value="<%=rdv.getId()%>" name="rendezvousID">
                                                    
                                                    <input type="text" id="patientID" value="" placeholder="patient ID" name="patientID" />
                                                    <button class="btn btn-success" type="submit" >Attribuer</button>
                                                </form>
                                            
                                            
                                            
                                            
                                        
                                        
                                        
                                        
                                        </td>
                                        
                                    </tr>
                                    <% } %>
                                </table> 
                                    
                                    
                                    
                                    
                                </tbody>
                
                
                
                
                </div>

            </section>

        </main>
                

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
