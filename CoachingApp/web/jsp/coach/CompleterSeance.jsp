<%-- 
    Document   : CompleterSeance
    Created on : 22 févr. 2018, 09:21:46
    Author     : Many
--%>

<%@page import="metier.Exercice"%>
<%@page import="services.ServiceExercice"%>
<%@include file="../includes/headerCoach.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compléter cette séance</title>
    </head>
    <body>
        <h1>Compléter cette séance</h1>
            <form action="ServletCompleterSeance" method="POST">
            <%
                out.println(session.getAttribute("idSeance"));
                for(int i=0;i<7;i++)
                {
                    out.println("<div class=\"form-row\">");
                    out.println("<div class=\"form-group col-md-6\">");
                    out.println("<input type=\"hidden\" name=\"ordre\" value=\"" + i + "\">");
                    ServiceExercice se = new ServiceExercice();
                    out.println("<label>Choisissez l'exercice : </label>");
                    out.println("<select class=\"form-control\" name=\"exercice"+ i +"\"><option></option>");
                    String select = "";
                    for (Exercice exo : se.getListeExercice()){
                        select += "<option value=\"" + exo.getIdExercice() + "\">" +exo.getLibelleExercice() + "</option>";
                    }
                    out.println(select);
                    out.println("</select>");
                    out.println("</div>");
                    out.println("<div class=\"form-group col-md-3\">");
                    String nbRepetition = "";
                    nbRepetition += "<input class=\"form-control\" type=\"number\" name=\"nbSerie"+ i +"\" id=\"nbSerie\"/>";
                    out.println("<label>Nombre de série</label>");
                    out.println(nbRepetition);
                    out.println("</div>");
                    out.println("<div class=\" form-group col-md-3\">");
                    String nbSerie = "";
                    nbSerie += "<input class=\"form-control\" type=\"number\" name=\"nbRepetition"+ i +"\" id=\"nbRepetition\"/><br/>";
                    out.println("<label>Nombre de répétition</label>");
                    out.println(nbSerie);
                    out.println("</div>");
                    out.println("</div>");
                }
            %>
                
                <input type="submit" name="Ajouter" id="Ajouter">
            </form>
        
        
    </body>
</html>
<%@include file="../includes/footer.jsp" %>