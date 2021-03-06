/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import metier.Composer;
import metier.ComposerId;
import metier.Constituer;
import metier.ConstituerId;
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
    
    //Cette fonction sert à enregistrer une coquille vide de séance
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
    
    //Cette fonction permet de récupérer un identifiant d'une occurrence
    //fraichement entrée en base de données. 
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
    
    //Cette fonction permet de lier les exercices et les séances en prenant
    //compte le nombre de répétition et de série. 
    public boolean enrComposer(ComposerId coId, int nbSerie, int nbRepetition)
    {
        boolean insert = false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            
                Composer com = new Composer(coId, nbSerie, nbRepetition);
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
    
    /**
     * Méthode servant à retourner le résulta d'un select en BDD.
     * @return 
     */
    public static List<Seance> afficherSeance(){
        
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      Transaction t = session.beginTransaction();
      Query q = session.createQuery("from Seance");
      List<Seance> result = (List<Seance>) q.list();
  
      t.commit();
      return result; 
       
    }
    
    /**
     * méthode servant à l'affectation d'une séance. alimentation d'une table intermédiaire.
     * pour alimenter la table intermédiaire Constituer il est necessaire de passer par le champs ConstituerId qui stock des champs utile
     * qui lui même ne peux pas devenir persistant (ajouter en BDD)
     * il conviens donc d'utiliser la méthode setId qui prend en paramètres l'objet Constituer associer à l'objet ConstituerId contenant les informations voulu
     * Et c'est cet objet Constituer que l'ont rend persistant
     * @param c -> objet Constituer
     * @param cID -> objet ConstituerId
     */
    public static void affecterSeance(Constituer c, ConstituerId cID){
        
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      Transaction t = session.beginTransaction();
      
      ConstituerId cid = new ConstituerId(cID.getOrdreSeance(),cID.getIdSeance(),cID.getIdSequence(),cID.getNumeroSemaine(),cID.getAnnee());
      Constituer con = new Constituer(c.getNbRepetitionSeance());
      con.setId(cid);
      
      session.save(con);
      t.commit();
      
    }
}
