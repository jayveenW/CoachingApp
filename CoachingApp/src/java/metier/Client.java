package metier;
// Generated 20 f�vr. 2018 21:49:57 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Client generated by hbm2java
 */
public class Client implements java.io.Serializable {

    private Integer idClient;
    private Coach coach;
    private String nomCli;
    private String prenomClient;
    private Date dateNaissanceClient;
    private String statutClient;
    private String mailClient;
    private String motDePasseClient;
    private String telephoneClient;
    private String typeAbonnementClient;
    private Integer idProfilSportif;
    private Set<Mesurer> mesurers = new HashSet<Mesurer>(0);
    private Set<Communiquer> communiquers = new HashSet<Communiquer>(0);
    private Set<Profilsportif> profilsportifs = new HashSet<Profilsportif>(0);
    private Set<Occseance> occseances = new HashSet<Occseance>(0);
    private Set<Suivre> suivres = new HashSet<Suivre>(0);
    private Set<Piecejointe> piecejointes = new HashSet<Piecejointe>(0);

    public Client() {
    }

    // Constructeur pour inscription d'un client
    public Client(String nomCli, String prenomClient, Date dateNaissanceClient, String statutClient, String mailClient, String motDePasseClient, String telephoneClient) {
        this.nomCli = nomCli;
        this.prenomClient = prenomClient;
        this.dateNaissanceClient = dateNaissanceClient;
        this.statutClient = statutClient;
        this.mailClient = mailClient;
        this.motDePasseClient = motDePasseClient;
        this.telephoneClient = telephoneClient;
    }
    
    

    public Client(Coach coach, String nomCli, String prenomClient, Date dateNaissanceClient, String statutClient, String mailClient, String motDePasseClient, String telephoneClient, String typeAbonnementClient, Integer idProfilSportif, Set<Mesurer> mesurers, Set<Communiquer> communiquers, Set<Profilsportif> profilsportifs, Set<Occseance> occseances, Set<Suivre> suivres, Set<Piecejointe> piecejointes) {
        this.coach = coach;
        this.nomCli = nomCli;
        this.prenomClient = prenomClient;
        this.dateNaissanceClient = dateNaissanceClient;
        this.statutClient = statutClient;
        this.mailClient = mailClient;
        this.motDePasseClient = motDePasseClient;
        this.telephoneClient = telephoneClient;
        this.typeAbonnementClient = typeAbonnementClient;
        this.idProfilSportif = idProfilSportif;
        this.mesurers = mesurers;
        this.communiquers = communiquers;
        this.profilsportifs = profilsportifs;
        this.occseances = occseances;
        this.suivres = suivres;
        this.piecejointes = piecejointes;
    }

    public Client(String nomCli, String prenomClient, String mailClient, String telephoneClient, String typeAbonnementClient) {
        this.nomCli = nomCli;
        this.prenomClient = prenomClient;
        this.mailClient = mailClient;
        this.telephoneClient = telephoneClient;
        this.typeAbonnementClient = typeAbonnementClient;
    }
    public Client(Integer id, String nomCli, String prenomClient, String mailClient, String telephoneClient, String typeAbonnementClient) {
        this.idClient = id;
        this.nomCli = nomCli;
        this.prenomClient = prenomClient;
        this.mailClient = mailClient;
        this.telephoneClient = telephoneClient;
        this.typeAbonnementClient = typeAbonnementClient;
    }

    public Client(String nomCli, String prenomClient, String mailClient, Date dateNaissance, String telephoneClient, String typeAbonnementClient, String statut) {
        this.nomCli = nomCli;
        this.prenomClient = prenomClient;
        this.mailClient = mailClient;
        this.telephoneClient = telephoneClient;
        this.statutClient =  statut;
        this.dateNaissanceClient = dateNaissance;
        this.typeAbonnementClient = typeAbonnementClient;
    }

    public Integer getIdClient() {
        return this.idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Coach getCoach() {
        return this.coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getNomCli() {
        return this.nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getPrenomClient() {
        return this.prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Date getDateNaissanceClient() {
        return this.dateNaissanceClient;
    }

    public void setDateNaissanceClient(Date dateNaissanceClient) {
        this.dateNaissanceClient = dateNaissanceClient;
    }

    public String getStatutClient() {
        return this.statutClient;
    }

    public void setStatutClient(String statutClient) {
        this.statutClient = statutClient;
    }

    public String getMailClient() {
        return this.mailClient;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    public String getMotDePasseClient() {
        return this.motDePasseClient;
    }

    public void setMotDePasseClient(String motDePasseClient) {
        this.motDePasseClient = motDePasseClient;
    }

    public String getTelephoneClient() {
        return this.telephoneClient;
    }

    public void setTelephoneClient(String telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public String getTypeAbonnementClient() {
        return this.typeAbonnementClient;
    }

    public void setTypeAbonnementClient(String typeAbonnementClient) {
        this.typeAbonnementClient = typeAbonnementClient;
    }

    public Integer getIdProfilSportif() {
        return this.idProfilSportif;
    }

    public void setIdProfilSportif(Integer idProfilSportif) {
        this.idProfilSportif = idProfilSportif;
    }

    public Set<Mesurer> getMesurers() {
        return this.mesurers;
    }

    public void setMesurers(Set<Mesurer> mesurers) {
        this.mesurers = mesurers;
    }

    public Set<Communiquer> getCommuniquers() {
        return this.communiquers;
    }

    public void setCommuniquers(Set<Communiquer> communiquers) {
        this.communiquers = communiquers;
    }

    public Set<Profilsportif> getProfilsportifs() {
        return this.profilsportifs;
    }

    public void setProfilsportifs(Set<Profilsportif> profilsportifs) {
        this.profilsportifs = profilsportifs;
    }

    public Set<Occseance> getOccseances() {
        return this.occseances;
    }

    public void setOccseances(Set<Occseance> occseances) {
        this.occseances = occseances;
    }

    public Set<Suivre> getSuivres() {
        return this.suivres;
    }

    public void setSuivres(Set<Suivre> suivres) {
        this.suivres = suivres;
    }

    public Set<Piecejointe> getPiecejointes() {
        return this.piecejointes;
    }

    public void setPiecejointes(Set<Piecejointe> piecejointes) {
        this.piecejointes = piecejointes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.getIdClient());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.getIdClient(), other.getIdClient())) {
            return false;
        }
        return true;
    }

}
