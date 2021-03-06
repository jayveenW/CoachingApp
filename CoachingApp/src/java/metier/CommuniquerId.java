package metier;
// Generated 20 f�vr. 2018 21:49:57 by Hibernate Tools 4.3.1



/**
 * CommuniquerId generated by hbm2java
 */
public class CommuniquerId  implements java.io.Serializable {


     private int idClient;
     private int idCoach;
     private int idPieceJointe;

    public CommuniquerId() {
    }

    public CommuniquerId(int idClient, int idCoach, int idPieceJointe) {
       this.idClient = idClient;
       this.idCoach = idCoach;
       this.idPieceJointe = idPieceJointe;
    }
   
    public int getIdClient() {
        return this.idClient;
    }
    
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public int getIdCoach() {
        return this.idCoach;
    }
    
    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }
    public int getIdPieceJointe() {
        return this.idPieceJointe;
    }
    
    public void setIdPieceJointe(int idPieceJointe) {
        this.idPieceJointe = idPieceJointe;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CommuniquerId) ) return false;
		 CommuniquerId castOther = ( CommuniquerId ) other; 
         
		 return (this.getIdClient()==castOther.getIdClient())
 && (this.getIdCoach()==castOther.getIdCoach())
 && (this.getIdPieceJointe()==castOther.getIdPieceJointe());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdClient();
         result = 37 * result + this.getIdCoach();
         result = 37 * result + this.getIdPieceJointe();
         return result;
   }   


}


