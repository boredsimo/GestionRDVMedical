<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%-- 
    Author     : Giguere Julien
--%>
<html>
    <head>
        <title>Espace Medecin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
    </head>
    <body>
        <jsp:include page="espaceMedecinEnTete.jsp"/>
        <main class="page_principal">

            <section class="centrale">
                <%! Date today = new Date();%>
                <%
                    if (request.getAttribute("date") != null) {
                        today = (Date)request.getAttribute("date");
                    } else {
                        today = new Date();
                    }
                %>
                
                
                
             
                
                
                
                
                
                <%! DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate uneLocalDate = today.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
                    String date = uneLocalDate.format(formatter);%>
                <form action="EspaceMedecinHoraireController" method="post">
                    Jour : <input type="date" id="dateHoraire" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= today%>" />" name="dateHoraire" /> <br>
                    <input type="submit" value="Afficher"/>
                </form>


                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th><fmt:formatDate pattern = "E d MMMMMMMM yyyy" value = "<%= today%>" /></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  Calendar calendrier = Calendar.getInstance();
                            calendrier.set(Calendar.YEAR + 1900, Calendar.MONTH, Calendar.DATE, 6, 0);
                            Date unePlaceHoraire = calendrier.getTime();
                            for (int i = 0; i < 30; i += 1) {%>
                        <tr>
                            <td><strong><fmt:formatDate pattern = "H:mm" value = "<%= unePlaceHoraire%>" /></strong></td>
                            <td></td>
                        </tr>
                        <%  unePlaceHoraire = new Date(unePlaceHoraire.getTime() + 1000 * 60 * 30);
                            }%>
                    </tbody>
                </table>

                <fmt:formatDate pattern = "yyyy-MM-dd" value = "${now}" />




            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
