<%@page import="java.util.List"%>
<%@page import="services.ServicesProgramme"%>
<%@page import="metier.Programme"%>
<%@include file="../includes/headerCoach.jsp" %>
<!DOCTYPE html>

<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
    Page d'affichage de la liste des programme.
--%>

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
           <form method="POST" action="AjoutProgramme">
            <a></a> <input class="btn btn-default" type="submit" name="Ajouter" id="AjouterProgramme" value="Ajouter un programme" >
             </form>
        </div>



        <div class="table-responsive">
            <table class="table table-striped" id="tableauProgramme">       
                <thead>
                    <th>Nom du programme</th>
                    <th>ID programme</th>
                </thead>
 

                    <%
                        try {
                            for (Programme prog : ServicesProgramme.afficherProgramme()) {
                                out.println("<tr><td>" + prog.getLibelleProgramme() + "</td><td>" + prog.getIdProgramme() + "</td></tr>");
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