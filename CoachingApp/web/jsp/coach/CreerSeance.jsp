<%-- 
    Document   : CreerSeance
    Created on : 20 f�vr. 2018, 17:23:58
    Author     : Many
--%>
<%@include file="../includes/headerCoach.jsp" %>
        <h1>Cr�er une s�ance</h1>
        <form action="ServletCreerSeance" method="POST">
            <input type="text" name="nomSeance" id="nomSeance">
        </form>

<%@include file="../includes/footer.jsp" %>