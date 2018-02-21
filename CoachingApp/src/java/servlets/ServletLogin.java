/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Role;
import metier.Utilisateur;
import services.ServiceLogin;

/**
 *
 * @author NG71392
 */
public class ServletLogin extends HttpServlet {

    public static final String CHAMP_INCO = "idFaux";
    public static final String CHAMP_ERR = "erreurs";

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = null;
        Map<String, String> erreurs = new HashMap<>(); // Pas obligatoire mais permet de gérer les erreurs dans 
        // une hashmap pour les afficher apres.

        // Chainage direct vers les JSP
        RequestDispatcher rd;

        String userId = request.getParameter("userId"); // Recup le champ du formulaire userId
        String password = request.getParameter("password"); // Recup le champ du formulaire password

        ServiceLogin loginService = new ServiceLogin(); // INSTANCIATION du service
        boolean result = loginService.authenticateUser(userId, password); // recup du résultat de la premiere methode du service
        Utilisateur user = loginService.getUserByUserId(userId); // recup du résultat de la deuxieme methode du service
        Role userRole = loginService.getRoleUtilisateur(user); // recup du reséultat de la troisieme methode du service
        if (userId == null && password == null) {
            url = "Connexion";
            erreurs.put("Vide", "Veuillez renseigner les champs");
            request.setAttribute(CHAMP_ERR, erreurs);
        } else {

            if (result == true) {
                request.getSession().setAttribute("user", user); // La session prend l'utilisateur connecté en paramètre
                if (null != userRole.getLibelleRole()) {
                    switch (userRole.getLibelleRole()) {
                        case "Administrateur":
                            url = "ADMINJSP";
                            break;
                        case "Coach":
                            url = "COACHJSP";
                            break;
                        case "Client":
                            url = "CLIENTJSP";
                            break;
                        default:
                            break;
                    }
                }
            } else {
                url = "Connexion";
                erreurs.put(CHAMP_INCO, "Les identifiants entrés sont incorrects.");
                request.setAttribute(CHAMP_ERR, erreurs);
            }
        }

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
        processRequest(request, response);
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
