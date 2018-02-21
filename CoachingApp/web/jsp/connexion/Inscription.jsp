<%-- 
    Document   : Inscription
    Created on : 20 févr. 2018, 19:19:50
    Author     : NG71392
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
    </head>
    <form method="post" action="ServletInscription">
        <div style="padding: 100px 0 0 250px;">
            <div id="login-box">
                <h2>Inscription</h2>
                Entrez vos informations personnelles
                <br>
                <br>

                <div id="login-box-name" style="margin-top:20px;">Nom :</div>
                <div id="login-box-field" style="margin-top:20px;">
                    <input name="nomCli" class="form-login" value="" size="30" maxlength="50" />
                </div>

                <div id="login-box-name" style="margin-top:20px;">Prénom :</div>
                <div id="login-box-field" style="margin-top:20px;">
                    <input name="prenomCli" class="form-login" value="" size="30" maxlength="50" />
                </div>

                <div id="login-box-name" style="margin-top:20px;">Date de naissance :</div>
                <div id="login-box-field" style="margin-top:20px;">
                    <input type="date" name="dateCli" class="form-login" value="" size="30" maxlength="50" />
                </div>

                <div id="login-box-name" style="margin-top:20px;">Téléphone :</div>
                <div id="login-box-field" style="margin-top:20px;">
                    <input type="tel" name="telCli" class="form-login" value="" placeholder="00-00-00-00-00" size="30" maxlength="50" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" />

                </div>

                <div id="login-box-name" style="margin-top:20px;">Mail :</div>
                <div id="login-box-field" style="margin-top:20px;">
                    <input type="email" name="mailCli" class="form-login" value="" placeholder="exemple@gmail.com" size="30" maxlength="50" pattern="/^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/" />
                </div>

                <div id="login-box-name" style="margin-top:20px;">Mot de passe :</div>
                <div id="login-box-field" style="margin-top:20px;">
                    <input type="password" name="mdpCli" class="form-login" value="" size="30" maxlength="50" />
                </div>

                <br />
                <br />
                <input style="margin-left:100px;" type="submit" value="S'inscrire" />

                <br />

                <span class="login-box-options">
                    <a href="Connexion" style="margin-left:30px;">Annuler l'inscription</a>
                </span>
                <span class="error">${erreurs['incorrect']}</span>
                <span class="error">${erreurs['invalide']}</span>
            </div>
        </div>
    </form>
</body>
</html>
