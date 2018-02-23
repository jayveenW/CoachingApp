<%@page import="java.util.List"%>
<%@page import="services.ServicesProgramme"%>
<%@page import="metier.Programme"%>
<%@include file="../includes/headerCoach.jsp" %>
<!DOCTYPE html>

<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header">Liste des programmes</h3>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="form-group">
            <label for="RechercheListe">Vous pouvez rechercher le programme grâce à son nom :</label>
            <input class="form-control" type="text" name="RecherchePrgm" onKeyUp="rechercherProgramme()" id="RechercheListe"/>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="form-group">
            <input class="btn btn-default" type="submit" name="Ajouter" id="AjouterProgramme" value="Ajouter un programme">
        </div>



        <div class="table-responsive">
            <table class="table table-striped" id="tableauProgramme">       
                <thead>
                    <th>Nom du programme</th>
                    <th>Actions</th>
                </thead>
                <!-- à virer par la suite --> 
                    <!-- Ajouter les liens pour accéder à modifier et supprimer --> 

                    <%
                        try {
                            for (Programme prog : ServicesProgramme.afficherProgramme()) {
                                out.println("<tr><td>" + prog.getIdProgramme()+ "</td><td>" + prog.getLibelleProgramme() + "</td></tr>");
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