/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import metier.HibernateUtil;
import metier.Programme;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author OSoro
 * Page servant à stocker les méthode de traitement sur les programme.
 */
public class ServicesProgramme {
    
    /**
     * Méthode servant à retourner le résultat d'un select en BDD.
     * @return 
     */
    public static List <Programme> afficherProgramme(){
        
      //  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Query q = session.createQuery("from Programme");
        List<Programme> result = q.list();
        
        
        t.commit();
      
        return result;
    }
     
    /**
     * méthode d'insertion d'un programme.
     * Etant dans l'ORM Hibernate, l'insertion en BDD ce fait avec un set ou le constructeur
     * @param s
     * @return 
     */
     public static void ajoutProgramme(Programme p){
       
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction t = session.beginTransaction();
      
     Programme prog1 = new Programme(p.getProfilSportifs(),p.getLibelleProgramme());
    
     session.save(prog1);
     t.commit();
     
     
    }
     // main de teste de la requete
     /* public static void main(String[] args) {
        
          System.out.println("OKK");
         Programme p = new Programme();
         p.getProfilSportifs().add()
         ServicesProgramme.ajoutProgramme(p);
          System.out.println("Jean marc");
    }*/
     
}
