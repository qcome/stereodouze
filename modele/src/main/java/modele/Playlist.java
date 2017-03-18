package modele;

import java.util.ArrayList;

/**
 * Created by Quentin on 17/01/2017.
 */
public class Playlist {
    private int idUser;
    private int idPlaylist;
    private String playlistName;
    private String imageName;
    private Category category;
    private String title;
    private String userName;
    private String description;
    private Subcategory subcategory;

    private ArrayList<String> songs;

    public ArrayList<String> getTitleSongs() {
        return titleSongs;
    }

    public void setTitleSongs(ArrayList<String> titleSongs) {
        this.titleSongs = titleSongs;
    }

    private ArrayList<String> titleSongs;

    public ArrayList<String> getIdSongs() {
        return idSongs;
    }

    public void setIdSongs(ArrayList<String> idSongs) {
        this.idSongs = idSongs;
    }



    private ArrayList<String> idSongs;


    private static int identifiant_playlist = 0;
    private static int identifiant_playlistImage = 0;

    public Playlist(int idUser, String userName, String drug, String mood, ArrayList<String>songs, String imageName, String title, String description){
        this.category = Category.valueOf(drug);
        System.out.println(mood);
        System.out.println(Subcategory.valueOf(mood));

        this.subcategory = Subcategory.valueOf(mood);
        this.idUser = idUser;
        this.userName = userName;
        this.imageName = imageName;
        this.idPlaylist = identifiant_playlist;
        this.songs = songs;
        this.playlistName = title.toUpperCase();
        this.titleSongs = new ArrayList<>();
        this.idSongs = new ArrayList<>();
        this.description = description;
        System.out.println(songs);
        for (String song : songs) {
            this.idSongs.add(song);
        }
        identifiant_playlist++;
        identifiant_playlistImage++;
    }

    public int getIdentifiant_playlistImage(){
        return identifiant_playlistImage;
    }

    public String getPlaylistName() {return playlistName;}

    public void setPlaylistName(String playlistName) {this.playlistName = playlistName;}

    public String getImageName() {return imageName;}

    public void setImageName(String imageName) {this.imageName = imageName;}

    public int getIdPlaylist() {return idPlaylist;}

    public void setIdPlaylist(int idPlaylist) {this.idPlaylist = idPlaylist;}

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}

    public Subcategory getSubcategory() {return subcategory;}

    public void setSubcategory(Subcategory subcategory) {this.subcategory = subcategory;}

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}


}
