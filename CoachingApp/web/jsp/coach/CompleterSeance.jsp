<%-- 
    Document   : CompleterSeance
    Created on : 22 févr. 2018, 09:21:46
    Author     : Many
--%>

<%@page import="metier.Exercice"%>
<%@page import="services.ServiceExercice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../includes/headerCoach.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Compléter cette séance</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-12 col-md-offset-0 col-sm-12 col-sm-0">
        <form action="ServletCompleterSeance" method="POST">
            <%
                //Permet l'affichage des trois formulaires.
                for (int i = 0; i < 5; i++) {
                    //Récupération des exercices grâce au serviceExercice. 
                    out.println("<div class=\"form-row\">");
                    out.println("<div class=\"form-group col-md-6\">");
                    out.println("<input type=\"hidden\" name=\"ordre\" value=\"" + i + "\">");
                    ServiceExercice se = new ServiceExercice();
                    out.println("<label>Choisissez l'exercice : </label>");
                    out.println("<select class=\"form-control\" name=\"exercice" + i + "\"><option></option>");
                    String select = "";
                    for (Exercice exo : se.getListeExercice()) {
                        select += "<option value=\"" + exo.getIdExercice() + "\">" + exo.getLibelleExercice() + "</option>";
                    }
                    out.println(select);
                    out.println("</select>");
                    //On demande pour chaque exercice le nombre de série et de répétition.
                    out.println("</div>");
                    out.println("<div class=\"form-group col-md-3\">");
                    String nbRepetition = "";
                    nbRepetition += "<input class=\"form-control\" type=\"number\" name=\"nbSerie" + i + "\" id=\"nbSerie\"/>";
                    out.println("<label>Nombre de série</label>");
                    out.println(nbRepetition);
                    out.println("</div>");
                    out.println("<div class=\" form-group col-md-3\">");
                    String nbSerie = "";
                    nbSerie += "<input class=\"form-control\" type=\"number\" name=\"nbRepetition" + i + "\" id=\"nbRepetition\"/><br/>";
                    out.println("<label>Nombre de répétition</label>");
                    out.println(nbSerie);
                    out.println("</div>");
                    out.println("</div>");
                }
            %>
            <div class="form-group">
                <input class="btn btn-warning" type="submit" name="Ajouter" id="Ajouter">
            </div>
        </form>
    </div>
</div>
<%@include file="../includes/footer.jsp" %>
