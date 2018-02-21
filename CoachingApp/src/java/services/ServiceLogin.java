/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import metier.HibernateUtil;
import metier.Role;
import metier.Utilisateur;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NG71392
 */
public class ServiceLogin {

    /**
     * Permet de savoir si l'utilisateur est authentifié
     *
     * @param userId le mail qui sert d'identifiant pour un utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return
     */
    public boolean authenticateUser(String userId, String password) {
        Utilisateur user = getUserByUserId(userId);
        if (user != null && user.getMailUtilisateur().equals(userId) && user.getMpdUtilisateur().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Requete qui permet de récupérer l'utilisateur pour le mail en entré
     *
     * @param userId le mail qui sert d'identifiant pour un utilisateur
     * @return
     */
    public Utilisateur getUserByUserId(String userId) {
        Session session = HibernateUtil.openSession(); // ouverture de la session hibernate
        Transaction tx = null;
        Utilisateur user = null;
        try {
            tx = session.getTransaction();
            tx.begin(); // demarre une transaction pour la session
            Query query = session.createQuery("from Utilisateur where mailUtilisateur='" + userId + "'"); // requete HQL
            user = (Utilisateur) query.uniqueResult(); // récupère le seul éléement de la requête (au lieu d'une liste)
            tx.commit(); // commit de la transaction
        } catch (Exception e) { // gestion de l'erreur
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace(); // affiche l'exception et l'endroit où a eu lieu l'erreur
            System.out.println("Erreur sur la transaction, pb SQL de récupération de l'utilisateur");
        }
        return user;
    }

    /**
     * Récupère la liste des utilisateurs
     *
     * @return
     */
    public List<Utilisateur> getListOfUsers() {
        List<Utilisateur> list = new ArrayList<>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Utilisateur");
            list = query.list(); // ici on ne récupère pas un seul résultat mais une liste d'objet Utilisateur
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } 
        return list;
    }

    public Role getRoleUtilisateur(Utilisateur user) {

        Session session = HibernateUtil.openSession(); 
        Transaction tx = null;
        Role role = null;
        int idUser = user.getIdUtilisateur();
        
        try {
            tx = session.getTransaction();
            tx.begin(); 
            Query query = session.createQuery("from role as r where r.idRole in (select a.idRole from avoir as a where a.idUtilisateur ='" + idUser + "'");
            role = (Role) query.uniqueResult();
            tx.commit();
        } catch (Exception e) { 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL de récupération du role de l'utilisateur");
        }
        return role;
    }
}
