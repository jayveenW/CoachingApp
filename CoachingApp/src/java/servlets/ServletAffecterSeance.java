/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Constituer;
import metier.ConstituerId;
import services.ServiceSeance;

/**
 *
 * @author OSoro
 */
public class ServletAffecterSeance extends HttpServlet {

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
            throws ServletException, IOException, Exception {
            
           // récupération des donneés du formulaire
            int IdSeance = Integer.parseInt(request.getParameter("IDSeance"));
            int IdSequence = Integer.parseInt(request.getParameter("IDSequence"));
            int NbRepet = Integer.parseInt(request.getParameter("NbRepet"));
            int OrdreSeq = Integer.parseInt(request.getParameter("OrdreSeance"));
            int Annee = Integer.parseInt(request.getParameter("Annee"));
            int NumSemaine = Integer.parseInt(request.getParameter("NumSemaine"));
            
            try {
              // inisialisation de l'objet avec les datas du formulaire  
             ConstituerId consid = new ConstituerId();
             Constituer cons = new Constituer();
             cons.setNbRepetitionSeance(NbRepet);
             consid.setIdSeance(IdSeance);
             consid.setIdSequence(IdSequence);
             consid.setAnnee(Annee);
             consid.setNumeroSemaine(NumSemaine);
             consid.setOrdreSeance(OrdreSeq);
             
             // lancement du service
             ServiceSeance.affecterSeance(cons, consid);
             
             } catch (Exception ex) {
            throw new Exception("Problème d'objet ou bdd " + ex.getMessage());
        }
            // redirection apres l'execution du service
        RequestDispatcher rd = request.getRequestDispatcher("AfficherSeance");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletAffecterSeance.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletAffecterSeance.class.getName()).log(Level.SEVERE, null, ex);
        }
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
