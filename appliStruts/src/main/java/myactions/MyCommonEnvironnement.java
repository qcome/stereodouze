package myactions;

import com.opensymphony.xwork2.ActionSupport;
import modele.GestionApplication;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

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
        }
        //actualisation playlists
        map.put("playlists", myFacade.getPlaylists());
    }

    @Override
    public void setSession(Map<String, Object> map) {this.mapSession = map;}



    public GestionApplication getMyFacade() {return myFacade;}
}
