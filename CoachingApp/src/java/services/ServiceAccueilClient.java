/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import metier.Client;
import metier.HibernateUtil;
import metier.Occurenceprogramme;
import metier.Programme;
import metier.Seance;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NG71392
 */
public class ServiceAccueilClient {

    public List<Seance> getSeances(Client cli) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        int idCli = cli.getIdClient();
        List<Seance> listSeance = new ArrayList<>();

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Seance as S where S.idSeance in "
                    + "(select C.idSeance from ConstituerId as C where C.idSequence in "
                    + "(select Seq.idSequence from Sequence as Seq where seq.idOccProgramme in "
                    + "(select Si.idOccProgramme from SuivreId as Si where idClient = " + idCli + ")))");
            listSeance = query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL pour retrouver les seances du client");
        } finally {
            session.close();
        }

        return listSeance;
    }

    public Programme getProgramme(Client cli) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        int idCli = cli.getIdClient();
        Occurenceprogramme occ = null;
        Programme prog = null;

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Occurenceprogramme as O where O.idOccProgramme "
                    + "in (Select s.idOccProgramme from SuivreId as s where s.idClient = " + idCli + " )");
            occ = (Occurenceprogramme) query.uniqueResult();
            prog = occ.getProgramme();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL pour retrouver le programme d'un client");
        }

        return prog;
    }

}