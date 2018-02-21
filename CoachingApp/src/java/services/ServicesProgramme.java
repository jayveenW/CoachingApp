/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import metier.HibernateUtil;
import metier.Programme;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author OSoro
 */
public class ServicesProgramme {
     public static List <Programme> afficherProgramme(){
        
      //  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        
        Query q = session.createQuery("from Programme");
        List<Programme> result = q.list();
        System.out.println("On a donc  ---------------- " + result);
        
        
        t.commit();
        session.close();
        return result;
    }
      public static void main(String[] args) {
          System.out.println(ServicesProgramme.afficherProgramme());
    }
     
}
