package metier;
// Generated 20 f�vr. 2018 21:49:57 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

    private Integer idRole;
    private String libelleRole;
    private Set<Action> actions = new HashSet<Action>(0);
    private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>(0);

    public Role() {
    }

    public Role(String libelleRole) {
        this.libelleRole = libelleRole;
    }

    public Role(String libelleRole, Set<Action> actions, Set<Utilisateur> utilisateurs) {
        this.libelleRole = libelleRole;
        this.actions = actions;
        this.utilisateurs = utilisateurs;
    }

    public Integer getIdRole() {
        return this.idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getLibelleRole() {
        return this.libelleRole;
    }

    public void setLibelleRole(String libelleRole) {
        this.libelleRole = libelleRole;
    }

    public Set<Action> getActions() {
        return this.actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
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
        hash = 61 * hash + Objects.hashCode(this.getIdRole());
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
        final Role other = (Role) obj;
        if (!Objects.equals(this.getIdRole(), other.getIdRole())) {
            return false;
        }
        return true;
    }

}
