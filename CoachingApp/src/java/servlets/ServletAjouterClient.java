/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServicesClient;

/**
 *
 * @author OSoro
 */
public class ServletAjouterClient extends HttpServlet {

    public static final String CHAMP_INCO = "incorrect";
    public static final String CHAMP_INV = "invalide";
    public static final String CHAMP_ERR = "erreurs";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = null;
        Map<String, String> erreurs = new HashMap<>();

        // Chainage direct vers les JSP
        RequestDispatcher rd;

        String Nom = request.getParameter("Nom");
        String Prenom = request.getParameter("Prenom");
        String Mail = request.getParameter("Mail");
        String ageNonParse = request.getParameter("Age");
        String Telephone = request.getParameter("Telephone");
        String Profil = request.getParameter("Profil");
        String Typeab = request.getParameter("Typeab");

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date Age = null;
        try {
            Age = df.parse(ageNonParse);
        } catch (ParseException ex) {
            System.out.println("La date n'a pas été parsée" + ex.getMessage());
            erreurs.put("nonParse", "La date n'a pas été parsée " + ex.getMessage());
        }

        ServicesClient sc = new ServicesClient();
        boolean result1 = sc.checkMailAdress(Mail);
        
        if (result1 = true) {
            boolean result = sc.ajoutClient(Nom, Prenom, Mail, Telephone, Age, Typeab, Profil);
            if (result == true) {
                url = "AfficherClient";
                erreurs.put("Valide", "L'ajout du client a bien été effectuée");
                request.setAttribute(CHAMP_ERR, erreurs);
            } else {
                url = "AjouterClient";
                erreurs.put(CHAMP_INCO, "Impossible d'insérer le client.");
                request.setAttribute(CHAMP_ERR, erreurs);
            }
        } else {
            url = "AjouterClient";
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
