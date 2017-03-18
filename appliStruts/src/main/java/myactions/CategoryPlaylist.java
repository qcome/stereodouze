package myactions;

import java.util.ArrayList;

/**
 * Created by Quentin on 22/02/2017.
 */
public class CategoryPlaylist extends MyCommonEnvironnement{

    private ArrayList subCategories;
    private String category;

    @Override
    public String execute(){
        System.out.println(category);
        subCategories = (ArrayList) getMyFacade().getMoodsListOfDrug(category);
        return SUCCESS;
    }

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public ArrayList getSubCategories() {return subCategories;}

    public void setSubCategories(ArrayList subCategories) {this.subCategories = subCategories;}

}
