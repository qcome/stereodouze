package myactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Quentin on 24/01/2017.
 */
public class CreatePlaylist extends MyCommonEnvironnement {


    private ArrayList<Integer> idSongsList;
    private String drugSelected;
    private List<String> moodsList;
    private List<String> drugsList;

    private String drugs;
    private String moods;



    @Override
    public String execute(){
        idSongsList = new ArrayList<Integer>();
        drugsList = getMyFacade().getDrugsList();
        moodsList = new ArrayList<String>();
        return SUCCESS;
    }

    public String createPlaylist(){
        int idUser = (Integer) this.mapSession.get("idUser");
        this.getMyFacade().createPlaylist(idUser, drugs, moods, idSongsList);
        return SUCCESS;
    }

    public String updateMood(){
        moodsList = getMyFacade().getMoodsListOfDrug(drugSelected);
        return SUCCESS;
    }

    public ArrayList<Integer> getIdSongsList() {return idSongsList;}

    public void setIdSongsList(ArrayList<Integer> idSongsList) {this.idSongsList = idSongsList;}

    public List<String> getDrugsList() {return drugsList;}

    public void setDrugsList(List<String> drugsList) {this.drugsList = drugsList;}

    public List<String> getMoodsList() {return moodsList;}

    public void setMoodsList(List<String> moodsList) {this.moodsList = moodsList;}

    public String getDrugSelected() {return drugSelected;}

    public void setDrugSelected(String drugSelected) {this.drugSelected = drugSelected;}

    public String getDrugs() {return drugs;}

    public void setDrugs(String drugs) {this.drugs = drugs;}

    public String getMoods() {return moods;}

    public void setMoods(String moods) {this.moods = moods;}












}
