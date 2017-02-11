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
            arrayList.add("196510315&I Woks Sound - Toi Qui Me Juge");
            arrayList.add("161651483&I Woks Sound - Passe temps");
            arrayList.add("165097133&Cali P - Herbalist");
            arrayList.add("161504773&Atomic Spliff - Daddy Cookiz - Good Vibes");
            arrayList.add("136482726&Kanka - Stepper Style");
            arrayList.add("83229304&OBF & Warrior Queen - System Ruff part 1");
            arrayList.add("269028970&O.B.F. - Soundman Session feat. Sr. Wilson (LsDirty Rmx Bootleg)");
            arrayList.add("260066954&BURN DEM DOWN Ft Capleton (Evidence Music )");
            arrayList.add("252308912&L'Entourloop Feat. The Architect Skarra Mucci - Dreader Than Dread");
            arrayList.add("139530764&New Generation - Brother Culture - Evidence Music 2014 (SINGLE)");
            arrayList.add("182510150&Le Come Back");
            arrayList.add("234831164&13. Dub.0");
            arrayList.add("234831189&8. Sensi T - Truck Driver");
            arrayList.add("284105196&We All (feat. Jahneration, Phases Cachées, Scars, Yellam, DEF)");
            arrayList.add("89246572&Israel Vibration   Herb Is The Healing");
            arrayList.add("113098217&Alpha Blondy   Wish You Were Here");
            arrayList.add("209204311&L'Entourloop - This Is How We Rock");
            arrayList.add("224299505&Israel Vibration - Back Stabba");
            arrayList.add("89246569&Israel Vibration 'Natty Dread");
            arrayList.add("15658910&8. BARRINGTON LEVY - HERE I COME");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "RASTA", arrayList, "Bob_Marley.jpg", "Keep skanking", "'Get up, stand up, Stand up for your rights. Get up, stand up, Don't give up the fight. '");
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
