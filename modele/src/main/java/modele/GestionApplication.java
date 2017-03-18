package modele;

import modele.exceptions.ExceptionCoupleLoginPasswordInvalid;
import modele.exceptions.ExceptionUserNotConnected;
import modele.exceptions.ExceptionLoginAlreadyTaken;
import modele.exceptions.ExceptionUserNotRegistered;

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
        this.drugsList = Arrays.asList(Category.names());
    }

    public int registration(String login, String password) throws ExceptionLoginAlreadyTaken {
        for(User user : users.values()){
            if(user.getPseudo().equals(login)){
                throw new ExceptionLoginAlreadyTaken();
            }
        }
        User user = new User(login, password);
        this.users.put(user.getUserId(), user);
        this.idUsers.put(login, user.getUserId());
        return user.getUserId();
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

    public void createPlaylist(int idUser, String userName, String drug, String mood, ArrayList<String> songs, String imageName, String title, String description){

        User user = users.get(idUser);
        Playlist playlist = user.createPlaylist(userName, drug, mood, songs, imageName, title, description);
        user.getUserPlaylists().add(playlist);
        this.playlists.add(playlist);
    }

    public List<String> getDrugsList(){
        return drugsList;
    }

    public List<String> getMoodsListOfDrug(String drug){

        List<String> list = new ArrayList<>();
        for(Subcategory a : Arrays.asList(Subcategory.values())){
            if(a.getCategory().toString().equals(drug))
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

    public Playlist getPlaylistFromId(int idPlaylist){
        for(Playlist playlist : playlists)
            if (idPlaylist == playlist.getIdPlaylist())
                return playlists.get(idPlaylist);
        return null;
    }
    public ArrayList<Playlist> getPlaylistsFromCategory(String category){
        ArrayList<Playlist> list = new ArrayList<>();
        for(Playlist playlist : playlists){
            if(Objects.equals(category, playlist.getCategory().getName()))
                list.add(playlist);
        }
        return list;
    }


    /*public ArrayList<Playlist> getPlaylistsFromCategory(String category){
        ArrayList<String> list = new ArrayList<>();
        for(Playlist playlist : playlists){
            if(Objects.equals(category, playlist.getCategory().toString())){
                list.add()
            }
        }
    }*/



}
