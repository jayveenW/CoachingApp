<%-- 
    Document   : Connexion
    Created on : 20 févr. 2018, 17:19:58
    Author     : NG71392
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerConnexion.jsp"%>
<div class="container">  
    <div class="row">
        <div class="col-lg-12">
            <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                <div class="panel panel-info" id='panelConnexion'>
                    <div class="panel-heading">
                        <div class="panel-title">Connexion</div>
                    </div> 
                    <div class="panel-body" >
                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                        <%
                            String p = (String) request.getAttribute("pseudo");
                        %>

                        <form method="post" id="loginform" class="form-horizontal" action="ServletLogin">
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login-username" type="text" class="form-control" name="userId" value="<%= (p == null) ? "" : p%>" placeholder="email">                                        
                            </div>

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control" name="password" placeholder="mot de passe">
                            </div>

                            <p class="${erreurs['Vide'] == null ? '' : "alert alert-danger"}">${erreurs['Vide']}</p>
                            <p class="${erreurs['idFaux'] == null ? '' : "alert alert-danger"}">${erreurs['idFaux']}</p>
                            <p class="${erreurs['valide'] == null ? '' : "alert alert-success"}">${erreurs['valide']}</p>

                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">
                                    <button id="btn-login" type="submit" class="btn btn-success">Se connecter</button>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-12 control">
                                    <div>
                                        <div>
                                            <a href="Inscription" class='usefulLinks'>Je n'ai pas de compte et je veux m'inscrire !</a>
                                        </div>
                                        <div>
                                            <a href="#" class='usefulLinks'>J'ai perdu mon mot de passe!</a>
                                        </div>
                                    </div>
                                </div>    

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../includes/footer.jsp"%>