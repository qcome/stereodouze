package modele;

/**
 * Created by Quentin on 17/01/2017.
 */
public enum Mood {
    RASTA ("RASTA", Drug.WEED),
    THUGLIFE ("THUG LIFE", Drug.WEED),
    GANGSTA ("GANGSTA", Drug.COCAINE);

    private String name;
    private Drug drug;

    Mood(String name, Drug drug) {
        this.name = name;
        this.drug = drug;
    }

    public Drug getDrug(){
        return this.drug;
    }




}
