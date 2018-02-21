<%@include file="../includes/headerCoach.jsp" %>

<div class="row">
    <div class="col-lg-12">
         <h3 class="page-header">Créer une séance</h3>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <form action="ajouterLeLien">
                <div class="form-group">
                    <label for="nomProgramme">Nom du programme</label>
                    <input class="form-control" type="text" name="nomPrograme" id="nomPrograme"/>
                </div>

                <div class="form-group">
                    <label for="typeProgramme">Type de programme</label>
                    <select class="form-control" name="typeProgramme" id="typeProgramme">
                        <!-- Options à insérer. Merci le backend -->                        
                    </select>
                </div>

                <input class="btn btn-default" type="submit" value="Creer un programme" />
        </form>
    </div>
</div>

<%@include file="../includes/footer.jsp" %>