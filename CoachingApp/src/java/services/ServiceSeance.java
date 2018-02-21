/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import metier.HibernateUtil;
import metier.Seance;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Many
 */
public class ServiceSeance {
    public boolean enrSeance(String ls, String ps) {
        boolean insert = false;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Seance s = new Seance(ls, ps);
            session.save(s);

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
    
//    public static void main(String[] args)
//    {
//        System.out.println("Flute ! ");
//        ServiceSeance ss = new ServiceSeance();
//        ss.enrSeance("Haut", "Renf");
//        System.out.println("Zut ! ");
//    }
}
