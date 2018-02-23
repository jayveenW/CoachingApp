<%-- 
    Document   : ModificationExercice
    Created on : 22 févr. 2018, 08:18:56
    Author     : Bastien
    Modification d'un exercice présent sur la page d'affichage
--%>

<%@page import="metier.Exercice"%>
<%@page import="metier.Categorieexercice"%>
<%@page import="services.ServiceExercice"%>
<%@include file="../includes/headerCoach.jsp" %>
<% /*récupération de l'objet exercice passé en session pour pré-remplir
    les différents champs modifiables du formulaire*/
    Exercice exo = (Exercice)request.getSession().getAttribute("exoModif");
    String[] nivDifficulte = {"Débutant", "Confirmé", "Expert"};
%>
    <div class="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
               <h1 class="page-header">Modification d'un exercice</h1> 
            </div>
        </div>
        <div class="row">
            <form action="ServletModifExercice" method="POST" id="formExo">
                <!-- Cet input hidden avec l'id de l'exercice est utilisé pour une fonction Hibernate
                 côté Back-End lors de l'update en BD-->
                <input type="hidden" name="idExo" value="<%= exo.getIdExercice()%>">
                <div class="form-group">
                    <label for="catExo">Catégorie de l'exercice</label>
                    <select class="form-control" id="catExo" name="catExo" required>
                      <%
                          //Affichage des catégories d'exercices présentes en BD
                            ServiceExercice se = new ServiceExercice();
                            String resultat = "";
                            for (Categorieexercice catExo : se.getListeCategorie()){
                                /*Cette boucle If permet de savoir quel attribut de la liste afficher en sélectionné
                                en comparant chaque élément avec la valeur de la catégorue pour cet exercice spécifique
                                */
                                if (catExo.getLibelleCategorieExercice().equals(exo.getCategorieexercice().getLibelleCategorieExercice())){
                                    resultat += "<option value=\""+catExo.getLibelleCategorieExercice()+"\"selected>"+
                                        catExo.getLibelleCategorieExercice()+"</option>";
                                }
                                else {
                                    resultat += "<option value=\""+catExo.getLibelleCategorieExercice()+"\">"+
                                        catExo.getLibelleCategorieExercice()+"</option>";
                                }
                                
                            }
                            out.println(resultat);
                       %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="libelleExo">Libellé de l'exercice</label>
                    <input type="text" class="form-control" id="libelleExo" name="libelleExo" value="<%= exo.getLibelleExercice() %>" required>
                </div>
                <div class="form-group">
                    <label for="niveauExo">Niveau de l'exercice</label>
                    <select class="form-control" id="niveauExo" name="niveauExo" required>
                      <%
                          //Affichage des niveaux de difficulté de la variable en début de fichier
                            String resultatBis = "";
                            for (String niv : nivDifficulte){
                                /* Boucle if qui permet également de savoir quel élément de la liste afficher 
                                en selected en le comparant avec la valeur de l'exercice
                                */
                                if (niv.equals(exo.getNiveauExercice())){
                                    resultatBis += "<option value=\""+niv+"\" selected>"+niv+"</option>";
                                }
                                else {
                                    resultatBis += "<option value=\""+niv+"\">"+niv+"</option>";
                                }
                            }
                            out.println(resultatBis);
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="descriptifExo">Descriptif de l'exercice</label>
                    <textarea class="form-control" id="descriptifExo" rows="3" name="descriptifExo" required><%= exo.getDescriptifExercice() %></textarea>
                </div>
                <div class="form-group">
                    <label for="photoExo">Photo de l'exercice</label>
                    <input type="text" class="form-control" id="photoExo" name="photoExo" value="<%= exo.getPhotoExercice()%>">
                </div>
                <div class="form-group">
                    <label for="libelleExo">Vidéo de l'exercice</label>
                    <input type="text" class="form-control" id="videoExo" name="videoExo" value="<%= exo.getVideoExercice()%>">
                </div>
                <div class="form-group">
                    <label for="descriptifExo">Recommandation pour l'exercice</label>
                    <textarea class="form-control" id="recommandationExo" name="recommandationExo" rows="3"><%= exo.getRecommandationExercice()%></textarea>
                </div>
                <button type="submit" class="btn btn-warning">Valider</button>
            </form>
            <a href="AfficherExercice"><button type="submit" class="btn btn-warning">Annuler</button></a>
        </div>
    </div>
    <%@include file="../includes/footer.jsp" %>
