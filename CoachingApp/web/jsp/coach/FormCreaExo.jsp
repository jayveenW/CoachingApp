<%@page import="metier.Categorieexercice"%>
<%@page import="metier.Exercice"%>
<%@page import="services.ServiceExercice"%>
<%@include file="../includes/headerCoach.jsp" %>
<% String[] nivDifficulte = {"D�butant", "Confirm�", "Expert"}; %>
    <div class="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
               <h1 class="page-header">Exercice</h1> 
            </div>
        </div>
        <div class="row">
            <form action="ServletAjoutExercice" method="POST" id="formExo">
                <div class="form-group">
                    <label for="catExo">Cat�gorie de l'exercice</label>
                    <select class="form-control" id="catExo" name="catExo" required>
                      <%
                            ServiceExercice se = new ServiceExercice();
                            String resultat = "";
                            for (Categorieexercice catExo : se.getListeCategorie()){
                                resultat += "<option value=\""+catExo.getLibelleCategorieExercice()+"\">"+
                                        catExo.getLibelleCategorieExercice()+"</option>";
                            }
                            out.println(resultat);
                       %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="libelleExo">Libell� de l'exercice</label>
                    <input type="text" class="form-control" id="libelleExo" name="libelleExo" placeholder="..." required>
                </div>
                <div class="form-group">
                    <label for="niveauExo">Niveau de l'exercice</label>
                    <select class="form-control" id="niveauExo" name="niveauExo" required>
                        <%
                            String resultatBis = "";
                            for (String niv : nivDifficulte){
                                resultatBis += "<option value=\""+niv+"\">"+niv+"</option>";
                            }
                            out.println(resultatBis);
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="descriptifExo">Descriptif de l'exercice</label>
                    <textarea class="form-control" id="descriptifExo" rows="3" name="descriptifExo" required></textarea>
                </div>
                <div class="form-group">
                    <label for="photoExo">Photo de l'exercice</label>
                    <input type="text" class="form-control" id="photoExo" name="photoExo" placeholder="Chemin --> racine/...">
                </div>
                <div class="form-group">
                    <label for="libelleExo">Vid�o de l'exercice</label>
                    <input type="text" class="form-control" id="videoExo" name="videoExo" placeholder="URL  http://...">
                </div>
                <div class="form-group">
                    <label for="descriptifExo">Recommandation pour l'exercice</label>
                    <textarea class="form-control" id="recommandationExo" name="recommandationExo" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
    <%@include file="../includes/footer.jsp" %>
