<%-- 
    Document   : AccueilClient
    Created on : 22 févr. 2018, 10:23:39
    Author     : NG71392
--%>

<%@page import="metier.Composer"%>
<%@page import="metier.Programme"%>
<%@page import="java.util.ArrayList"%>
<%@page import="metier.Seance"%>
<%@page import="java.util.List"%>
<%@page import="services.ServiceAccueilClient"%>
<%@page import="metier.Client"%>
<%@page import="metier.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerClient.jsp"%>
<script type="text/JavaScript" src="../javascript/Ajax.js"></script>
<%

    Client client = (Client) session.getAttribute("client");
    String prenomCli = client.getPrenomClient();

    /* Récupération des séances pour mon programme */
    ServiceAccueilClient sac = new ServiceAccueilClient();
    List<Seance> seances = new ArrayList();
    seances = sac.getSeances(client);

    /* Récupération du nom de mon programme */
    Programme prog = sac.getProgramme(client);
    String libProg = prog.getLibelleProgramme();


%>

<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Bonjour <%= prenomCli%></h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">

            <% if (libProg == null) {
            %>
            <H2>Vous n'avez pas de programme</H2>
                <%
                } else {
                %>
            <H2>Votre programme <%= libProg%></H2>

            <b>Choisir une séance</b>
            <br/>

            <select id="lseance">
                <%
                    try {
                        for (Seance s : seances) {
                            Composer c = sac.getComposer(s);
                            // c.getOccseance().getDateDebut();
                            out.println("<option> Séance du " + s.getLibelleSeance() + "</option>");
                        }
                    } catch (Exception e) {
                        out.println("<p>" + e.getMessage() + "<p>");
                    }
                %> 
            </select>

            <input type="button" value="Afficher la séance" onclick="l_maSeance()" />

            <div id="maseance">

            </div>
            <%
                }
            %>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>
