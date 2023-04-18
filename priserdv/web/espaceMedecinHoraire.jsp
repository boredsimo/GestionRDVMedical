<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
        <jsp:include page="espaceMedecinEnTete.jsp"/>
        <main class="page_principal">

            <section class="centrale">
                <%! Date today = new java.util.Date();%>
                
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <% today = new java.util.Date();%>
                            <% for (int i = 0; i < 7; i += 1) {%>
                            <th><fmt:formatDate pattern = "E M/d" value = "<%= today%>" /></th>
                                <% today = new java.util.Date((today.getTime()) + 60*60*24*1000);
                                }%>
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
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <%  unePlaceHoraire = new Date( unePlaceHoraire.getTime() + 1000*60*30) ;       }%>
                    </tbody>
                </table>

                <fmt:formatDate pattern = "yyyy-MM-dd" value = "${now}" />




            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
