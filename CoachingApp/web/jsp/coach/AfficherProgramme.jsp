<%@include file="../includes/headerCoach.jsp" %>
<!DOCTYPE html>

            <div class="wthree_head_section">
                <h3 class="w3l_header w3_agileits_header">Liste des programmes</h3>
            </div>
            
                Vous pouvez rechercher le programme gr�ce � son nom : <br/>
                <input type="text" name="RecherchePrgm" onKeyUp="rechercherProgramme()" id="RechercheListe"/>
            
            <div class="">
            <input type="submit" name="Ajouter" id="AjouterProgramme" value="Ajouter un programme">
    
        <div class="table-responsive">
            <table class="table table-striped" id="tableauProgramme">       
                <tr>
                    <th>Nom du programme</th>
                    <th>Actions</th>
                </tr>
                <!-- � virer par la suite --> 
                
                <tr>
                    <td> Projet 1</td>
                <!-- Ajouter les liens pour acc�der � modifier et supprimer --> 
                    
                    <td> <img src="../../ressources/images/modifier.png">
                         <img src="../../ressources/images/supprimer.png">
                    </td>
                </tr>
                <!-- A virer jusque l� --> 
            </table>
        </div>
    </div>
<%@include file="../includes/footer.jsp" %>