<%-- 
    Document   : Connexion
    Created on : 20 févr. 2018, 17:19:58
    Author     : NG71392
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        <form method="post" action="ServletLogin">
            <div style="padding: 100px 0 0 250px;">
                <div id="login-box">
                    <h2>Connexion</h2>
                    Entrez vos identifiants
                    <br>
                    <br>
                    <div id="login-box-name" style="margin-top:20px;">Identifiant (Adresse mail) :</div>
                    <div id="login-box-field" style="margin-top:20px;">
                        <input name="userId" class="form-login" value="" size="30" placeholder="exemple@gmail.com" maxlength="50" pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+.[a-zA-Z]{2,10}" />
                    </div>
                    <div id="login-box-name">Password :</div>
                    <div id="login-box-field">
                        <input name="password" type="password" class="form-login" value="" size="30" maxlength="48" />
                    </div>
                    <br />
                    <span class="login-box-options">
                        Nouvel utilisateur ? <a href="Inscription" style="margin-left:30px;">Inscrivez vous</a>
                    </span>
                    <br />
                    <br />
                    <input style="margin-left:100px;" type="submit" value="Login" />
                    <span class="error">${erreurs['idFaux']}</span>
                    <span class="error">${erreurs['Vide']}</span>
                    <span class="success">${erreurs['Valide']}</span>
                </div>
            </div>
        </form>
    </body>
</html>
