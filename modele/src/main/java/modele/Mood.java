package modele;

/**
 * Created by Quentin on 17/01/2017.
 */
public enum Mood {
    RASTA ("RASTA", Drug.DRUG),
    THUGLIFE ("THUGLIFE", Drug.DRUG),
    SPEED ("SPEED", Drug.DRUG),
    POWER ("POWER", Drug.DRUG),
    CHILL ("CHILL", Drug.DRUG),
    ELECTRO ("ELECTRO", Drug.PARTY),
    WTF ("WTF", Drug.PARTY),
    GAMING ("GAMING", Drug.MOTIVATION),
    STUDYING ("STUDYING", Drug.MOTIVATION),
    WORKOUT ("WORKOUT", Drug.MOTIVATION);

    private String name;
    private Drug drug;

    Mood(String name, Drug drug) {
        this.name = name;
        this.drug = drug;
    }

    public Drug getDrug(){
        return this.drug;
    }

    public String getDrugString(){
        return this.drug.toString();
    }




}
