<%-- 
    Document   : AccueilCoach
    Created on : 22 févr. 2018, 10:28:36
    Author     : NG71392
--%>

<%@page import="metier.Coach"%>
<%@page import="metier.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerCoach.jsp"%>

<%
    /* Récupération de l'objet depuis la session */
    Role role = (Role) session.getAttribute("role");
    String libRole = role.getLibelleRole();
    
    Coach coach = (Coach) session.getAttribute("client");
    String prenomCoach = coach.getPrenomCoach();
%>

<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Bonjour <%= prenomCoach %></h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">

            <H2>Bienvenue sur votre espace <%= libRole %></H2>
            <p></p>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>