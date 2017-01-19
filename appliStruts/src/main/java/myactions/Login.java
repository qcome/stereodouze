package myactions;

/**
 * Created by Quentin on 18/01/2017.
 */
public class Login extends MyCommonEnvironnement{

    private int idUser;
    private String username;
    private String password;

    @Override
    public String execute(){
        this.idUser = this.getMyFacade().connection(username);
        if(username.equals("douze")){
            return ERROR;
        }
        return SUCCESS;
    }
    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
