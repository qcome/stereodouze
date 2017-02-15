package myactions;

/**
 * Created by Quentin on 17/01/2017.
 */
public class Default extends MyCommonEnvironnement {

    @Override
    public String execute(){
        System.out.println(mapSession);

        return SUCCESS;
    }
}
