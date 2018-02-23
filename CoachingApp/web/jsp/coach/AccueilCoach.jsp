<%-- 
    Document   : AccueilCoach
    Created on : 22 févr. 2018, 10:28:36
    Author     : NG71392
--%>

<%@page import="metier.Coach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerCoach.jsp"%>

<%
    /* Récupération de l'objet depuis la session */
    Coach coach = (Coach) session.getAttribute("coach");
    String prenomCoach = coach.getPrenomCoach();
%>

<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Bonjour <%= prenomCoach%></h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">
            <H2>Bienvenue sur votre espace coach</H2>
            <p>Vous trouverez dans le menu latéral gauche les options concernant</p>
            <ul>
                <li>Vos clients</li>
                    <li>Les exercices que vous proposez</li>
                <li>Les séances</li>
                <li>Les programmes</li>
                <li>Les bilans de vos clients</li>
            </ul>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>
