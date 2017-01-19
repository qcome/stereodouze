package modele;

import modele.exceptions.ExceptionLoginAlreadyTaken;

import java.util.*;

/**
 * Created by Quentin on 17/01/2017.
 */
public class GestionApplication implements IGestionApplication{

    private Map<Integer, User> users;
    private Map<Integer, User> usersOnline;
    private Map<String, Integer> idUsers;


    private List<Drug> drugsList;
    private Map<Integer, Playlist> usersPlaylists;

    public GestionApplication(){
        this.users = new HashMap<>();
        this.usersPlaylists = new HashMap<>();
        this.idUsers = new HashMap<>();
        this.usersOnline = new HashMap<>();
        this.drugsList = Arrays.asList(Drug.values());
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

    public int connection(String username){
        int idUser = getIdUser(username);
        usersOnline.put(idUser, users.get(idUser));
        return idUser;
    }

    public void createPlaylist(int id, String drug, String mood){
        Playlist playlist = new Playlist(id, drug, mood);
        usersPlaylists.put(id, playlist);
    }

    public List<Drug> getDrugsList(){
        return drugsList;
    }

    public List<Mood> getMoodsListOfDrug(Drug drug){
        List<Mood> list = new ArrayList<>();
        for(Mood a : Arrays.asList(Mood.values())){
            if(a.getDrug().equals(drug))
                list.add(a);
            else
                list.remove(a);
        }
        return list;
    }

    public int getIdUser(String username){
        return idUsers.get(username);
    }

    public Map<Integer, Playlist> getUsersPlaylists() {return usersPlaylists;}

    public Map<Integer, User> getUsers() {return users;}
}
