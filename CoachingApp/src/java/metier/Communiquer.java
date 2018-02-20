package metier;
// Generated 20 f�vr. 2018 16:23:10 by Hibernate Tools 4.3.1



/**
 * Communiquer generated by hbm2java
 */
public class Communiquer  implements java.io.Serializable {


     private CommuniquerId id;
     private Client client;
     private Coach coach;
     private Piecejointe piecejointe;
     private String messageComm;
     private Boolean messageUrgence;

    public Communiquer() {
    }

	
    public Communiquer(CommuniquerId id, Client client, Coach coach, Piecejointe piecejointe) {
        this.id = id;
        this.client = client;
        this.coach = coach;
        this.piecejointe = piecejointe;
    }
    public Communiquer(CommuniquerId id, Client client, Coach coach, Piecejointe piecejointe, String messageComm, Boolean messageUrgence) {
       this.id = id;
       this.client = client;
       this.coach = coach;
       this.piecejointe = piecejointe;
       this.messageComm = messageComm;
       this.messageUrgence = messageUrgence;
    }
   
    public CommuniquerId getId() {
        return this.id;
    }
    
    public void setId(CommuniquerId id) {
        this.id = id;
    }
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    public Coach getCoach() {
        return this.coach;
    }
    
    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    public Piecejointe getPiecejointe() {
        return this.piecejointe;
    }
    
    public void setPiecejointe(Piecejointe piecejointe) {
        this.piecejointe = piecejointe;
    }
    public String getMessageComm() {
        return this.messageComm;
    }
    
    public void setMessageComm(String messageComm) {
        this.messageComm = messageComm;
    }
    public Boolean getMessageUrgence() {
        return this.messageUrgence;
    }
    
    public void setMessageUrgence(Boolean messageUrgence) {
        this.messageUrgence = messageUrgence;
    }




}

