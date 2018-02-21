<%-- 
    Document   : CreerSeance
    Created on : 20 f�vr. 2018, 17:23:58
    Author     : Many
--%>
<%@page import="metier.Categorieexercice"%>
<%@page import="services.ServiceExercice"%>
<%@include file="../includes/headerCoach.jsp" %>
<div class="col-lg-12">
    <div class="row">
        <h1 class="page-header">Cr�er une s�ance</h1>
    </div>
</div>
<form action="CreerSeance" method="POST">
    <div class="form-group">
        <label>Nom de la s�ance</label>
        <input class="form-control" type="text" name="nomSeance" id="nomSeance">
    </div>
    <div class="form-group">
        <label> 1. Choisir la cat�gorie d'exercice</label>
        <select id="catExo" class="form-control" onchange="rechercherExercice()">
            <%
                ServiceExercice se = new ServiceExercice();
                String resultat = "";
                for (Categorieexercice catExo : se.getListeCategorie()) {
                    resultat += "<option value=\"" + catExo.getIdCategorieExercice() + "\">" + catExo.getLibelleCategorieExercice() + "</option>";
                }
                out.println(resultat);
            %>
        </select>
    </div>
    <div class="form-group">
        <label>2. Choisir un exercice</label>
        <select class="form-control">
            <option>Merde ! </option>
        </select>
    </div>
    <div class="form-group">
        <label>3. Nombre de s�ries</label>
        <input type="number" id="nbSerie" name="nbSerie" class="form-control"/>
    </div>
    <div class="form-group">
        <label>4. Nombre de r�p�titions</label>
        <input type="number" id="nbRepetition" name="nbRepetition" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-warning"> + </button>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Libell� exercice</th>
                <th>Nombre de s�rie</th>
                <th>Nombre de r�p�tition</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td scope="row">1</td>
                <td>Pompes diamants</td>
                <td>3</td>
                <td>25</td>
            </tr>

        </tbody>                  
    </table>
    <button type="submit" id="validerSeance" name="validerSeance" class="btn btn-warning"> Valider la composition de la s�ance </button>
    <button type="submit" id="annulerSeance" name="annulerSeance" class="btn btn-warning"> Annuler la s�ance </button>
</form>


<%@include file="../includes/footer.jsp" %>