package modele;

import modele.exceptions.ExceptionCoupleLoginPasswordInvalid;
import modele.exceptions.ExceptionUserNotConnected;
import modele.exceptions.ExceptionLoginAlreadyTaken;
import modele.exceptions.ExceptionUserNotRegistered;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.util.*;

/**
 * Created by Quentin on 17/01/2017.
 */
public class GestionApplication implements IGestionApplication{

    private Map<Integer, User> users;
    private Map<Integer, User> usersOnline;
    private Map<String, Integer> idUsers;


    private List<String> drugsList;
    private Map<Integer, Playlist> usersPlaylists;

    private ArrayList<Playlist> playlists;


    public GestionApplication(){
        this.users = new HashMap<>();
        this.usersPlaylists = new HashMap<>();
        this.idUsers = new HashMap<>();
        this.usersOnline = new HashMap<>();
        this.playlists = new ArrayList<>();
        this.drugsList = Arrays.asList(Drug.names());
    }

    public int registration(String login, String password) throws ExceptionLoginAlreadyTaken {
        for(User user : users.values()){
            if(user.getLoginUser().equals(login)){
                throw new ExceptionLoginAlreadyTaken();
            }
        }
        User user = new User(login, password);
        this.users.put(user.getIdUser(), user);
        this.idUsers.put(login, user.getIdUser());
        return user.getIdUser();
    }

    public int connection(String username, String password) throws ExceptionUserNotRegistered, ExceptionCoupleLoginPasswordInvalid {
        try {
            int idUser = getIdUser(username);
            User user = this.users.get(idUser);
            if (user.coupleConnectionValid(username, password))
                usersOnline.put(idUser, users.get(idUser));
            else
                throw new ExceptionCoupleLoginPasswordInvalid();
        } catch (ExceptionUserNotRegistered exceptionUserNotRegistered) {
        }
        return getIdUser(username);
    }

    public void disconnection(int idUser) throws ExceptionUserNotConnected {
        if(usersOnline.containsKey(idUser))
            usersOnline.remove(idUser);
        else
            throw new ExceptionUserNotConnected();
    }

    public void createPlaylist(int idUser, String drug, String mood, ArrayList<Integer> songs){
        System.out.println("idUser = " + idUser);
        System.out.println("drug = " + drug);
        System.out.println("mood = " + mood);
        Playlist playlist = new Playlist(idUser, drug, mood, songs);
        User user = usersOnline.get(idUser);
        user.getUserPlaylists().add(playlist);
        this.playlists.add(playlist);
    }

    public List<String> getDrugsList(){
        return drugsList;
    }

    public List<String> getMoodsListOfDrug(String drug){
        List<String> list = new ArrayList<>();
        for(Mood a : Arrays.asList(Mood.values())){
            if(a.getDrugString().equals(drug))
                list.add(a.toString());
            else
                list.remove(a.toString());
        }
        return list;
    }

    public int getIdUser(String username) throws ExceptionUserNotRegistered {
        if(idUsers.containsKey(username))
            return idUsers.get(username);
        else
            throw new ExceptionUserNotRegistered();
    }

    public Map<Integer, Playlist> getUsersPlaylists() {return usersPlaylists;}

    public ArrayList<Playlist> getPlaylists() {return playlists;}



}
