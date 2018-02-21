package metier;
// Generated 20 f�vr. 2018 21:49:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Programme generated by hbm2java
 */
public class Programme  implements java.io.Serializable {


     private Integer idProgramme;
     private String libelleProgramme;
     private Profilsportif profilSportif;
     private Set<Occurenceprogramme> occurenceprogrammes = new HashSet<Occurenceprogramme>(0);

    public Programme() {
    }

    public Programme(String libelleProgramme, Set<Occurenceprogramme> occurenceprogrammes) {
       this.libelleProgramme = libelleProgramme;
       this.occurenceprogrammes = occurenceprogrammes;
    }
   
    public Integer getIdProgramme() {
        return this.idProgramme;
    }
    
    public void setIdProgramme(Integer idProgramme) {
        this.idProgramme = idProgramme;
    }
    public String getLibelleProgramme() {
        return this.libelleProgramme;
    }
    
    public void setLibelleProgramme(String libelleProgramme) {
        this.libelleProgramme = libelleProgramme;
    }

    public Profilsportif getProfilSportif() {
        return profilSportif;
    }

    public void setProfilSportif(Profilsportif profilSportif) {
        this.profilSportif = profilSportif;
    }
    
    
    public Set<Occurenceprogramme> getOccurenceprogrammes() {
        return this.occurenceprogrammes;
    }
    
    public void setOccurenceprogrammes(Set<Occurenceprogramme> occurenceprogrammes) {
        this.occurenceprogrammes = occurenceprogrammes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.getIdProgramme());
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
        final Programme other = (Programme) obj;
        if (!Objects.equals(this.getIdProgramme(), other.getIdProgramme())) {
            return false;
        }
        return true;
    }




}


