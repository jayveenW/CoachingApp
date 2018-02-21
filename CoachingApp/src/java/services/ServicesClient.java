/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import metier.Client;
import metier.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author OSoro
 */
public class ServicesClient {
    
    public static List<Client> afficherClient(){
        
      
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      Transaction t = session.beginTransaction();
      Query q = session.createQuery("from Client");
      List<Client> result = (List<Client>) q.list();
  
      t.commit();
      return result; 
       
    }
    
//    public static void ajoutClient(Client c){
//       
//         Session session = HibernateUtil.getSessionFactory().openSession();
//      Transaction t = session.beginTransaction();
//      
//     //Client client1 = new Client(c.getNomCli(),c.getPrenomClient(),c.getMailClient(),c.getTelephoneClient(),c.getTypeAbonnementClient());
//     
//     t.commit();
//     session.save(client1);
//     
//    }
     
}