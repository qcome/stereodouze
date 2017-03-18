package modele;

/**
 * Created by Quentin on 17/01/2017.
 */
public enum Subcategory {
    RASTA ("RASTA", Category.DRUG),
    THUGLIFE ("THUGLIFE", Category.DRUG),
    SPEED ("SPEED", Category.DRUG),
    POWER ("POWER", Category.DRUG),
    CHILL ("CHILL", Category.DRUG),
    ELECTRO ("ELECTRO", Category.PARTY),
    WTF ("WTF", Category.PARTY),
    GAMING ("GAMING", Category.MOTIVATION),
    STUDYING ("STUDYING", Category.MOTIVATION),
    WORKOUT ("WORKOUT", Category.MOTIVATION);

    private String subcategoryName;
    private Category category;

    Subcategory(String subcategoryName, Category category) {
        this.subcategoryName = subcategoryName;
        this.category = category;
    }

    public Category getCategory(){return this.category;}

    public String getSubcategoryName() {return subcategoryName; }

    public void setSubcategoryName(String subcategoryName) {this.subcategoryName = subcategoryName;}

    public void setCategory(Category category) {this.category = category;}




}
