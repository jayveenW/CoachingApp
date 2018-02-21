<%-- 
    Document   : AfficherExercice
    Created on : 21 févr. 2018, 05:48:57
    Author     : Bastien
--%>
<%@page import="metier.Exercice"%>
<%@page import="services.ServiceExercice"%>
<%@include file="../includes/headerCoach.jsp" %>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Exercices</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a href="FormCreaExo"><button class="btn btn-warning"> + </button></a> : Ajouter un exercice
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>Catégorie</th>
                                <th>Libellé</th>
                                <th>Difficulté</th>
                                <th>Descriptif</th>
                                <th>Photo</th>
                                <th>Vidéo</th>
                                <th>Recommandations</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                               ServiceExercice se = new ServiceExercice();
                               String resultat = "<tr class=\"odd gradeX\">";
                               for (Exercice exo : se.getListeExercice()){
                                   resultat += "<td>"+exo.getCategorieexercice().getLibelleCategorieExercice()+"</td>"+
                                   "<td>"+exo.getLibelleExercice()+"</td>" +
                                   "<td>"+exo.getNiveauExercice()+"</td>" +
                                   "<td>"+exo.getDescriptifExercice()+"</td>" +
                                   "<td>"+exo.getPhotoExercice()+"</td>" +
                                   "<td>"+exo.getVideoExercice()+"</td>"+
                                   "<td>"+exo.getRecommandationExercice()+"</td>";
                                   resultat += "</tr>";
                               }
                               out.println(resultat);
                            %>
                        </tbody>
                    </table>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
<%@include file="../includes/footer.jsp" %>
