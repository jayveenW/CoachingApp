<%-- 
    Document   : CreerSeance
    Created on : 20 févr. 2018, 17:23:58
    Author     : Many
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer une séance</title>
    </head>
    <body>
        <h1>Créer une séance</h1>
        <form action="ServletCreerSeance" method="POST">
            <input type="text" name="nomSeance" id="nomSeance">
        </form>
    </body>
</html>
