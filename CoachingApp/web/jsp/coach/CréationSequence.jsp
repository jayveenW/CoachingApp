<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
    Page de création de séquence en lui affectant des séances.
--%>

<%@page import="services.ServiceSeance"%>
<%@page import="metier.Seance"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerCoach.jsp"%>
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Création d'une séquence</h1>
    </div>
</div>


<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">

            <p>Tous les champs sont obligatoires</p>
            <form method="Post" action="AjoutSequence">
                <div class="form-group">                                                        
                    <label for="Nom">Nom séquence :</label> 
                    <input type="text" class="form-control" name="Libelle" id="Nom" required>
                </div>
                <div class="form-group">
                    <label for="Nom">Nombre de répétition :</label> 
                    <input type="text" class="form-control" name="NbRepet" id="Nom" required>
                </div>
                <div class="form-group">
                    <label for="Nom">Ordre Séquence :</label> 
                    <input type="text" class="form-control" name="OrdreSeq" id="Nom" required>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped" id="tableauProgramme">       
                        <thead>
                        <th></th>
                        <th>Libelle</th>
                        <th>Profil</th>
                        </thead>
                        <p>Choisissez les séances à affecter</p>
                        <%
                            try {
                                for (Seance s : ServiceSeance.afficherSeance()) {
                                    out.println("<tr><td><input type='checkbox' name='IDSeance' value='" + s.getIdSeance() + "'></td><td>" + s.getLibelleSeance() + "</td><td>" + s.getProfilSeance() + "</td></tr>");
                                }
                            } catch (Exception e) {
                                out.println("<p>" + e.getMessage() + "<p>");
                            }
                        %>
                    </table>
                </div> 

            </form>
            <div class="form-group">
                <button type="submit" class="btn btn-warning pull-right">Valider</button>
                <a href="AfficherSequence"><button class="btn btn-default">Retour</button></a>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>