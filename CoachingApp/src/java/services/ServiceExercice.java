/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
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

            Query query = session.createQuery("from Categorieexercice where libelleCategorieExercice like '" + catExercice + "'");
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
    
    public List<Categorieexercice> getListeCategorie() {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<Categorieexercice> listeCat = new ArrayList<>();
             
        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Categorieexercice");
            listeCat = query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL d'insertion d'un exo");
        } finally {
            session.close();
        }

        return listeCat;
    }
    
    public List<Exercice> getListeExercice() {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<Exercice> listeCat = new ArrayList<>();
             
        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Exercice");
            listeCat = query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL d'insertion d'un exo");
        }/* finally {
            session.close();
        }*/

        return listeCat;
    }
    
     public static void main (String[] args)
    {
        System.out.println("hello world");
        ServiceExercice se = new ServiceExercice();
        /*List<Categorieexercice> test = se.getListeCategorie();
        for (Categorieexercice cati : test){
            System.out.println(cati.getLibelleCategorieExercice());
        }*/
        /*List<Exercice> test = se.getListeExercice();
        for (Exercice ex : test){
            System.out.println(ex.getCategorieexercice().getLibelleCategorieExercice());
        }*/
        System.out.println(se.recupObjetCatExo("Fessiers").getIdCategorieExercice());
        
    }
}
