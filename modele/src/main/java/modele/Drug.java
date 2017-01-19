package modele;

import java.util.List;

/**
 * Created by Quentin on 17/01/2017.
 */
public enum Drug {
    WEED ("WEED"),
    EXTASY ("EXTASY"),
    COCAINE ("COCAINE");

    private String name = "";

    Drug(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
