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
import metier.Client;
import metier.Coach;
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
    public static final String CHAMP_VIDE = "Vide";

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

        if (userId.isEmpty() || password.isEmpty()) {
            url = "Connexion";
            erreurs.put(CHAMP_VIDE, "Veuillez renseigner tous les champs.");
            request.setAttribute(CHAMP_ERR, erreurs);
        } else {
            ServiceLogin loginService = new ServiceLogin(); // INSTANCIATION du service
            boolean result = loginService.authenticateUser(userId, password);

            if (result == true) {
                Utilisateur user = loginService.getUserByUserId(userId);

                request.getSession().setAttribute("user", user); // La session prend l'utilisateur connecté en paramètre

                for (Role r : user.getRoles()) {
                    request.getSession().setAttribute("role", r);
                    if ("Administrateur".equals(r.getLibelleRole())) {
                        url = "AccueilAdmin";
                    } else if ("Client".equals(r.getLibelleRole())) {
                        Client client = loginService.getObjClient(userId);
                        request.getSession().setAttribute("client", client);
                        url = "FormCreaExo";
                    } else if ("Coach".equals(r.getLibelleRole())) {
                        Coach coach = loginService.getObjCoach(userId);
                        request.getSession().setAttribute("coach", coach);
                        url = "COACHACCUEILJSP";
                    }
                }
            } else {
                url = "Connexion";
                Utilisateur user = new Utilisateur(userId, password);
                request.setAttribute("pseudo", user.getMailUtilisateur());
                erreurs.put(CHAMP_INCO, "Les identifiants entrés sont incorrects.");
                request.setAttribute(CHAMP_ERR, erreurs);
            }
        }

        rd = request.getRequestDispatcher(url);

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
