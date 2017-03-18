package modele;

/**
 * Created by Quentin on 10/03/2017.
 */
public class MyImage {
    private String imageId;
    private boolean isPlaylistImage;
    private boolean isUserImage;

    private static int identifiant_playlist_image = 1;
    private static int identifiant_user_image = 1;

    public MyImage(String string, String imageName){
        if (string.equals("playlist")) {
            isPlaylistImage = true;
            isUserImage = false;

        }else {
            isPlaylistImage = true;
            isUserImage = false;
        }
    }


}
