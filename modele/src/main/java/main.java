import modele.GestionApplication;
import modele.exceptions.ExceptionLoginAlreadyTaken;

/**
 * Created by Quentin on 17/01/2017.
 */
public class main {
    public static void main(String []args){
        GestionApplication application = new GestionApplication();
        try {


            int user1 = application.registration("daaaouze", "douze");
            int user2 = application.registration("aaa", "douze");
            application.createPlaylist(user1, "WEED", "RASTA");

        } catch (ExceptionLoginAlreadyTaken exceptionLoginAlreadyTaken) {
            exceptionLoginAlreadyTaken.printStackTrace();
        }
    }
}
