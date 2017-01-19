package modele;

/**
 * Created by Quentin on 17/01/2017.
 */
public class Playlist {
    private int idUser = 0;
    private String name;
    private String drug;
    private String mood;

    private static int idPlaylist = 0;

    public Playlist(int idUser, String drug, String mood){
        this.drug = drug;
        this.mood = mood;
    }


}
