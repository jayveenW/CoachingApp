/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServiceInscription;

/**
 *
 * @author NG71392
 */
public class ServletInscription extends HttpServlet {

    public static final String CHAMP_INCO = "incorrect";
    public static final String CHAMP_INV = "invalide";
    public static final String CHAMP_ERR = "erreurs";

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    @SuppressWarnings("empty-statement")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = null;
        Map<String, String> erreurs = new HashMap<>();

        // Chainage direct vers les JSP
        RequestDispatcher rd;

        String nom = request.getParameter("nomCli");
        String prenom = request.getParameter("prenomCli");
        String dateNonParse = request.getParameter("dateCli"); // 2018-02-5 
        String mail = request.getParameter("mailCli");
        String mdp = request.getParameter("mdpCli");
        String tel = request.getParameter("telCli");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateNonParse);
        } catch (ParseException ex) {
            System.out.println("La date n'a pas été parsée" + ex.getMessage());
            erreurs.put("nonParse", "La date n'a pas été parsée " + ex.getMessage());
        }

        ServiceInscription inscript = new ServiceInscription();
        boolean result1 = inscript.checkMailAdress(mail);

        if (result1 = true) {
            boolean result = inscript.insertClient(nom, prenom, date, mail, mdp, tel);
            if (result == true) {
                url = "Connexion";
                erreurs.put("Valide", "L'inscription a bien été validé");
                request.setAttribute(CHAMP_ERR, erreurs);
            } else {
                url = "Inscription";
                erreurs.put(CHAMP_INCO, "Les identifiants entrés sont incorrects.");
                request.setAttribute(CHAMP_ERR, erreurs);
            }
        } else {
            url = "Inscription";
            erreurs.put(CHAMP_INV, "Ce mail est déjà utilisé.");
            request.setAttribute(CHAMP_ERR, erreurs);
        }

        rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
