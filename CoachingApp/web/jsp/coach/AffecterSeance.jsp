<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
    Page d'affectation de séance à une séquence.
--%>

<%@page import="java.util.List"%>
<%@page import="services.ServiceSeance"%>
<%@page import="metier.Seance"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerAdmin.jsp"%>
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Affecter des séances</h1>
    </div>
</div>
<%  // On récupère en variable de session les infos de la séance et de la séquence qque l'on réutilise plus tard.
  int id = (Integer)request.getSession().getAttribute("IdSequence");
   List<Seance> l_Seance = (List<Seance>)request.getSession().getAttribute("IdSeances");
%>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">

            <p>Tous les champs sont obligatoires</p>
            
            <form method="Post" action="AffectationSeance">
                <% // Boucle for qui vas répéter un formulaire autant de fois qu'il y a de séance précédement selectionné
                   // en gardant en ID de la séquence précedement ajouter et le nom de chaques séance par formulaire
                    for (Seance seance : l_Seance){
                %>
                <div class="form-group" action="">                                                        
                    <label for="Nom">Id Séquence:</label> 
                    <input type="text" class="form-control" name="IDSequence" id="Nom" value="<%=id%>" required>
                </div>
                <div class="form-group" action="">                                                        
                    <label for="Nom">Nom séance :</label> 
                    <input type="text" class="form-control" name="LibelleSeance" value="<%=seance.getLibelleSeance()%>" id="Nom" required>
                </div>
                 <div class="form-group" action="">                                                        
                   <input type="hidden" class="form-control" name="IDSeance" value="<%=seance.getIdSeance()%>" id="Nom" required> 
                </div>
                <div class="form-group">
                    <label for="Nom">Nombre de répétition :</label> 
                    <input type="text" class="form-control" name="NbRepet" id="Nom" required>
                </div>
                <div class="form-group">
                    <label for="Nom">Ordre Séquence :</label> 
                    <input type="text" class="form-control" name="OrdreSeance" id="Nom" required>
                </div>
                <div class="form-group">
                    <label for="Nom">Numéros de semaine :</label> 
                    <input type="text" class="form-control" name="NumSemaine" id="Nom" required>
                </div>
                <div class="form-group">
                    <label for="Nom">Annee :</label> 
                    <input type="text" class="form-control" name="Annee" id="Nom" required>
                </div>
                <hr>
                
                <% } %>
                
                <div class="table-responsive">
            
        </div> 
                <div class="form-group">
                    <button type="submit" class="btn btn-warning pull-right">Valider</button>
                    <button class="btn btn-default" thref="Acceuil">Retour</a>
                </div>
            </form>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>