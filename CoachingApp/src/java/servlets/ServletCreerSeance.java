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
import javax.servlet.http.HttpSession;
import services.ServiceSeance;

/**
 *
 * @author Many
 */
public class ServletCreerSeance extends HttpServlet {

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
        
        RequestDispatcher rd;
        HttpSession session = request.getSession(true);
        
        String libelleSeance = ("".equals(request.getParameter("nomSeance")))? "" : request.getParameter("nomSeance");
        String profil = ("".equals(request.getParameter("profil")))? "" : request.getParameter("profil");
                
        ServiceSeance seSe = new ServiceSeance();
        //Récupération de l'identifiant de la séance fraichement remplie
        int idSeance = seSe.enrSeance(libelleSeance, profil);
        
        //Mise en session de l'identifiant de la séance
        if(idSeance != 0)
        {
            session.setAttribute("idSeance", idSeance);
        }
        else
        {
            String msg = "Pas de numéro retourné ! ";
            session.setAttribute("idSeance", msg);
        }
        
        //Redirection vers l'étape 2.
        rd = request.getRequestDispatcher("CompleterSeance");
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
