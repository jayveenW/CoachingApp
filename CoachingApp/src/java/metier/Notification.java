package metier;
// Generated 20 f�vr. 2018 21:49:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Notification generated by hbm2java
 */
public class Notification  implements java.io.Serializable {


     private Integer idNotification;
     private String messageNotification;
     private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>(0);

    public Notification() {
    }

    public Notification(String messageNotification, Set<Utilisateur> utilisateurs) {
       this.messageNotification = messageNotification;
       this.utilisateurs = utilisateurs;
    }
   
    public Integer getIdNotification() {
        return this.idNotification;
    }
    
    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }
    public String getMessageNotification() {
        return this.messageNotification;
    }
    
    public void setMessageNotification(String messageNotification) {
        this.messageNotification = messageNotification;
    }
    public Set<Utilisateur> getUtilisateurs() {
        return this.utilisateurs;
    }
    
    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.getIdNotification());
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
        final Notification other = (Notification) obj;
        if (!Objects.equals(this.getIdNotification(), other.getIdNotification())) {
            return false;
        }
        return true;
    }




}


