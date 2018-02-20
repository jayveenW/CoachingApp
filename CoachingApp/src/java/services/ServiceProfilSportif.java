/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import metier.HibernateUtil;
import metier.Profilsportif;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NG71392
 */
public class ServiceProfilSportif {

    /**
     * Recupere la liste des profils sportifs
     *
     * @return
     */
    public List<Profilsportif> recupProfils() {
        List<Profilsportif> profils = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Profilsportif");
            profils = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } 

        return profils;
    }
    
}
