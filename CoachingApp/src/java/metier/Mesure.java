package metier;
// Generated 20 f�vr. 2018 16:23:10 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Mesure generated by hbm2java
 */
public class Mesure  implements java.io.Serializable {


     private Integer idMesure;
     private String libelleMesure;
     private Set<Mesurer> mesurers = new HashSet<Mesurer>(0);

    public Mesure() {
    }

    public Mesure(String libelleMesure, Set<Mesurer> mesurers) {
       this.libelleMesure = libelleMesure;
       this.mesurers = mesurers;
    }
   
    public Integer getIdMesure() {
        return this.idMesure;
    }
    
    public void setIdMesure(Integer idMesure) {
        this.idMesure = idMesure;
    }
    public String getLibelleMesure() {
        return this.libelleMesure;
    }
    
    public void setLibelleMesure(String libelleMesure) {
        this.libelleMesure = libelleMesure;
    }
    public Set<Mesurer> getMesurers() {
        return this.mesurers;
    }
    
    public void setMesurers(Set<Mesurer> mesurers) {
        this.mesurers = mesurers;
    }




}

