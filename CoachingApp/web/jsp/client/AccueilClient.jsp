<%-- 
    Document   : AccueilClient
    Created on : 22 févr. 2018, 10:23:39
    Author     : NG71392
--%>

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
    /* Récupération de l'objet depuis la session */
    Role role = (Role) session.getAttribute("role");
    String libRole = role.getLibelleRole();

    Client client = (Client) session.getAttribute("client");
    String prenomCli = client.getPrenomClient();
    
    /* Récupération des séances pour mon programme */
    ServiceAccueilClient sac = new ServiceAccueilClient();
    List<Seance> seances = new ArrayList<>();
    seances = sac.getSeances(client);
    
    /* Récupération du nom de mon programme */
    Programme prog = sac.getProgramme(client);
    String libProg = prog.getLibelleProgramme();
%>

<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Bonjour <%= prenomCli %></h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">

            <H2>Votre programme <%= libProg %></H2>

            <b>Choisir une séance</b>
            <br/>
            <select id="lseance" onChange="l_seances()">
                <option>--</option>
            </select>
            <input type="button" value="Afficher la séance" onclick="l_maSeance()" />



            <div id="lcitations">

            </div>



        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>
