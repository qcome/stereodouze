package modele;

import javafx.scene.image.Image;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Quentin on 17/01/2017.
 */
public class User {
    private int userId;
    private String pseudo;
    private String password;
    private String quote;
    private Date registrationDate;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private List<Playlist> userPlaylists;

    private static int cptIdUser = 0;

    public User(String pseudo, String password){
        this.userId = cptIdUser;
        this.pseudo = pseudo;
        this.password = password;
        this.userPlaylists = new ArrayList<>();
        this.registrationDate = new Date();
        cptIdUser++;
    }

    public Playlist createPlaylist(String userName, String drug, String mood, ArrayList<String> songs, String imageName, String title, String description){
        return new Playlist(userId, userName, drug, mood, songs, imageName, title, description);
    }



    public boolean coupleConnectionValid(String pseudo, String password){
        return this.pseudo.equals(pseudo) && this.password.equals(password);
    }

    public void addQuote(String quote){
        this.quote = quote;
    }

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public String getPseudo() {return pseudo;}

    public void setPseudo(String pseudo) {this.pseudo = pseudo;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getQuote() {return quote;}

    public void setQuote(String quote) {this.quote = quote;}

    public Date getRegistrationDate() {return registrationDate;}

    public void setRegistrationDate(Date registrationDate) {this.registrationDate = registrationDate;}

    public List<Playlist> getUserPlaylists() {return userPlaylists;}

    public void setUserPlaylists(List<Playlist> userPlaylists) {this.userPlaylists = userPlaylists;}

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + userId +
                ", loginUser='" + pseudo + '\'' +
                ", passwordUser='" + password + '\'' +
                '}';
    }
}
