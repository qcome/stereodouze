package myactions;

import modele.exceptions.ExceptionUserNotConnected;

/**
 * Created by Quentin on 20/01/2017.
 */
public class Disconnection extends MyCommonEnvironnement{




    @Override
    public String execute(){
        int idUser = (Integer) mapSession.get("idUser");
        try {
            getMyFacade().disconnection(idUser);
        } catch (ExceptionUserNotConnected exceptionUserNotConnected) {
            return ERROR;
        }
        return SUCCESS;
    }
}
