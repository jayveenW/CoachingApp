<%-- 
    Document   : CreerSeance
    Created on : 20 f�vr. 2018, 17:23:58
    Author     : Many
--%>
<%@page import="metier.Categorieexercice"%>
<%@page import="services.ServiceExercice"%>
<%@include file="../includes/headerCoach.jsp" %>
        <h1>Cr�er une s�ance</h1>
        <form action="ServletCreerSeance" method="POST">
            <div class="form-group">
                <label>Nom de la s�ance</label>
                <input type="texte" class="form-control" name="nomSeance" id="nomSeance"/>
            </div>
            
            <div class="form-group">
                <label>Profil de s�ance</label>
                <select class="form-control" name="profil">
                    <option value="Amincissement">Amincissement</option>
                    <option value="Amaigrissement">Amaigrissement</option>
                    <option value="Renforcement musculaire">Renforcement musculaire</option>
                    <option value="Cardio">Cardio</option>
                </select>
            </div>
            
            <input type="submit" id="Valider" class="btn btn-warning"/>
        </form>
        
        
<%@include file="../includes/footer.jsp" %>