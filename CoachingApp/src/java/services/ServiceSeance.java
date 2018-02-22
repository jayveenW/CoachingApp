/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import metier.Composer;
import metier.ComposerId;
import metier.HibernateUtil;
import metier.Occseance;
import metier.Seance;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Many
 */
public class ServiceSeance {
    public int enrSeance(String ls, String ps) {
        int idSeance = 0;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Seance s = new Seance(ls, ps);
            session.save(s);

            tx.commit();

            idSeance = s.getIdSeance();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return idSeance;

    }
    
    public int recupIdOccSeance(Occseance os)
    {
        int idOccSeance = 0;
        Transaction tx = null;
        try {
            Session session = HibernateUtil.openSession();
            tx = session.getTransaction();
            tx.begin();
            session.save(os);
            idOccSeance = os.getIdOccSeance();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return idOccSeance;
    }
    
    
    public boolean enrComposer(ComposerId coIdList, int nbSerie, int nbRepetition)
    {
        boolean insert = false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            
                Composer com = new Composer(coIdList, nbSerie, nbRepetition);
                session.save(com);
            
            
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
    
    public static void main(String[] args)
    {
        ArrayList<ComposerId> coList = new ArrayList<ComposerId>();
        ServiceSeance ss = new ServiceSeance();
        int id = ss.enrSeance("Tonique", "Cardio");
        System.out.println(id);
        
        ComposerId ci1 = new ComposerId(1, 1, 1, 1);
        System.out.println("oups");
        ComposerId ci2 = new ComposerId(2, 1, 1, 2);
        System.out.println("oups2");
        coList.add(ci1);
        coList.add(ci2);
        
        //ss.enrComposer(coList, 2, 10);
        System.out.println("ça passe ici");
    }
}
