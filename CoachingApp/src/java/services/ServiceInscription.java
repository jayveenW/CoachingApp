/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;
import metier.Client;
import metier.HibernateUtil;
import metier.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NG71392
 */
public class ServiceInscription {

    public boolean insertClient(Client cli) {
        boolean insert = false;
        String nom = cli.getNomCli();
        String prenom = cli.getPrenomClient();
        Date date = cli.getDateNaissanceClient(); // 2018-02-5 
        String mail = cli.getMailClient();
        int tel = cli.getTelephoneClient();
        String mdp = cli.getMotDePasseClient();
        String statut = "En attente"; // En attente, A valider, validé, ancien
                       
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Client cl = new Client(nom, prenom, date, statut, mail, mdp, tel);
            Utilisateur ut = new Utilisateur(nom, prenom, mail, mdp);
            
            session.save(cl);
            session.save(ut);
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return insert;
    }
}
