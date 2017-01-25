package myactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Quentin on 24/01/2017.
 */
public class CreatePlaylist extends MyCommonEnvironnement {



    public ArrayList<Integer> idSongsList;


    @Override
    public String execute(){
        idSongsList = new ArrayList<Integer>();
        //mapSession.put("idSongsList", idSongsList);
        System.out.println("in execute" + idSongsList);
        return SUCCESS;
    }

    public String createPlaylist(){
        System.out.println("in createPlaylist" + idSongsList);
        return SUCCESS;
    }

    public ArrayList<Integer> getIdSongsList() {return idSongsList;}

    public void setIdSongsList(ArrayList<Integer> idSongsList) {this.idSongsList = idSongsList;}








}
