<%@include file="../includes/headerCoach.jsp" %>
        <h1>Détails du programme</h1>
        
        <div>
            Nom du programme : Renforcement du haut du corps
            Nombre de répétition de la séquence : 4.
        </div>
        
        <h3>
            Liste des séances : 
        </h3>
        <!--[Back] Ici il faut aller chercher l'occurence de séance également, 
        car, c'est dans celle là que l'on a le statut de la séance. -->
        <!--[Affichage] Lorsqu'il s'agira d'une séance bilan, il faudra la 
        mettre en évidence via une couleur --> 
        
        <table class="table table-striped" id="tableauSeance">
            <tr>
                <th>Ordre</th>
                <th>Libellé de la séance</th>
                <th>Profil de la séance</th>
                <th>Actions</th>
            </tr>
            
            <!-- [Dettes]à virer lorsque le back sera bon -->
            
            <tr>
                <td>1</td>
                <td>Haut du corps</td>
                <td>Renforcement musculaire</td>
                
                <td><img src="../../ressources/images/afficher.png">
                    <img src="../../ressources/images/modifier.png">
                    <img src="../../ressources/images/supprimer.png">
                </td>
            </tr>
            <!--[Dettes]à virer jusque là -->
            
        </table>
    </body>
    
    
    <%@include file="../includes/footer.jsp" %>