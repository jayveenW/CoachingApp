package metier;
// Generated 20 f�vr. 2018 21:49:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Profilsportif generated by hbm2java
 */
public class Profilsportif  implements java.io.Serializable {


     private Integer idProfilSportif;
     private String libelleProfilSportif;
     private Set<Client> clients = new HashSet<Client>(0);

    public Profilsportif() {
    }

    public Profilsportif(String libelleProfilSportif, Set<Client> clients) {
       this.libelleProfilSportif = libelleProfilSportif;
       this.clients = clients;
    }
   
    public Integer getIdProfilSportif() {
        return this.idProfilSportif;
    }
    
    public void setIdProfilSportif(Integer idProfilSportif) {
        this.idProfilSportif = idProfilSportif;
    }
    public String getLibelleProfilSportif() {
        return this.libelleProfilSportif;
    }
    
    public void setLibelleProfilSportif(String libelleProfilSportif) {
        this.libelleProfilSportif = libelleProfilSportif;
    }
    public Set<Client> getClients() {
        return this.clients;
    }
    
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.getIdProfilSportif());
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
        final Profilsportif other = (Profilsportif) obj;
        if (!Objects.equals(this.getIdProfilSportif(), other.getIdProfilSportif())) {
            return false;
        }
        return true;
    }




}


