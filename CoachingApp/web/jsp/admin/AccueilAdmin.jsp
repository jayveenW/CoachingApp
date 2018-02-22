<%-- 
    Document   : AccueilAdmin
    Created on : 22 févr. 2018, 10:10:22
    Author     : NG71392
--%>

<%@page import="metier.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerAdmin.jsp"%>
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Bonjour</h1>
    </div>
</div>

<%
    /* Récupération de l'objet depuis la session */
    Role role = (Role) session.getAttribute("role");
    String libRole = role.getLibelleRole();
%>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">

            <H2>Bienvenue sur l'espace <%= libRole %></H2>
            <p></p>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>
