/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NG71392
 */
public class ServletConfirmNewProg extends HttpServlet {

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
//        String url = null;
//
//        // Chainage direct vers les JSP
//        RequestDispatcher rd;
//
//        // Récup des données du formulaire
//        String catEx = request.getParameter("catExo");
//        String libEx = request.getParameter("libelleExo");
//        String nivEx = request.getParameter("niveauExo");
//        String descEx = request.getParameter("descriptifExo");
//        String photoEx = request.getParameter("photoExo");
//        String vidEx = request.getParameter("videoExo");
//        String recoEx = request.getParameter("recommandationExo");
//        String textInfo = "L'exercice " + libEx;
//
//        ServiceExercice servExo = new ServiceExercice(); // Instanciation du service
//        Categorieexercice catExo = servExo.recupObjetCatExo(catEx);
//        boolean result = servExo.enrExerciceBD(catExo, libEx, nivEx, descEx, photoEx, vidEx, recoEx);
//
//        if (result == true) {
//            textInfo += " a bien été inséré dans la catégorie " + catEx;
//            request.getSession().setAttribute("info", textInfo);
//            url = "PAGE";
//        } else {
//            textInfo += " n'a pas pu être inséré dans la catégorie " + catEx;
//            request.getSession().setAttribute("info", textInfo);
//            url = "PAGE";
//        }
//
//        // Redirection
//        rd = request.getRequestDispatcher(url);
//        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
