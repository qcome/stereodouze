package myactions;

import modele.Playlist;

/**
 * Created by Quentin on 06/02/2017.
 */
public class ListenPlaylist extends MyCommonEnvironnement{
    private String userName;
    private int idPlaylist;
    private Playlist playlist;

    @Override
    public String execute(){
        playlist = getMyFacade().getPlaylistFromId(idPlaylist);
        return SUCCESS;
    }

    public String listenPlaylist(){

        return SUCCESS;
    }

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public int getIdPlaylist() {return idPlaylist;}

    public void setIdPlaylist(int idPlaylist) {this.idPlaylist = idPlaylist;}

    public Playlist getPlaylist() {return playlist;}

    public void setPlaylist(Playlist playlist) {this.playlist = playlist;}
}
