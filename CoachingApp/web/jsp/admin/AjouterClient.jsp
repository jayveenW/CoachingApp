<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerAdmin.jsp"%>
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
        <h1 class="page-header">Ajouter un nouveau client</h1>
    </div>
</div>


<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 col-md-8 col-sm-12">
        <div class="form-group">

            <p>Tous les champs sont obligatoires</p>
            <form method="Post" action="AfficherClient">
                <div class="form-group">
                    <label for="Nom">Nom :</label> 
                    <input type="text" class="form-control" name="Nom" id="Nom" required>
                </div>
                <div class="form-group">
                    <label for="Prenom">Prenom :</label> 
                    <input type="text" class="form-control" name="Prenom" id="Prenom" required> 
                </div>
                <div class="form-group">
                    <label for="Mail">Mail :</label> 
                    <input type="email" class="form-control" name="Mail" id="Mail"  required> 
                </div>
                <div class="form-group">
                    <label for="Telephone">Telephone :</label> 
                    <input type="text" class="form-control" name="Telephone" id="Telephone"  required> 
                </div>
                <div class="form-group">
                    <label for="Age">Date de naissance :</label> 
                    <input type="date" class="form-control" name="Age" id="Age"  required> 
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
                    <label for="Typeab">Type d'abonnement :</label> 
                    <select class="form-control form-control-sm" name="Typeab" id="Typeab" required>
                        <option value='Annuel' selected>Annuel</option>
                        <option value='Mensuel'>Mensuel</option>
                        <option value='N/A'>Pas d'abonnement</option>
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