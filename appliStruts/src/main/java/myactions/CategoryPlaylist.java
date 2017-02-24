package myactions;

/**
 * Created by Quentin on 22/02/2017.
 */
public class CategoryPlaylist extends MyCommonEnvironnement{


    private String category;

    @Override
    public String execute(){
        System.out.println(category);

        return SUCCESS;
    }

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

}
