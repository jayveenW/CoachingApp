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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.HibernateUtil;
import metier.Seance;
import metier.Sequence;
import org.hibernate.Session;
import services.ServiceSequence;

/**
 *
 * @author OSoro
 */
public class ServletAjoutSequence extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            ServiceSequence sequence = new ServiceSequence();
            String Libelle = request.getParameter("Libelle");
            int NbRepet = Integer.parseInt(request.getParameter("NbRepet"));
            int OrdreSeq = Integer.parseInt(request.getParameter("OrdreSeq"));
            
            String[] t = request.getParameterValues("IDSeance");
            List<Seance> l_Seance = new ArrayList();
            for (String re : t){
              l_Seance.add(sequence.ObtenirSeance(re));
            }
            
            try {
            // inisialisation de l'objet avec les datas du formulaire
            Sequence seq = new Sequence();
            
            seq.setLibelleSequence(Libelle);
            seq.setNbRepetitionSequence(NbRepet);
            seq.setOrdreSequence(OrdreSeq);
           
            int id = ServiceSequence.ajouterSequence(seq); //// lancement du service
            // Preparation des variable de session
            session.setAttribute("IdSequence",id );
            session.setAttribute("IdSeances",l_Seance);

        } catch (Exception ex) {
            throw new Exception("Problème d'objet ou bdd " + ex.getMessage());
        }
            // redirection apres l'execution du service
        RequestDispatcher rd = request.getRequestDispatcher("AffecterSeance");
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
            Logger.getLogger(ServletAjoutSequence.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletAjoutSequence.class.getName()).log(Level.SEVERE, null, ex);
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
