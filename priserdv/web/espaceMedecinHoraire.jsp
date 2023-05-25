<%@page import="java.util.Locale"%>
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
        <title>Espace Medecin - Mon Horaire</title>
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
                <div style='text-align: center'><%= request.getAttribute("message")%></div> 
                    <%}%>
                <form action="EspaceMedecinHoraireController" method="post" id="datePicker" style="margin-left: 45%;">
                    Jour : <input type="date" id="dateHoraire" lang="fr-CA" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= today%>" />" name="dateHoraire" onchange="submitDatePicker()"/> <br>
                    <!--<input type="submit" value="Afficher"/>-->
                </form>



                <div class="grid-container">

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
                                <tbody>
                                    <%  Calendar calendrier = Calendar.getInstance();
                                        calendrier.set(Calendar.YEAR + 1900, Calendar.MONTH, Calendar.DATE, 6, 0);
                                        Date unePlaceHoraire = calendrier.getTime();

                                        String pattern = "H:mm";
                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                        List<Rendezvous> listeRendezvous = (List<Rendezvous>) request.getAttribute("listeRendezvous");

                                        for (int i = 0; i < 28; i += 1) {%>
                                    <tr>
                                        <th scope="row"><strong><fmt:formatDate pattern = "H:mm" value = "<%= unePlaceHoraire%>" /></strong></th>

                                        <%  String chainePlaceHoraire = simpleDateFormat.format(unePlaceHoraire);
                                            boolean RDVexiste = false;

                                            for (Rendezvous unRDV : listeRendezvous) {
                                                String chaineHeureRDV = simpleDateFormat.format(unRDV.getHeure());
                                                if (chaineHeureRDV.equals(chainePlaceHoraire)) {
                                                    RDVexiste = true;

                                                    if (unRDV.getPatient_id() == 1) {
                                                        //class="bg-info"
%> 
                                        <td class="bg-info">
                                            <!-- Affichage d'un rendez-vous attribué a aucun patient (patient admin id=1)-->
                                            <div style="display: inline;">
                                                <span>Rendez-vous vide.</span>
                                                <!-- Form de suppression de rendez-vous-->

                                                <span>Attribuer ce rendez-vous à :</span>
                                                <form action="EspaceMedecinHoraireAttributionController" method="post" style="display: inline;">
                                                    <input type="hidden" id="rendezvousID" value="<%=unRDV.getId()%>" name="rendezvousID">
                                                    <input type="hidden" id="dateHoraire" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= today%>" />" name="dateHoraire" />
                                                    <input type="hidden" id="dateHeure" value="<fmt:formatDate pattern='yyyy-MM-dd' value ='<%= today%>' /><fmt:formatDate pattern = "-HH-mm" value = "<%= unePlaceHoraire%>" />" name="dateHeure" />
                                                    <input type="text" id="patientID" value="" placeholder="patient ID" name="patientID" />
                                                    <button class="btn btn-success" type="submit" >Attribuer</button>
                                                </form>
                                                    
                                                <form action="EspaceMedecinHoraireDeleteController" method="post" style="float:right;display: inline;" onsubmit="return confirm('Voulez-vous vraiment supprimer ce rendez-vous?');">
                                                    <input type="hidden" id="rendezvousID" value="<%=unRDV.getId()%>" name="rendezvousID">
                                                    <input type="hidden" id="dateHoraire" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= today%>" />" name="dateHoraire" />
                                                    <input type="hidden" id="dateHeure" value="<fmt:formatDate pattern='yyyy-MM-dd' value ='<%= today%>' /><fmt:formatDate pattern = "-HH-mm" value = "<%= unePlaceHoraire%>" />" name="dateHeure" />
                                                    <button class="btn btn-danger" type="submit" >Supprimer</button>
                                                </form>

                                            </div>
                                        </td>
                                        <%

                                        } else {
                                            //class="bg-success"
%>
                                        <td class="bg-success">
                                            <!-- Affichage d'un rendez-vous attribué a un patient-->
                                            <div style="display: inline;">
                                                <span>Patient <%=  unRDV.getPatient_id()%> : </span>
                                                <form action="EspaceMedecinHoraireModifierController" method="post" >
                                                    <input type="hidden" id="rendezvousID" value="<%=unRDV.getId()%>" name="rendezvousID">
                                                    <input type="hidden" id="dateHoraire" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= today%>" />" name="dateHoraire" />
                                                    <input type="hidden" id="dateHeure" value="<fmt:formatDate pattern='yyyy-MM-dd' value ='<%= today%>' /><fmt:formatDate pattern = "-HH-mm" value = "<%= unePlaceHoraire%>" />" name="dateHeure" />
                                                    <textarea id="raison" name="raison" rows="2" cols="25" placeholder=" raison"maxlength="45"><%if (unRDV.getRaison() != null) {%><%=unRDV.getRaison()%><%}%></textarea>
                                                    <textarea id="precision" name="precision" rows="2" cols="50" placeholder=" precision"maxlength="100"><%if (unRDV.getPrecision() != null) {%><%=unRDV.getPrecision()%><%}%></textarea>
                                                    <button class="btn btn-success" type="submit" >Modifier</button>
                                                </form>
                                                
                                                <form action="EspaceMedecinHoraireDeleteController" method="post" style="float:right;display: inline;" onsubmit="return confirm('Voulez-vous vraiment supprimer ce rendez-vous?');">
                                                    <input type="hidden" id="rendezvousID" value="<%=unRDV.getId()%>" name="rendezvousID">
                                                    <input type="hidden" id="dateHoraire" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= today%>" />" name="dateHoraire" />
                                                    <input type="hidden" id="dateHeure" value="<fmt:formatDate pattern='yyyy-MM-dd' value ='<%= today%>' /><fmt:formatDate pattern = "-HH-mm" value = "<%= unePlaceHoraire%>" />" name="dateHeure" />
                                                    <button type="submit" class="btn btn-danger">Supprimer</button>
                                                    <!--<button class="open-button btn btn-secondary" onclick="openForm()">Consulter</button>-->
                                                </form>
                                            </div>

                                        </td>
                                        <%}
                                                }
                                            }

                                            if (!RDVexiste) {%>
                                        <td>
                                            <!-- Affichage du form pour creer un rendez vous si aucun existe.-->
                                            <form action="EspcaeMedecinCreerRDVController" method="post">
                                                <input type="hidden" id="dateHoraire" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "<%= today%>" />" name="dateHoraire" />
                                                <input type="hidden" id="dateHeure" value="<fmt:formatDate pattern='yyyy-MM-dd' value ='<%= today%>' /><fmt:formatDate pattern = "-HH-mm" value = "<%= unePlaceHoraire%>" />" name="dateHeure" />
                                                <button type="submit" class="btn btn-primary">Ajouter</button>
                                            </form>
                                        </td>
                                        <%    }%>
                                    </tr>
                                    <%  unePlaceHoraire = new Date(unePlaceHoraire.getTime() + 1000 * 60 * 30);
                                        }%>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="grid-child">
                        <!-- Form de modification de rendez-vous  (est cache par default)-->
                        <div class="form-popup" id="myForm">
                            <form action="" class="form-container">
                                <h1>Modification</h1>

                                <label for="email"><b>Email</b></label>
                                <input type="text" placeholder="Enter Email" name="email" required>

                                <label for="psw"><b>Password</b></label>
                                <input type="password" placeholder="Enter Password" name="psw" required>

                                <button type="submit" class="btn">Modifier</button>
                                <button type="button" class="btn cancel" onclick="closeForm()">Annuler</button>
                            </form>
                        </div>
                    </div>
                </div> 

                <script>
                    function submitDatePicker() {
                        document.getElementById("datePicker").submit();
                    }
                    function openForm() {
                        document.getElementById("myForm").style.display = "grid";
                    }

                    function closeForm() {
                        document.getElementById("myForm").style.display = "none";
                    }
                </script>

            </section>

        </main>

        <jsp:include page="pied.jsp"/>    

    </body>
</html>
