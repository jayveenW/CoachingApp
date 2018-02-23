<%-- 
    Document   : AccueilClient
    Created on : 22 févr. 2018, 10:23:39
    Author     : NG71392
--%>

<%@page import="metier.Occseance"%>
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

<%
    Client client = (Client) session.getAttribute("client");
    String prenomCli = client.getPrenomClient();
    int idcli = client.getIdClient();

    /* Récupération des séances pour mon programme */
    ServiceAccueilClient sac = new ServiceAccueilClient();
    List<Occseance> seances = new ArrayList();
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
            <input type="hidden" value="<%= idcli%>" id="idcli"/>
            <% if (libProg == null) {
            %>
            <H2>Vous n'avez pas de programme</H2>
                <%
                } else {
                %>
            <H2>Votre programme <%= libProg%></H2>

            <b>Choisir une séance</b>
            <br/>
            Séance du : 
            <select class="form-control col" style="max-width: 135px;" id="lseance">
                <%
                    try {
                        for (Occseance s : seances) {
                            out.println("<option>" + s.getDateDebut() + "</option>");
                        }
                    } catch (Exception e) {
                        out.println("<p>" + e.getMessage() + "<p>");
                    }
                %>             
            </select>

            <input type="button" class="btn btn-primary" value="Afficher la séance"  onClick="l_maSeance()" />
            
                <div id="maseance" class="panel-body"></div>
                
            <%
                }
            %>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp"%>
