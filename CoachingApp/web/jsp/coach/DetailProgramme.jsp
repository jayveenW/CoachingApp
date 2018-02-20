<%@include file="../includes/headerCoach.jsp" %>
        <h1>D�tails du programme</h1>
        
        <div>
            Nom du programme : Renforcement du haut du corps
            Nombre de r�p�tition de la s�quence : 4.
        </div>
        
        <h3>
            Liste des s�ances : 
        </h3>
        <!--[Back] Ici il faut aller chercher l'occurence de s�ance �galement, 
        car, c'est dans celle l� que l'on a le statut de la s�ance. -->
        <!--[Affichage] Lorsqu'il s'agira d'une s�ance bilan, il faudra la 
        mettre en �vidence via une couleur --> 
        
        <table class="table table-striped" id="tableauSeance">
            <tr>
                <th>Ordre</th>
                <th>Libell� de la s�ance</th>
                <th>Profil de la s�ance</th>
                <th>Actions</th>
            </tr>
            
            <!-- [Dettes]� virer lorsque le back sera bon -->
            
            <tr>
                <td>1</td>
                <td>Haut du corps</td>
                <td>Renforcement musculaire</td>
                
                <td><img src="../../ressources/images/afficher.png">
                    <img src="../../ressources/images/modifier.png">
                    <img src="../../ressources/images/supprimer.png">
                </td>
            </tr>
            <!--[Dettes]� virer jusque l� -->
            
        </table>
    </body>
    
    
    <%@include file="../includes/footer.jsp" %>