<%@include file="../includes/headerCoach.jsp" %>
    <div class="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
               <h1 class="page-header">Exercice</h1> 
            </div>
        </div>
        <div class="row">
            <form action="ServletAjoutExercice" method="POST" id="formExo">
                <div class="form-group">
                    <label for="catExo">Catégorie de l'exercice</label>
                    <select class="form-control" id="catExo">
                      <option></option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="libelleExo">Libellé de l'exercice</label>
                    <input type="text" class="form-control" id="libelleExo" placeholder="...">
                </div>
                <div class="form-group">
                    <label for="niveauExo">Niveau de l'exercice</label>
                    <select class="form-control" id="niveauExo">
                      <option>Débutant</option>
                      <option>Confirmé</option>
                      <option>Expert</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="descriptifExo">Descriptif de l'exercice</label>
                    <textarea class="form-control" id="descriptifExo" rows="3"></textarea>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Upload</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="photoExo">
                        <label class="custom-file-label" for="photoExo">Choisir une photo</label>
                    </div>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Upload</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="videoExo">
                        <label class="custom-file-label" for="videoExo">Choisir une vidéo</label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="descriptifExo">Recommandation pour l'exercice</label>
                    <textarea class="form-control" id="recommandationExo" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
    <script type="text/javascript">
$(document).ready(function() {  
    $.ajax({
       url : 'ServletCategorieExercice',
       type : 'POST',
       datatype : 'xml'
       }).done(function(xml){
           $(xml).find("categorie").each(function(){
               texte += "<option>" + $(this).text() + "</option>";
           });
           $("#formExo :select :first").html(texte);
       });
});
    </script>
<%@include file="../includes/footer.jsp" %>

