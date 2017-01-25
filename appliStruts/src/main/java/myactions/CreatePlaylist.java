package myactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Quentin on 24/01/2017.
 */
public class CreatePlaylist extends MyCommonEnvironnement {


    private ArrayList<Integer> idSongsList;


    @Override
    public String execute(){
        idSongsList = new ArrayList<Integer>();
        //mapSession.put("idSongsList", idSongsList);
        return SUCCESS;
    }

    public String createPlaylist(){
        int idUser = (Integer) this.mapSession.get("idUser");
        this.getMyFacade().createPlaylist(idUser, "WEED", "RASTA", idSongsList);
        return SUCCESS;
    }

    public ArrayList<Integer> getIdSongsList() {return idSongsList;}

    public void setIdSongsList(ArrayList<Integer> idSongsList) {this.idSongsList = idSongsList;}








}
