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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServicesClient;

/**
 *
 * @author OSoro
 */
public class ServletAjouterClient extends HttpServlet {

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
        // Date d = new SimpleDateFormat("yyyy/MM/DD");

        String Nom = request.getParameter("Nom");
        String Prenom = request.getParameter("Prenom");
        String Mail = request.getParameter("Mail");
        String ageNonParse = request.getParameter("Age");
        // int Telephone = Integer.parseInt(request.getParameter("Telephone"));
        String Telephone = request.getParameter("Telephone");
        Integer Profil = Integer.parseInt(request.getParameter("Profil"));
        String Typeab = request.getParameter("Typeab");

        try {
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            Date Age = new Date();
            try{
            Age = df.parse(ageNonParse);}
            catch(ParseException e){
                System.out.println(e);
            }
            Client cli = new Client();
            cli.setNomCli(Nom);
            cli.setPrenomClient(Prenom);
            cli.setMailClient(Mail);
            cli.setTelephoneClient(Telephone);
            cli.setDateNaissanceClient(Age);
            //cli.getProfilsportifs().add();
            cli.setTypeAbonnementClient(Typeab);
            cli.setStatutClient("En attente");
            ServicesClient.ajoutClient(cli);

        } catch (Exception ex) {
            throw new Exception("Problème d'objet ou bdd " + ex.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("AfficherClient");
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
            Logger.getLogger(ServletAjouterClient.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletAjouterClient.class.getName()).log(Level.SEVERE, null, ex);
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
