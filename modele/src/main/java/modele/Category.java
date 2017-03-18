package modele;

import java.util.Arrays;

/**
 * Created by Quentin on 17/01/2017.
 */
public enum Category {
    DRUG ("DRUG"),
    PARTY ("PARTY"),
    MOTIVATION ("MOTIVATION");

    private String categoryName = "";

    Category(String name){
        this.categoryName = name;
    }

    public String toString(){
        return categoryName;
    }

    public static String[] names() {
        String valuesStr = Arrays.toString(Category.values());
        return valuesStr.substring(1, valuesStr.length()-1).replace(" ", "").split(",");
    }
    public String getName() {return categoryName;}

    public void setName(String categoryName) {this.categoryName = categoryName;}


}
