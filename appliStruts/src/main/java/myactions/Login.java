package myactions;

import modele.exceptions.ExceptionCoupleLoginPasswordInvalid;
import modele.exceptions.ExceptionUserNotRegistered;

/**
 * Created by Quentin on 18/01/2017.
 */
public class Login extends MyCommonEnvironnement{

    private int idUser;
    private String username;
    private String password;



    private boolean validConnection = false;

    @Override
    public String execute(){
        try {
            this.idUser = this.getMyFacade().connection(username, password);
            validConnection = true;
        } catch (ExceptionUserNotRegistered exceptionUserNotRegistered) {
            return SUCCESS;
        }
        catch (ExceptionCoupleLoginPasswordInvalid exceptionCoupleLoginPasswordInvalid) {
            return SUCCESS;
        }
        return SUCCESS;
    }
    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public boolean isValidConnection() {return validConnection;}

    public void setValidConnection(boolean validConnection) {this.validConnection = validConnection;}
}
