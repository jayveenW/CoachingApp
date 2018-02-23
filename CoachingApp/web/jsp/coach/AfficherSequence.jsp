<%@page import="java.util.List"%>
<%@page import="services.ServiceSequence"%>
<%@page import="metier.Sequence"%>
<%@include file="../includes/headerCoach.jsp" %>
<!DOCTYPE html>

<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
    Page d'affichage de la liste des séquences.
--%>

<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header">Liste des Sequences</h3>
    </div>
</div>
<div class="row">
    <!--<div class="col-lg-12">
        <div class="form-group">
            <label for="RechercheListe">Vous pouvez rechercher le programme grâce à son nom :</label>
            <input class="form-control" type="text" name="RecherchePrgm" onKeyUp="rechercherProgramme()" id="RechercheListe"/>
        </div>
    </div> -->
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="form-group">
            <a href="CreeSequence"><button class="btn btn-warning btn-circle"><i class="fa fa-plus"></i></button></a> : Ajouter une séquence 
        </div>
        <div class="table-responsive">
            <table class="table table-striped" id="tableauProgramme">       
                <thead>
                    <th></th>
                    <th>Nom de la sequence</th>
                    <th>Nombre répétition</th>
                    <th>Ordre</th>
                </thead>
                 <%
                        
                        
                    try { //Colonne vide servant a utiliser la checkbox en y mettant la valeur de l'id de la ligne cocher
                        for (Sequence seq : ServiceSequence.afficherSequence()) {//  out.println("<tr><td> " + s.getLibelleSeance() + "</td><td>" + s.getProfilSeance() + "</td>");
                            out.println("<tr><td><input type='checkbox' name='IDSeance' value='" + seq.getIdSequence() + "'></td><td>"+ seq.getLibelleSequence() + "</td><td>" + seq.getNbRepetitionSequence() +"</td><td>" + seq.getOrdreSequence()  + "</td></tr>");
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