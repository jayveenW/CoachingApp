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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Categorieexercice;
import services.ServiceExercice;

/**
 *
 * @author Bastien
 */
public class ServletAjoutExercice extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        // Chainage direct vers les JSP
        RequestDispatcher rd;

        // Récup des données du formulaire
        String catEx = ("".equals(request.getParameter("catExo")))? "" : request.getParameter("catExo");
        String libEx = ("".equals(request.getParameter("libelleExo")))? "" : request.getParameter("libelleExo");
        String nivEx = ("".equals(request.getParameter("niveauExo")))? "" : request.getParameter("niveauExo");
        String descEx = ("".equals(request.getParameter("descriptifExo")))? "" : request.getParameter("descriptifExo");
        String photoEx = ("".equals(request.getParameter("photoExo")))? "" : request.getParameter("photoExo");
        String vidEx = ("".equals(request.getParameter("videoExo")))? "" : request.getParameter("videoExo");
        String recoEx = ("".equals(request.getParameter("recommandationExo")))? "" : request.getParameter("recommandationExo");
        String textInfo = "L'exercice " + libEx;
        ServiceExercice servExo = new ServiceExercice(); // Instanciation du service
        Categorieexercice catExo = servExo.recupObjetCatExo(catEx);
        boolean result = servExo.enrExerciceBD(catExo, libEx, nivEx, descEx, photoEx, vidEx, recoEx);
        
        if (result == true) {
            textInfo += " a bien été inséré dans la catégorie " + catEx;
            request.getSession().setAttribute("info", textInfo);
            url = "AfficherExercice";
        } else {
            textInfo += " n'a pas pu être inséré dans la catégorie " + catEx;
            request.getSession().setAttribute("info", textInfo);
            url = "AfficherExercice";
        }

        // Redirection
        rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
