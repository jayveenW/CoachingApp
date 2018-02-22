<%-- 
    Document   : Inscription
    Created on : 20 févr. 2018, 19:19:50
    Author     : NG71392
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<div class="container">  
    <div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Inscription</div>
                <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="Connexion">Se connecter</a></div>
            </div>  
            <div class="panel-body" >
                <form id="signupform" class="form-horizontal" method="post" action="ServletInscription">
                    <div class="${erreurs['incorrect'] == null ? '' : "alert alert-danger"}">${erreurs['incorrect']}</p>
                        <div class="${erreurs['invalide'] == null ? '' : "alert alert-danger"}">${erreurs['invalide']}</p>

                            <div class="form-group">
                                <label for="Nom" class="col-md-3 control-label">Nom</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="nomCli" placeholder="Nom" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="Prenom" class="col-md-3 control-label">Prenom</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="prenomCli" placeholder="Prenom" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="Age" class="col-md-3 control-label">Date de naissance</label>
                                <div class="col-md-9">
                                    <input type="date" class="form-control" name="dateCli" maxlength="10" required>
                                </div>
                            </div> 

                            <div class="form-group">
                                <label for="Telephone" class="col-md-3 control-label">Telephone</label>
                                <div class="col-md-9">
                                    <input type="texte" class="form-control" name="telCli" maxlength="10" placeholder="Telephone" required>
                                </div>
                            </div>   

                            <div class="form-group">
                                <label for="Mail" class="col-md-3 control-label">Mail</label>
                                <div class="col-md-9">
                                    <input type="email" class="form-control" name="mailCli" placeholder="Mail" required>
                                </div>
                            </div>                        

                            <div class="form-group">
                                <label for="Mdp" class="col-md-3 control-label">Mot de passe</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="mdpCli" maxlength="10" required>
                                </div>
                            </div>  

                            <div class="form-group">
                                <!-- Button -->                                        
                                <div class="col-md-offset-3 col-md-9">
                                    <button id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i>S'inscrire</button> 
                                </div>
                            </div>
                            </form>
                        </div>
                    </div>
            </div> 
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>
