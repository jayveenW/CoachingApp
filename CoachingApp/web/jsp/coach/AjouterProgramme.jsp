<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
    Page d'ajout d'un programme en lui affectant des séquences.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerAdmin.jsp"%>
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Ajouter un nouveau programme</h1>
    </div>
</div>


<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">

            <p>Tous les champs sont obligatoires</p>
            <form method="Post" action="AjoutProgramme">
                <div class="form-group">
                    <label for="Nom">Nom du programme :</label> 
                    <input type="text" class="form-control" name="Libelle" id="Nom" required>
                </div>
                <div class="form-group">
                    <label for="Profil">Profil sportif :</label> 
                    <select class="form-control form-control-sm" name="Profil" id="Profil" required>
                        <option value="1" selected>Perte de poids</option>
                        <option value="2">Remise en forme</option>
                        <option value="3">Préparation physique</option>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-warning pull-right">Valider</button>
                    <button class="btn btn-default" thref="Acceuil">Retour</a>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>  
        <form method="Post" action="">  
           <label>Nom du programme :</label> <input type="text" name="Libelle"> <br>
           <label>Numéros profil :</label> <input type="text" name="Profil"> <br>
         <input type="submit"><br>
