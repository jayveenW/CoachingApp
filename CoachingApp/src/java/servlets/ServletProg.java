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
import javax.servlet.http.HttpSession;

/**
 *
 * @author NG71392
 */
public class ServletProg extends HttpServlet {

    public static final String CHAMP_LISTID = "idVide";
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = null;
        Map<String, String> erreurs = new HashMap<>();

        // Chainage direct vers les JSP
        RequestDispatcher rd;

        HttpSession session = request.getSession(true);
        String[] listId = request.getParameterValues("profilSportif");

        try {
            listeVideOuNon(listId);
        } catch (Exception e) {
            erreurs.put(CHAMP_LISTID, e.getMessage());
        }

        request.setAttribute(CHAMP_ERR, erreurs);

        if (erreurs.isEmpty()) {
            session.setAttribute("listId", listId);
            url = "Progs";
        } else {
            url = "AjouterProg";
        }
        rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private void listeVideOuNon(String[] listId) throws Exception {
        if (listId == null) {
            throw new Exception("Vous n'avez pas sélectionné de profils sportifs à modifier.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
