package modele;

import java.util.ArrayList;

/**
 * Created by Quentin on 17/01/2017.
 */
public class Playlist {
    private int idUser;



    private int idPlaylist;
    private String name = "douze";

    private String imageName;
    private Drug drug;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;


    private Mood mood;

    public ArrayList<Integer> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Integer> songs) {
        this.songs = songs;
    }

    private ArrayList<Integer> songs;

    private static int identifiant_playlist = 0;

    public Playlist(int idUser, String userName, String drug, String mood, ArrayList<Integer>songs, String imageName){
        this.drug = Drug.valueOf(drug);
        this.mood = Mood.valueOf(mood);
        this.idUser = idUser;
        this.userName = userName;
        this.imageName = imageName;
        //this.name = name;
        this.idPlaylist = identifiant_playlist;
        this.songs = songs;
        identifiant_playlist++;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getImageName() {return imageName;}

    public void setImageName(String imageName) {this.imageName = imageName;}

    public int getIdPlaylist() {return idPlaylist;}

    public void setIdPlaylist(int idPlaylist) {this.idPlaylist = idPlaylist;}

    public Drug getDrug() {return drug;}

    public void setDrug(Drug drug) {this.drug = drug;}

    public Mood getMood() {return mood;}

    public void setMood(Mood mood) {this.mood = mood;}

}
