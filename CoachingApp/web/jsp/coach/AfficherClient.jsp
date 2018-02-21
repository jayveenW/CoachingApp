<%@page import="java.util.List"%>
<%@page import="services.ServicesClient"%>
<%@page import="metier.Client"%>
<%@include file="../includes/headerCoach.jsp" %>
<!DOCTYPE html>

<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header">Liste des clients</h3>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="form-group">
            <input class="btn btn-default right" type="submit" name="Ajouter" id="AjouterProgramme" value="Ajouter un client">
        </div>



        <div class="table-responsive">
            <table class="table table-striped" id="tableauProgramme">       
                <thead>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Mail</th>
                    <th>Statut</th>
                    <th>Type d'abonnement</th>
                    <th>Date de naissance</th>
                    <th>N° Telephone</th>
                    <th>Id sportif</th>
                </thead>
                <!-- à virer par la suite --> 
                <!-- Ajouter les liens pour accéder à modifier et supprimer --> 

                <%
                    try {
                        for (Client cli : ServicesClient.afficherClient()) {
                            out.println("<tr><td>" + cli.getNomCli() + "</td><td>" + cli.getPrenomClient() + "</td>"
                                    + "<td>" + cli.getMailClient() + "</td><td>" + cli.getStatutClient() + "</td>"
                                    + "<td>" + cli.getTypeAbonnementClient() + "</td><td>" + cli.getDateNaissanceClient() + "</td>"
                                    + "<td>" + cli.getTelephoneClient() + "</td><td>" + cli.getIdProfilSportif() + "</td></tr>");
                        }
                    } catch (Exception e) {
                        out.println("<p>" + e.getMessage() + "<p>");
                    }
                %>
                <!-- A virer jusque là --> 
            </table>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp" %>