/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import metier.HibernateUtil;
import metier.Occurenceprogramme;
import metier.Programme;
import metier.Seance;
import metier.Sequence;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceProgramme {

    /** 
     * Récupère une liste d'objet programme
     * @return 
     */
    public List<Programme> recupProgrammes() {
        List<Programme> programme = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from programme");
            programme = query.list();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return programme;
    }

    /**
     * Permet d'insérer un programme
     * @param programme objet programme
     * @return 
     */
    public boolean insertProgramme(Programme programme) {

        boolean insert = false;
        String etatOccProgramme = "Défaut"; // = Programme type non affecté à des clients pour l'instant

        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();

            Occurenceprogramme op = new Occurenceprogramme();

            programme.getOccurenceprogrammes();

            session.save(op);

            tx.commit();

            insert = true;

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

    /** 
     * permet d'insérer une séquence
     * @param programme objet programme
     * @param sequence objet séquence
     * @return 
     */
    public boolean insertSequence(Programme programme, Sequence sequence) {

        boolean insert = false;
        String etatOccProgramme = "Défaut"; // = Programme type non affecté à des clients pour l'instant

        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();

            Occurenceprogramme op = new Occurenceprogramme();

            programme.getOccurenceprogrammes();

            session.save(op);

            tx.commit();

            insert = true;

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

    /**
     * Permet d'insérer une séance pour un programme, une sequence, une seance
     * @param programme
     * @param sequence
     * @param seance
     * @return 
     */
    public boolean insertSeance(Programme programme, Sequence sequence, Seance seance) {

        boolean insert = false;
        String etatOccProgramme = "Défaut"; // = Programme type non affecté à des clients pour l'instant

        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();

            Occurenceprogramme op = new Occurenceprogramme();

            programme.getOccurenceprogrammes();

            session.save(op);

            tx.commit();

            insert = true;

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
