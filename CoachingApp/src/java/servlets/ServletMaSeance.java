/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Exercice;
import metier.Occseance;
import services.ServiceAccueilClient;

/**
 *
 * @author NG71392
 */
public class ServletMaSeance extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_exercice>");

            /*----- Récupération des paramètres -----*/
            String seanceDate = request.getParameter("date");
            String idcli = request.getParameter("idcli");
            
            
            /*----- Lecture de liste des seances -----*/
            ServiceAccueilClient sac = new ServiceAccueilClient();
            List<Exercice> lexos = new ArrayList<>();
            Occseance occ = sac.getSeance(idcli, seanceDate);
            int idOcc = occ.getIdOccSeance();
            lexos = sac.getExercices(idOcc);
            for (Exercice ex : lexos) {
                out.println("<unExercice>");
                out.println("<exerciceCat>" + ex.getCategorieexercice().getLibelleCategorieExercice() + "</exerciceCat>");
                out.println("<exerciceLib>" + ex.getLibelleExercice() + "</exerciceLib>");
                out.println("<exerciceDesc>" + ex.getDescriptifExercice() + "</exerciceDesc>");
                out.println("<exerciceNiv>" + ex.getNiveauExercice() + "</exerciceNiv>");
                out.println("<exerciceReco>" + ex.getRecommandationExercice() + "</exerciceReco>");
                out.println("<exercicePhot>" + ex.getPhotoExercice() + "</exercicePhot>");
                out.println("<exerciceVid>" + ex.getVideoExercice() + "</exerciceVid>");
                out.println("</unExercice>");
            }
            out.println("</liste_exercice>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
/*----- Fin de la servlet ServletCitation -----*/
