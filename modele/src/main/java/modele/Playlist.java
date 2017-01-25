package modele;

import java.util.ArrayList;

/**
 * Created by Quentin on 17/01/2017.
 */
public class Playlist {
    private int idUser;
    private int idPlaylist;
    private String name;
    private Drug drug;
    private Mood mood;
    private ArrayList<Integer> songs;

    private static int identifiant_playlist = 0;

    public Playlist(int idUser, String name, String drug, String mood, ArrayList<Integer>songs){
        this.drug = Drug.valueOf(drug);
        this.mood = Mood.valueOf(mood);
        this.idUser = idUser;
        this.name = name;
        this.idPlaylist = identifiant_playlist;
        this.songs = songs;
        identifiant_playlist++;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

}
