<%@include file="../includes/headerCoach.jsp" %>

<div class="row">
    <div class="col-lg-12">
         <h3 class="page-header">Créer un programme</h3>
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
                    <label for="profils">Profils correspondant au programme</label>
                    <input type="checkbox" class="form-control" name="profils" id="profils">
                        <!-- Options à insérer. Merci le backend -->                                            
                </div>
            
                <div class="form-group">
                    <label for="sequences">Sequences du programme</label>
                    <input type="checkbox" class="form-control" name="sequences" id="sequences">
                        <!-- Options à insérer. Merci le backend -->                                            
                </div>

                <input class="btn btn-default" type="submit" value="Creer un programme" />
        </form>
    </div>
</div>

<%@include file="../includes/footer.jsp" %>