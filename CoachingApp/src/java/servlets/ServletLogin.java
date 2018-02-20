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
import metier.Utilisateur;
import services.ServiceLogin;

/**
 *
 * @author NG71392
 */
public class ServletLogin extends HttpServlet {

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if (result == true) {
            request.getSession().setAttribute("user", user); // La session prend l'utilisateur connecté en paramètre
            url = "home.jsp";
        } else {
            url = "error.jsp";
        }
        rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
