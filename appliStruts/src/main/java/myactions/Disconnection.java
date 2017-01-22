package myactions;

import modele.exceptions.ExceptionUserNotConnected;

/**
 * Created by Quentin on 20/01/2017.
 */
public class Disconnection extends MyCommonEnvironnement{




    @Override
    public String execute(){
        int idUser;
        if(mapSession.get("idUser") == null)
            return ERROR;
        else
            idUser= (Integer) mapSession.get("idUser");
        try {
            System.out.println("begin disconnection");
            getMyFacade().disconnection(idUser);
            mapSession.remove("userName");
            mapSession.remove("idUser");
            System.out.println("after delete" + mapSession);
        } catch (ExceptionUserNotConnected exceptionUserNotConnected) {
            return ERROR;
        }
        return SUCCESS;
    }
}
