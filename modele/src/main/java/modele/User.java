package modele;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Quentin on 17/01/2017.
 */
public class User {
    private int idUser;
    private String username;
    private String passwordUser;
    private Date dateRegister;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private List<Playlist> userPlaylists;

    private static int identifiant = 0;

    public User(String login, String password){
        this.idUser = identifiant;
        this.username = login;
        this.passwordUser = password;
        this.userPlaylists = new ArrayList<>();
        this.dateRegister = new Date();
        identifiant++;
    }

    public String getLoginUser() {return username;}

    public void setLoginUser(String loginUser) {this.username = loginUser;}

    public int getIdUser() {return idUser;}

    public Date getDateRegister(){
        return dateRegister;
    }

    public String getStringDateRegister(){
        return dateFormat.format(dateRegister);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", loginUser='" + username + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                '}';
    }
}
