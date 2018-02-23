<%@page import="services.ServiceSeance"%>
<%@page import="java.util.List"%>
<%@page import="metier.Seance"%>
<%@include file="../includes/headerCoach.jsp" %>
<!DOCTYPE html>

<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
    Page d'affichage de la liste des séances.
--%>

<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header">Liste des séances</h3>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="form-group">
            <input class="btn btn-default right" type="submit" name="Ajouter" id="AjouterProgramme" value="Ajouter une Séance">
        </div>



        <div class="table-responsive">
            <table class="table table-striped" id="tableauProgramme">       
                <thead>
                    <th>Libelle</th>
                    <th>Profil</th>
                </thead>
               

                <%
                    try {
                        for (Seance s : ServiceSeance.afficherSeance()) {
                            out.println("<tr><td>" + s.getLibelleSeance() + "</td><td>" + s.getProfilSeance() + "</td>");
                        }
                    } catch (Exception e) {
                        out.println("<p>" + e.getMessage() + "<p>");
                    }
                %>
               
            </table>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp" %>