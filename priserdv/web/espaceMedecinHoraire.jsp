<%@page import="com.crosemont.priserdv.model.entities.Rendezvous"%>
<%@page import="java.util.List"%>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="espaceMedecinEnTete.jsp"/>
        <main class="page_principal">

            <section class="centrale">
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

                <% if (request.getAttribute("message") != null) {%>
                <marquee><%= request.getAttribute("message")%></marquee> 
                    <%}%>
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

                            String pattern = "H:mm";
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                            List<Rendezvous> listeRendezvous = (List<Rendezvous>) request.getAttribute("listeRendezvous");

                            for (int i = 0; i < 30; i += 1) {%>
                        <tr>
                            <td><strong><fmt:formatDate pattern = "H:mm" value = "<%= unePlaceHoraire%>" /></strong></td>

                            <%  String chainePlaceHoraire = simpleDateFormat.format(unePlaceHoraire);
                                boolean RDVexiste = false;

                                for (Rendezvous unRDV : listeRendezvous) {
                                    String chaineHeureRDV = simpleDateFormat.format(unRDV.getHeure());
                                    if (chaineHeureRDV.equals(chainePlaceHoraire)) {
                                        RDVexiste = true;

                                        if (unRDV.getPatient_id() == 1) {
                            %>
                            <td class="bg-info">
                                Rendez-vous vide.
                            </td>
                            <%

                            } else {
                            %>
                            <td class="bg-success">
                                Patient id: <%=  unRDV.getPatient_id()%>
                            </td>
                            <%      }
                                    }
                                }

                                if (!RDVexiste) {%>
                            <td>
                                <form action="EspcaeMedecinCreerRDVController" method="post">

                                    <input type="hidden" id="dateHoraire" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= today%>" />" name="dateHoraire" />
                                    <input type="hidden" id="dateHeure" value="<fmt:formatDate pattern='yyyy-MM-dd' value ='<%= today%>' /><fmt:formatDate pattern = "-HH-mm" value = "<%= unePlaceHoraire%>" />" name="dateHeure" />
                                    <input style ="width:100%;" type="submit" value="Ajouter"/>
                                </form>
                            </td>
                            <%    }%>





                        </tr>
                        <%  unePlaceHoraire = new Date(unePlaceHoraire.getTime() + 1000 * 60 * 30);
                            }%>
                    </tbody>
                </table>






            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
