/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import metier.HibernateUtil;
import metier.Seance;
import metier.Sequence;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author OSoro
 * Page servant à stocker les méthode de traitement sur les séquences.
 */
public class ServiceSequence {
    
    /**
     * méthode d'insertion d'une séquence.
     * Etant dans l'ORM Hibernate, l'insertion en BDD ce fait avec un set ou le constructeur
     * @param s
     * @return 
     */
    public static int ajouterSequence(Sequence s){
        
          
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction t = session.beginTransaction();
      
      Sequence seq1 = new Sequence(s.getLibelleSequence(),s.getNbRepetitionSequence(),s.getOrdreSequence());
      
     session.save(seq1);
    
     int id = seq1.getIdSequence();
     t.commit();
     return id;
     
    }
    /**
     * methode servant à conserver en variable de session un objet 
     * @param idSe
     * @return 
     */
    public Seance ObtenirSeance(String idSe) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Seance se = null;
        int idSeInt = Integer.parseInt(idSe);
        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Seance where idSeance = :id ");
            query.setParameter("id", idSeInt);
            se = (Seance) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL d'insertion d'un exo");
        }

        return se;
    }  
       /**
     * Méthode servant à retourner le résultat d'un select en BDD.
     * @return 
     */
    public static List<Sequence> afficherSequence(){
        
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      Transaction t = session.beginTransaction();
      Query q = session.createQuery("from Sequence");
      List<Sequence> result = (List<Sequence>) q.list();
  
      t.commit();
      return result; 
       
    }
    // main de pour tester la requête
   /*  public static void main(String[] args) {
        
          System.out.println("OKK");
          Sequence s =new Sequence();
          s.setLibelleSequence("teste gros");
          s.setOrdreSequence(2);
          s.setNbRepetitionSequence(2);
         ServiceSequence.ajouterSequence(s);
          System.out.println("Jean marc");
    }*/
}



