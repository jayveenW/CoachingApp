package metier;
// Generated 20 f�vr. 2018 21:49:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Seance generated by hbm2java
 */
public class Seance  implements java.io.Serializable {


     private Integer idSeance;
     private String libelleSeance;
     private String profilSeance;
     private Set<Composer> composers = new HashSet<Composer>(0);
     private Set<Constituer> constituers = new HashSet<Constituer>(0);

    public Seance() {
    }

	
    public Seance(String libelleSeance) {
        this.libelleSeance = libelleSeance;
    }
    public Seance(String libelleSeance, String profilSeance, Set<Composer> composers, Set<Constituer> constituers) {
       this.libelleSeance = libelleSeance;
       this.profilSeance = profilSeance;
       this.composers = composers;
       this.constituers = constituers;
    }
   
    public Integer getIdSeance() {
        return this.idSeance;
    }
    
    public void setIdSeance(Integer idSeance) {
        this.idSeance = idSeance;
    }
    public String getLibelleSeance() {
        return this.libelleSeance;
    }
    
    public void setLibelleSeance(String libelleSeance) {
        this.libelleSeance = libelleSeance;
    }
    public String getProfilSeance() {
        return this.profilSeance;
    }
    
    public void setProfilSeance(String profilSeance) {
        this.profilSeance = profilSeance;
    }
    public Set<Composer> getComposers() {
        return this.composers;
    }
    
    public void setComposers(Set<Composer> composers) {
        this.composers = composers;
    }
    public Set<Constituer> getConstituers() {
        return this.constituers;
    }
    
    public void setConstituers(Set<Constituer> constituers) {
        this.constituers = constituers;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.getIdSeance());
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
        final Seance other = (Seance) obj;
        if (!Objects.equals(this.getIdSeance(), other.getIdSeance())) {
            return false;
        }
        return true;
    }




}


