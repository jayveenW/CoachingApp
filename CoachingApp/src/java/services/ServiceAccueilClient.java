/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import metier.Client;
import metier.Exercice;
import metier.HibernateUtil;
import metier.Occseance;
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

    /**
     * Méthode qui récupère des occurences de séance
     *
     * @param cli Objet client
     * @return
     */
    public List<Occseance> getSeances(Client cli) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        int idCli = cli.getIdClient();
        List<Occseance> listSeance = new ArrayList<>();

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Occseance as oc where oc.idOccSeance in "
                    + "(select comp.id.idOccSeance from Composer as comp where comp.id.idSeance in "
                    + "(select C.id.idSeance from Constituer as C where C.id.idSequence in "
                    + "(select Seq.idSequence from Sequence as Seq where Seq.idOccProgramme in "
                    + "(select Si.id.idOccProgramme from Suivre as Si where Si.id.idClient = " + idCli + ")))) order by oc.dateDebut");
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

    /**
     * Méthode qui permet de récupérer un programme
     *
     * @param cli Objet client
     * @return
     */
    public Programme getProgramme(Client cli) {

        Session session = HibernateUtil.openSession();
        Transaction tx;
        int idCli = cli.getIdClient();
        Occurenceprogramme occ;
        Programme prog = null;

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Occurenceprogramme as O where O.idOccProgramme in "
                    + "(select s.id.idOccProgramme from Suivre as s where s.id.idClient = '" + idCli + "')");
            occ = (Occurenceprogramme) query.uniqueResult();
            prog = occ.getProgramme();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL pour retrouver le programme d'un client");
        }

        return prog;
    }

    /**
     * Méthode qui permet de récupérer un ojet séance
     *
     * @param occ oject occurence séance
     * @return
     */
    public Seance getSeance(Occseance occ) {

        Session session = HibernateUtil.openSession();
        Transaction tx;
        int idocc = occ.getIdOccSeance();
        Seance seance = null;

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Seance as s where s.idSeance in "
                    + "(select c.id.idSeance from Composer as c where c.id.idOccSeance = '" + idocc + "')");
            seance = (Seance) query.uniqueResult();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL pour retrouver la séance d'un client");
        }

        return seance;
    }

    /**
     * Permet de récupérer un objet occurence de séance
     *
     * @param idCli l'id d'un client
     * @param date la date de début d'une occurence de séance
     * @return
     */
    public Occseance getSeance(String idCli, String date) {

        Session session = HibernateUtil.openSession();
        Transaction tx;
        Occseance occ = null;

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Occseance as oc where oc.dateDebut = '" + date + "' and oc.idOccSeance in "
                    + "(select comp.id.idOccSeance from Composer as comp where comp.id.idSeance in "
                    + "(select C.id.idSeance from Constituer as C where C.id.idSequence in "
                    + "(select Seq.idSequence from Sequence as Seq where Seq.idOccProgramme in "
                    + "(select Si.id.idOccProgramme from Suivre as Si where Si.id.idClient = " + idCli + ")))) order by oc.dateDebut");
            occ = (Occseance) query.uniqueResult();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL pour retrouver l'occurence de séance d'un client");
        }

        return occ;
    }

    /**
     * Permet de récupérer une liste d'objet Exercice
     *
     * @param idseance l'id d'une séance
     * @return
     */
    public List<Exercice> getExercices(int idseance) {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        List<Exercice> listExo = new ArrayList<>();

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Exercice as e where e.idExercice in "
                    + "(select c.id.idExercice from Composer as c where c.id.idOccSeance = " + idseance + ")");
            listExo = query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur sur la transaction, pb SQL pour retrouver les seances du client");
        }

        return listExo;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        ServiceAccueilClient acc = new ServiceAccueilClient();
        List<Exercice> listExo = acc.getExercices(7);
        for (Exercice e : listExo) {
            System.out.println(e.getLibelleExercice());
        }

    }

}
