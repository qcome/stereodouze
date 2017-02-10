package myactions;

import com.opensymphony.xwork2.ActionSupport;
import modele.GestionApplication;
import modele.exceptions.ExceptionLoginAlreadyTaken;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Quentin on 17/01/2017.
 */
public class MyCommonEnvironnement extends ActionSupport implements ApplicationAware, SessionAware {

    static String MYFACADE = "myFacade";

    GestionApplication myFacade;
    Map<String,Object> mapSession;


    @Override
    public void setApplication(Map<String, Object> map) {
        this.myFacade = (GestionApplication)map.get(MYFACADE);
        if(this.myFacade == null){
            this.myFacade = new GestionApplication();
            map.put(MYFACADE, myFacade);
            //create admin
            try {
                this.myFacade.registration("admin", "aaa");
            } catch (ExceptionLoginAlreadyTaken exceptionLoginAlreadyTaken) {
                exceptionLoginAlreadyTaken.printStackTrace();
            }
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("175829885&Naâman - Reggae Sun Scoop (Riddim By Fatbabs)");
            arrayList.add("214145215&Naâman - Outta Road");
            arrayList.add("169858600&Naâman - Runaway (Pretty Looks Riddim)");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "RASTA", arrayList, "NudBvhgu.jpg", "Keep Skanking", "vive la weed lel");
            ArrayList<String> al = new ArrayList<String>();
            al.add("234519715&MALAA - Notorious *Free Download*");
            al.add("270169350&Malaa - Diamonds*");
            al.add("203882029&Major Lazer & DJ Snake (Feat.  MØ) - Lean On (Malaa Remix)");
            al.add("283785673&TCHAMI & MALAA - Prophecy");
            al.add("220096510&Pregnant (Original Mix)");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "POWER", al, "user_playlists.playlist_image.bf837bd7f0e08760.68616d6275726765722e6a7067_thumb.jpg", "GHouse oklm", "#yolo");
            map.put("playlists", myFacade.getPlaylists());
        }
        //actualisation playlists
        map.put("playlists", myFacade.getPlaylists());
    }

    @Override
    public void setSession(Map<String, Object> map) {this.mapSession = map;}



    public GestionApplication getMyFacade() {return myFacade;}
}
