package myactions;

import modele.exceptions.ExceptionLoginAlreadyTaken;

/**
 * Created by Quentin on 18/01/2017.
 */
public class Registration extends MyCommonEnvironnement{
    private String username;
    private String password;
    private String passwordConfirmation;

    @Override
    public String execute(){
        try {
            this.getMyFacade().registration(username, password);
        } catch (ExceptionLoginAlreadyTaken exceptionLoginAlreadyTaken) {
            addFieldError("username",getText("Erreur.pseudoalreadytaken"));
            return INPUT;
        }
        return SUCCESS;
    }

    @Override
    public void validate(){
        super.validate();
        if(!password.equals(passwordConfirmation)){
            addFieldError("passwordConfirmation", getText("differentPasswords"));
        }
    }


    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getPasswordConfirmation() {return passwordConfirmation;}

    public void setPasswordConfirmation(String passwordConfirmation) {this.passwordConfirmation = passwordConfirmation;}
}
