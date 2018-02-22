/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.ComposerId;
import metier.Occseance;
import services.ServiceSeance;

/**
 *
 * @author Many
 */
public class ServletCompleterSeance extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        ServiceSeance seSe = new ServiceSeance();
        //Liste pour récupérer tous les objets ComposerId.
        ArrayList<ComposerId> coIdList = new ArrayList<ComposerId>();
        int idSeance = (int)session.getAttribute("idSeance");
        Occseance os = new Occseance();
        int idOccSeance = seSe.recupIdOccSeance(os);
        System.out.println("Passe ici");
        for(int i = 0; i<7;i++)
        {
            String param = "exercice" + i;
            if(request.getParameter(param).isEmpty())
            {
                System.out.println(param);
                String idExercice = request.getParameter(param);
                int idExo = Integer.parseInt(idExercice);
                ComposerId ciD = new ComposerId(idExo, idOccSeance, idSeance, i);
                coIdList.add(ciD);
            }    
            
        }
        String serie = request.getParameter("nbSerie");
        int nbSerie = Integer.parseInt(serie);
        String repetition = request.getParameter("nbRepetition");
        int nbRepetition = Integer.parseInt(repetition);
        seSe.enrComposer(coIdList, nbSerie, nbRepetition);
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
