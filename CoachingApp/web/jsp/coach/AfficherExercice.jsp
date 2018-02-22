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
            <h1 class="page-header">Liste des Exercices</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a href="FormCreaExo"><button class="btn btn-warning btn-circle"><i class="fa fa-plus"></i></button></a> : Ajouter un exercice
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>Actions</th>
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
                            <% //exo.getIdExercice()
                               ServiceExercice se = new ServiceExercice();
                               String resultat = "<tr class=\"odd gradeX\">";
                               String urlParam = "";
                               for (Exercice exo : se.getListeExercice()){
                                   urlParam = "ServletModifExercice?exoSuppr="+exo.getIdExercice();
                                   //pour la suppressiion fait une page de confirmation et mets l'idée de l'exercice en session
                                   resultat += "<td><a href=\""+urlParam+"\"><button class=\"btn btn-outline btn-warning btn-xs\">"
                                           + "<i class=\"fa fa-pencil\"></i></button></a>"+
                                   "<button type=\"button\" name =\"suppresion\" id=\""+exo.getIdExercice()+"\"class=\"btn btn-outline btn-warning btn-xs\" data-toggle=\"modal\" data-target=\"#myModal\" onclick=\"modalParam(this)\">"
                                           + "<i class=\"fa fa-trash\"></i></button></td>"+
                                   "<td>"+exo.getCategorieexercice().getLibelleCategorieExercice()+"</td>"+
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
            <!-- Modal -->
            <div id="myModal" class="modal fade" role="dialog">
              <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Confirmation de suppression</h4>
                  </div>
                  <div class="modal-body">
                    <p>Voulez-vous supprimer cet exercice?</p>
                  </div>
                  <div class="modal-footer">
                      <a href="#" id="parametre"><button type="button" class="btn btn-default">OK</button></a>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                  </div>
                </div>

              </div>
            </div>
        </div>             
        <!-- /.col-lg-12 -->
    </div>
<%@include file="../includes/footer.jsp" %>
