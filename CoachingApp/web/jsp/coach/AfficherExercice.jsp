<%-- 
    Document   : AfficherExercice
    Created on : 21 févr. 2018, 05:48:57
    Author     : Bastien
    Affichage des différents exercices avec les fonctionnalités d'ajout, de suppression et de modification.
    Page centrale pour la gestion des exercices
--%>
<%@page import="metier.Exercice"%>
<%@page import="services.ServiceExercice"%>
<%@include file="../includes/headerCoach.jsp" %>

<!-- NON RESPONSIVE -->
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
                    <!-- Ce lien hypertexte permet d'accéder à la page de création d'un exercice -->
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
                            <% /*Cette boucle for permet de rajouter une ligne de tableau pour
                                chaque exercice présent en BD. En plus des informations sur chaque exercice,
                                la première colonne est réservé à chaque fois aux actions de modifications
                                et de suppressions d'une ligne.
                                */
                               ServiceExercice se = new ServiceExercice();
                               String resultat = "<tr class=\"odd gradeX\">";
                               String urlParam = "";
                               for (Exercice exo : se.getListeExercice()){
                                   urlParam = "ServletModifExercice?exoSuppr="+exo.getIdExercice();
                                   /*1er bouton inclu dans le lien hypertexte avec paramètres : modification
                                     2nd bouton avec ouverture d'une modale et appel à une fonction javascript : suppression
                                   */
                                   resultat += "<td><a href=\""+urlParam+"\"><button class=\"btn btn-outline btn-warning btn-xs\">"
                                           + "<i class=\"fa fa-pencil\"></i></button></a>"+
                                   "<button type=\"button\" id=\""+exo.getIdExercice()+"\"class=\"btn btn-outline btn-warning btn-xs\" data-toggle=\"modal\" data-target=\"#myModal\" onclick=\"modalParam(this)\">"
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

                <!-- Code de la fenêtre modale, ce dernier est statique
                et provient du template Bootstrap-->
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Confirmation de suppression</h4>
                  </div>
                  <div class="modal-body">
                    <p>Voulez-vous supprimer cet exercice?</p>
                  </div>
                  <div class="modal-footer">
                      <!-- Ce lien hypertexte est appelé par une fonction js et son tag href
                      est modifié afin de comprendre l'url de la servlet et la valeur d'un paramètre associé-->
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
