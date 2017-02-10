package modele;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Quentin on 17/01/2017.
 */
public enum Drug {
    DRUG ("DRUG"),
    PARTY ("PARTY"),
    MOTIVATION ("MOTIVATION");

    private String name = "";

    Drug(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public static String[] names() {
        String valuesStr = Arrays.toString(Drug.values());
        return valuesStr.substring(1, valuesStr.length()-1).replace(" ", "").split(",");
    }

}
