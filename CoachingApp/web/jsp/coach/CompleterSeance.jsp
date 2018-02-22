<%-- 
    Document   : CompleterSeance
    Created on : 22 févr. 2018, 09:21:46
    Author     : Many
--%>

<%@page import="metier.Exercice"%>
<%@page import="services.ServiceExercice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compléter cette séance</title>
    </head>
    <body>
        <h1>Compléter cette séance</h1>
            <form>
            <%
                for(int i=0;i<7;i++)
                {
                    ServiceExercice se = new ServiceExercice();
                    out.println("<select name=\"Exercice\">");
                    String select = "";
                    for (Exercice exo : se.getListeExercice()){
                        select += "<option value=\"" + exo.getLibelleExercice() + "\">" +exo.getLibelleExercice() + "</option>";
                    }
                    out.println(select);
                    out.println("</select>");
                
                    String nbRepetition = "";
                    nbRepetition += "<input type=\"number\" name=\"nbRepetition\" id=\"nbRepetition\"/>";
                    out.println(nbRepetition);
                    String nbSerie = "";
                    nbSerie += "<input type=\"number\" name=\"nbSerie\" id=\"nbSerie\"/><br/>";
                    out.println(nbSerie);
                }
            %>
                <input type="submit" name="Ajouter" id="Ajouter">
            </form>
        
        
    </body>
</html>