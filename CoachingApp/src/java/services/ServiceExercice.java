/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import metier.Categorieexercice;
import metier.Exercice;
import metier.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitaire.Utilitaire;

/**
 *
 * @author Bastien
 */
public class ServiceExercice {
    public boolean enrExerciceBD(Categorieexercice catEx, String libEx, String nivEx, String descEx, String photoEx, String vidEx, String recoEx) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        boolean enr = false;

        try {
            tx = session.getTransaction();
            tx.begin();

            Exercice exo = new Exercice(catEx, libEx, nivEx, descEx, photoEx, vidEx, recoEx);
            session.save(exo);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL d'insertion d'un exo");
        } finally {
            session.close();
        }

        return enr;
    }

    /**
     * Récupère l'objet catégorie d'une catégorie en string
     *
     * @param catEx
     * @return
     */
    public Categorieexercice recupObjetCatExo(String catEx) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Categorieexercice catExo = null;

        // mettre en CamelCase
        Utilitaire ut = new Utilitaire();
        String catExercice = ut.convertCamelCase(catEx);

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from categorieexercice where libelleCategorieExercice like '" + catExercice + "'");
            catExo = (Categorieexercice) query.uniqueResult();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL d'insertion d'un exo");
        } finally {
            session.close();
        }

        return catExo;
    }
    
    public static ArrayList<Categorieexercice> getListeCategorie() {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        ArrayList<Categorieexercice> listeCat = null;
             
        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from categorieexercice");
            listeCat = (ArrayList<Categorieexercice>) query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL d'insertion d'un exo");
        } finally {
            session.close();
        }

        return listeCat;
    }
    
    public static ArrayList<Exercice> getListeExercice() {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        ArrayList<Exercice> listeExo = null;
             
        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from exercice");
            listeExo = (ArrayList<Exercice>) query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println(e.getMessage());
        /*} finally {
            session.close();
        */}

        return listeExo;
    }
    
     public static void main (String[] args)
    {
        System.out.println("hello world");
        ServiceExercice.getListeExercice();
        System.out.println("oki");
    }
}
