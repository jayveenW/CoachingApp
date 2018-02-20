<%-- 
    Document   : DefinirProgramme
    Created on : 20 févr. 2018, 13:56:54
    Author     : NG71392
--%>

<%@page import="java.util.List"%>
<%@page import="metier.Profilsportif"%>
<%@page import="services.ServiceProfilSportif"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerCoach.jsp" %>
        <%
            ServiceProfilSportif ssp = new ServiceProfilSportif();
            List<Profilsportif> recupProfils = ssp.recupProfils();

            String[] l = (String[]) session.getAttribute("listId");
        %>
        <h1>Choisir le ou les les profil(s) sportifs</h1>
        <div>
            <form action="ServletRecupProfilSportif"  method="post">
                <table>
                    <% try {
                            for (Profilsportif ps : recupProfils) {
                    %>
                    <tr>
                        <td><% out.println(ps.getLibelleProfilSportif());%></td>
                        <td><input type="checkbox" name="profilSportif" value="<%= ps.getIdProfilSportif()%>" style="text-align:right;"/></td
                    </tr>
                    <%  }
                        } catch (Exception e) {
                            out.println("<p>" + e.getMessage() + "</p>");
                        }
                    %>
                </table>
                <p><input type="submit"  value="Sélectionner" /></p>
                <p><input type="button" name="cancel" value="RetourAccueil" onclick="window.location.href = 'ReturnAccueil'"></p>
                <span class="error">${erreurs['idVide']}</span>
                <span class="success">${erreurs['Success']}</span>
            </form> 
        </div>
        <!--
                <div>
                    <b>Liste des profils sportifs.</b><br/>
                    <textarea id ="zone" rows="4" cols="40">Valeur par défaut</textarea><br/>
                    <input type="button" value="Afficher le XML" onclick="afficheXML()" /><br/>
        
                    <br/>
                    <b>La liste déroulante ci-dessous va contenir la liste des noms des auteurs.</b><br/>
                    <select id="lnom" onChange="l_citations()"><option>--</option></select>
                    <input type="button" value="Afficher les auteurs" onclick="l_auteurs()" />
                    <div id="lcitations"></div>
        
                    <br/>
                    <div><b>Google.</b><br/>
                        <input id="saisie" class="saisie" type="text" placeholder="Saisissez des caractères !" onKeyUp="processKey()"/>
                        <div id="zoneaff" class="boite"></div></div>
        
                    <br/>
                    <b>Encodage de caractères.</b><br/>
                    <input id="envoie" type="text" size="20" value="Entrez..." /> Caractères envoyés au serveur<br/>
                    <input id="recue" type="text" size="20" value="-" /> Caractères reçus du serveur<br/>
                    <input type="button" value="Envoyer" onclick="testEncodeUrl()" /><br/>
        
                    <br/>
                    <b>Formulaire de saisie.</b>
                    <div id="formAdd">
                        <div><input type="text" id="saisieAdd" name="zone" size="10" /></div>
                        <div><input type="button" value="+" onclick="addWord()" /></div>
                        <div id="affNewWord"></div>
                    </div>
        
                    <br/>
                    <b>Lancement direct d'une servlet. </b><a href="ServletCitation?nomauteur=Coluche">Go !</a><br/>
        
                </div>
        -->
<%@include file="../includes/footer.jsp" %>