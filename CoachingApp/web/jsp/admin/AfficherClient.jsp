<%@page import="java.util.List"%>
<%@page import="services.ServicesClient"%>
<%@page import="metier.Client"%>
<%@include file="../includes/headerAdmin.jsp" %>
<!DOCTYPE html>


<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
    Page d'affichage de la liste des clients.
--%>

<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header">Liste des clients</h3>
    </div>
</div>

<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <a class="btn btn-default pull-right" href="AjouterClient">Ajouter un client</a>
    </div>
</div>


<div class="row">
    <div class="col-lg-8 col-lg-offset-2">
        <div class="table-responsive">
            <table class="table table-striped" id="tableauProgramme">       
                <thead>
                <th>Statut</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Id sportif</th>
                </thead>
                
                <%
                    try {
                        for (Client cli : ServicesClient.afficherClient()) {
                            String statut = "";
                            String tooltip = "";
                            if (cli.getStatutClient() != null) {
                                if (cli.getStatutClient().equals("Valide")) {
                                    statut = "fa-check";
                                    tooltip = "Validé";
                                    statut += " text-success";
                                } else if (cli.getStatutClient().equals("En attente")) {
                                    statut = "fa-clock-o";
                                    statut += " text-info";
                                    tooltip = "En attente";
                                } else if (cli.getStatutClient().equals("Ancien")) {
                                    statut = "fa-clock-o";
                                    statut += " text-muted";
                                    tooltip = "Ancien";
                                } else {
                                    statut = "fa-search";
                                    tooltip = "A valider";
                                    statut += " text-info";
                                }
                            } else {
                                statut = "fa-times";
                                tooltip = "Inconnu";
                                statut += " text-danger";
                            }

                            out.println("<tr><td>" + "<i class='fa " + statut + "' title='" + tooltip + "'></i>" + "</td>"
                                    + "<td>" + cli.getNomCli() + "</td>"
                                    + "<td>" + cli.getPrenomClient() + "</td>"
                                    + "<td>" + cli.getIdProfilSportif() + "</td></tr>");
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
