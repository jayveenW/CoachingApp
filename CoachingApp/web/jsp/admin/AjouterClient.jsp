<%-- 
    Document   : AjouterClient
    Created on : 20 févr. 2018, 21:44:34
    Author     : OSoro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout client</title>
    </head>
    <body>
        <h1>Ajouter un nouveaux client</h1>
        
        <form method="Post" action="AjouterClient">  
            <label>Nom :</label> <input type="text" name="Nom"> <br>
            <label>Prenom :</label> <input type="text" name="Prenom"> <br>
            <label>Mail :</label> <input type="text" name="Mail"> <br>
            <label>Telephone :</label> <input type="text" name="Telephone"> <br>
            <label>Date de naissance :</label> <input type="text" name="Age"> <br>
            <label>Profil sportif :</label> <input type="text" name="Profil"> <br>
            <label>Type d'abonnement :</label> <input type="text" name="Typeab">
            <br> <br>
            <input type="submit"><br>
            
             <a href="Acceuil">Retour</a>
        </form>
        
        <%
            
            %>
    </body>
</html>