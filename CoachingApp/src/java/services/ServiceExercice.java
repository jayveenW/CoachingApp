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
    /**
     * 
     * @param p_catEx
     * @param p_libEx
     * @param p_nivEx
     * @param p_descEx
     * @param p_photoEx
     * @param p_vidEx
     * @param p_recoEx
     * @return 
     */
    public boolean enrExerciceBD(Categorieexercice p_catEx, String p_libEx, String p_nivEx, String p_descEx, String p_photoEx, String p_vidEx, String p_recoEx) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        boolean enr = false;

        try {
            tx = session.getTransaction();
            tx.begin();
            /*Création d'une nouvelle instance d'exercice avant de la passer en paramètre
            de la fonction save
            */
            Exercice exo = new Exercice(p_catEx, p_libEx, p_nivEx, p_descEx, p_photoEx, p_vidEx, p_recoEx);
            session.save(exo);

            tx.commit();
            enr = true;
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
     * Modification d'un exercice en BD
     * @param p_idEx
     * @param p_catEx
     * @param p_libEx
     * @param p_nivEx
     * @param p_descEx
     * @param p_photoEx
     * @param p_vidEx
     * @param p_recoEx
     * @return 
     */
    public boolean modifExerciceBD(int p_idEx, Categorieexercice p_catEx, String p_libEx, String p_nivEx, String p_descEx, String p_photoEx, String p_vidEx, String p_recoEx) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        boolean enr = false;
        try {
            tx = session.getTransaction();
            tx.begin();
            //récupération de l'exercice grâce au session.get et grâce à l'id en paramètre
            Exercice exo = (Exercice)session.get(Exercice.class, p_idEx);
            //méthode setGlobal : regroupe tous les setters de la classe Exercice qui sont utiles ici
            exo.setGlobal(p_catEx, p_libEx, p_nivEx, p_descEx, p_photoEx, p_vidEx, p_recoEx);
            session.update(exo);
            tx.commit();
            enr = true;
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
     * Suppresion d'un exercice dans la BD grâce à son idée
     * @param idEx
     * @return 
     */
    public boolean supprExerciceBD(int p_idEx) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        boolean enr = false;
        try {
            tx = session.getTransaction();
            tx.begin();
            //récupération de l'exercice dans une variable locale afin de pouvoir le supprimer par la suite
            Exercice exo = (Exercice)session.get(Exercice.class, p_idEx);
            session.delete(exo);
            tx.commit();
            enr = true;
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
     * @param p_catEx
     * @return
     */
    public Categorieexercice recupObjetCatExo(String p_catEx) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Categorieexercice catExo = null;

        // mettre en CamelCase
        Utilitaire ut = new Utilitaire();
        String catExercice = ut.convertCamelCase(p_catEx);

        try {
            tx = session.getTransaction();
            tx.begin();
            //récupération d'une Catégorie d'exercice grâce à une condition SQL sur le libellé
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
    
    /**
     * Fonction qui renvoie l'intégralité des catégories d'exercices en BD
     * @return 
     */
    public List<Categorieexercice> getListeCategorie() {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        //instanciation de l'objet de retour
        List<Categorieexercice> listeCat = new ArrayList<>();
             
        try {
            tx = session.getTransaction();
            tx.begin();
            //Requête de sélection des catégories
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
    
    /**
     * Fonction qui récupère l'intégralité des exercices en BD
     * @return 
     */
    public List<Exercice> getListeExercice() {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        //instanciation de l'objet de retour
        List<Exercice> listeExo = new ArrayList<>();
             
        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Exercice");
            listeExo = query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL d'insertion d'un exo");
        }/* finally {
            session.close();
        }*/

        return listeExo;
    }
    
    /**
     * Fonction qui récupère un exercice en fonction de son id
     * @param idEx
     * @return 
     */
    public Exercice getExercice(String idEx) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Exercice exo = null;
        //Conversion de l'id du type String au type entier
        int idExInt = Integer.parseInt(idEx);
        try {
            tx = session.getTransaction();
            tx.begin();
            //Requête Hibernate avec condition sur l'id de l'exercice
            Query query = session.createQuery("from Exercice where idExercice = :id ");
            query.setParameter("id", idExInt);
            exo = (Exercice) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL d'insertion d'un exo");
        }/* finally {
            session.close();
        }*/

        return exo;
    }
    
     /*public static void main (String[] args)
    {
        System.out.println("hello world");
        ServiceExercice se = new ServiceExercice();
        List<Categorieexercice> test = se.getListeCategorie();
        for (Categorieexercice cati : test){
            System.out.println(cati.getLibelleCategorieExercice());
        }
        List<Exercice> test = se.getListeExercice();
        for (Exercice ex : test){
            System.out.println(ex.getCategorieexercice().getLibelleCategorieExercice());
        }
        
        System.out.println(se.getExercice("1").getLibelleExercice());
        
    }*/
}
