package metier;
// Generated 20 f�vr. 2018 16:23:10 by Hibernate Tools 4.3.1



/**
 * SuivreId generated by hbm2java
 */
public class SuivreId  implements java.io.Serializable {


     private int idClient;
     private int numeroSemaine;
     private int annee;
     private int idOccProgramme;

    public SuivreId() {
    }

    public SuivreId(int idClient, int numeroSemaine, int annee, int idOccProgramme) {
       this.idClient = idClient;
       this.numeroSemaine = numeroSemaine;
       this.annee = annee;
       this.idOccProgramme = idOccProgramme;
    }
   
    public int getIdClient() {
        return this.idClient;
    }
    
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public int getNumeroSemaine() {
        return this.numeroSemaine;
    }
    
    public void setNumeroSemaine(int numeroSemaine) {
        this.numeroSemaine = numeroSemaine;
    }
    public int getAnnee() {
        return this.annee;
    }
    
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public int getIdOccProgramme() {
        return this.idOccProgramme;
    }
    
    public void setIdOccProgramme(int idOccProgramme) {
        this.idOccProgramme = idOccProgramme;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SuivreId) ) return false;
		 SuivreId castOther = ( SuivreId ) other; 
         
		 return (this.getIdClient()==castOther.getIdClient())
 && (this.getNumeroSemaine()==castOther.getNumeroSemaine())
 && (this.getAnnee()==castOther.getAnnee())
 && (this.getIdOccProgramme()==castOther.getIdOccProgramme());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdClient();
         result = 37 * result + this.getNumeroSemaine();
         result = 37 * result + this.getAnnee();
         result = 37 * result + this.getIdOccProgramme();
         return result;
   }   


}

