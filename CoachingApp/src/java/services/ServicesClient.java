/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;
import java.util.List;
import metier.Client;
import metier.HibernateUtil;
import metier.Profilsportif;
import metier.Utilisateur;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author OSoro
 */
public class ServicesClient {
    
    /**
     * Méthode servant à retourner le résultat d'un select en BDD.
     * @return 
     */
    public static List<Client> afficherClient() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("from Client");
        List<Client> result = (List<Client>) q.list();

        t.commit();
        return result;

    }
    
    public static void ajoutClientAdmin(Client c) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        Client client1 = new Client(c.getNomCli(), c.getPrenomClient(), c.getMailClient(),c.getDateNaissanceClient(), c.getTelephoneClient(), c.getTypeAbonnementClient(), c.getStatutClient());

        session.save(client1);
        t.commit();

    }

    public boolean ajoutClient(String nomCli, String prenomCli, String mailCli, String tel, Date age, String typeAb, String profil) {

        boolean insert = false;
        String statut = "En attente"; // En attente, A valider, validé, ancien
        String mdp = "temporaire";

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();

            Client cl = new Client(nomCli, prenomCli, mailCli, age, tel, typeAb, statut);
            Utilisateur ut = new Utilisateur(nomCli, prenomCli, mailCli, mdp);

            Profilsportif ps = ServicesClient.getObjProfilSportif(profil);
            cl.getProfilsportifs().add(ps);
            
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

    public static Profilsportif getObjProfilSportif(String s) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("from Profilsportif where libelleProfilSportif = '" + s + "'");
        Profilsportif result = (Profilsportif) q.uniqueResult();

        t.commit();
        return result;

    }

    // Main, programme de test
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        try {
            Client client1 = new Client("Jean Jaques", "Bernard", "jjb@gmail.com", "0106050401", "Anuel");
            System.out.println("*************************************Terminer***********************");
            session.save(client1);
            t.commit();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

    }

}
