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
            arrayList.add("196510315");
            arrayList.add("161651483");
            arrayList.add("165097133");
            arrayList.add("161504773");
            arrayList.add("136482726");
            arrayList.add("83229304");
            arrayList.add("269028970");
            arrayList.add("260066954");
            arrayList.add("252308912");
            arrayList.add("139530764");
            arrayList.add("182510150");
            arrayList.add("234831164");
            arrayList.add("234831189");
            arrayList.add("284105196");
            arrayList.add("89246572");
            arrayList.add("113098217");
            arrayList.add("209204311");
            arrayList.add("224299505");
            arrayList.add("89246569");
            arrayList.add("15658910");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "RASTA", arrayList, "album-art11.jpg", "Keep skanking", "'Get up, stand up, Stand up for your rights. Get up, stand up, Don't give up the fight. '");
            ArrayList<String> al = new ArrayList<String>();
            al.add("234519715");
            al.add("270169350");
            al.add("203882029");
            al.add("283785673");
            al.add("220096510");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "POWER", al, "album-covers-05.jpg", "GHouse oklm", "#yolo");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "POWER", al, "HOPE-1024x1024.jpg", "GHouse oklm", "#yolo");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "POWER", al, "insurgency-digital-album-cover-design.jpg", "GHouse oklm", "#yolo");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "POWER", al, "Joy-Division-Unknown-Pleasures-album-covers-billboard-1000x1000.jpg", "GHouse oklm", "#yolo");
            this.myFacade.createPlaylist(0, "admin", "DRUG", "POWER", al, "pusha-t-darkest-before-dawn-album-cover-full-size.jpg", "GHouse oklm", "#yolo");
            this.myFacade.createPlaylist(0, "admin", "PARTY", "WTF", al, "pusha-t-darkest-before-dawn-album-cover-full-size.jpg", "GHouse oklm", "#yolo");
            ArrayList<String> aze = new ArrayList<String>();
            aze.add("289036800");
            aze.add("202122606");
            this.myFacade.createPlaylist(0, "admin", "MOTIVATION", "WORKOUT", aze, "the-boxer-rebellion-ocean-by-ocean-album-cover-full-size.jpg", "Zoubida", "Sacré Lagaf!");
            this.myFacade.createPlaylist(0, "admin", "MOTIVATION", "WORKOUT", aze, "Joy-Division-Unknown-Pleasures-album-covers-billboard-1000x1000.jpg", "Zoubida", "Sacré Lagaf!");
            this.myFacade.createPlaylist(0, "admin", "MOTIVATION", "WORKOUT", aze, "pusha-t-darkest-before-dawn-album-cover-full-size.jpg", "Zoubida", "Sacré Lagaf!");
            map.put("playlists", myFacade.getPlaylists());
            map.put("categories", myFacade.getDrugsList());

        }
        //actualisation playlists
        map.put("playlists", myFacade.getPlaylists());
    }

    @Override
    public void setSession(Map<String, Object> map) {this.mapSession = map;}



    public GestionApplication getMyFacade() {return myFacade;}
}
