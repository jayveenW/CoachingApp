package metier;
// Generated 20 f�vr. 2018 16:23:10 by Hibernate Tools 4.3.1



/**
 * Constituer generated by hbm2java
 */
public class Constituer  implements java.io.Serializable {


     private ConstituerId id;
     private Seance seance;
     private Sequence sequence;
     private Integer nbRepetitionSeance;

    public Constituer() {
    }

	
    public Constituer(ConstituerId id, Seance seance, Sequence sequence) {
        this.id = id;
        this.seance = seance;
        this.sequence = sequence;
    }
    public Constituer(ConstituerId id, Seance seance, Sequence sequence, Integer nbRepetitionSeance) {
       this.id = id;
       this.seance = seance;
       this.sequence = sequence;
       this.nbRepetitionSeance = nbRepetitionSeance;
    }
   
    public ConstituerId getId() {
        return this.id;
    }
    
    public void setId(ConstituerId id) {
        this.id = id;
    }
    public Seance getSeance() {
        return this.seance;
    }
    
    public void setSeance(Seance seance) {
        this.seance = seance;
    }
    public Sequence getSequence() {
        return this.sequence;
    }
    
    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }
    public Integer getNbRepetitionSeance() {
        return this.nbRepetitionSeance;
    }
    
    public void setNbRepetitionSeance(Integer nbRepetitionSeance) {
        this.nbRepetitionSeance = nbRepetitionSeance;
    }




}

