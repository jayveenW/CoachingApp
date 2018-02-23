/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.HibernateUtil;
import metier.Profilsportif;
import metier.Programme;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.ServicesProgramme;

/**
 *
 * @author OSoro
 */
public class ServletAjouterProgramme extends HttpServlet {

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
        String Libelle = request.getParameter("Libelle");
        String Profil = request.getParameter("Profil");
        
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      Transaction t = session.beginTransaction();
      Query q = session.createQuery("from Profilsportif where libelleProfilSportif =" + Profil);
      
        try {
            // inisialisation de l'objet avec les datas du formulaire 
             Profilsportif result = (Profilsportif) q.uniqueResult();
             HashSet<Profilsportif> l_prg = new HashSet();
             Programme p  = new Programme();
             p.setLibelleProgramme(Libelle);
             p.getProfilSportifs().add(result);
             p.setProfilSportifs(l_prg);
             
             // lancement du service
             ServicesProgramme.ajoutProgramme(p);
              
            } 
        catch (Exception ex) {
            throw new Exception("Problème d'objet ou bdd "+ex.getMessage()); 
            }
           // redirection apres l'execution du service
         RequestDispatcher rd = request.getRequestDispatcher("AfficherProgramme");
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
            Logger.getLogger(ServletAjouterProgramme.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletAjouterProgramme.class.getName()).log(Level.SEVERE, null, ex);
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
