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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NG71392
 */
public class ServiceInscription {

    public boolean insertClient(String nom, String prenom, Date date, String mail, String mdp, String tel) {
        boolean insert = false;
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

            insert = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return insert;
    }

    public boolean checkMailAdress(String mail) {
        Session session = HibernateUtil.openSession(); // ouverture de la session hibernate
        Transaction tx = null;
        Utilisateur user = null;
        Boolean result = false;
        try {
            tx = session.getTransaction();
            tx.begin(); // demarre une transaction pour la session
            Query query = session.createQuery("from Utilisateur where mailUtilisateur='" + mail + "'"); // requete HQL
            user = (Utilisateur) query.uniqueResult(); // récupère le seul éléement de la requête (au lieu d'une liste)
            tx.commit(); // commit de la transaction
            
            if (user == null) {
                result = true;
            }
            
        } catch (Exception e) { // gestion de l'erreur
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace(); // affiche l'exception et l'endroit où a eu lieu l'erreur
            System.out.println("Erreur sur la transaction, pb SQL de récupération de l'utilisateur");
        } 
        return result;
    }
}
