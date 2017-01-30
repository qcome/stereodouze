package myactions;

import modele.Playlist;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Quentin on 24/01/2017.
 */
public class CreatePlaylist extends MyCommonEnvironnement{
    private HttpServletRequest servletRequest;

    private ArrayList<String> idSongsList;
    private String drugSelected;
    private List<String> moodsList;
    private List<String> drugsList;

    private String drugs;
    private String moods;

    private File upload;//The actual file


    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    private Playlist playlist;
    private int idPlaylist;

    private String contentType; //The content type of the file
    private String fileName; //The uploaded file name

    @Override
    public String execute(){
        idSongsList = new ArrayList<String>();
        drugsList = getMyFacade().getDrugsList();
        moodsList = new ArrayList<String>();
        return SUCCESS;
    }

    public String createPlaylist(){
        //ServletContext context = ServletActionContext.getServletContext();
        //Permet de récupérer le chemin jusqu'au dossier WebContent/
        System.out.println("File : " + upload);
        String userDir = ServletActionContext.getServletContext().getRealPath("/");
        System.out.println("DOUZE : " + userDir);
        userDir = userDir.replaceAll("\\\\", "/");
        System.out.println(fileName);
        String newFileName = "resources/images/"+ this.getUploadFileName();
        String fullFileName = userDir + newFileName;
        System.out.println("fullFileName : " + fullFileName);
        File theFile = new File(fullFileName);
        try {
            FileUtils.copyFile(upload, theFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int idUser = (Integer) this.mapSession.get("idUser");
        String userName = (String) this.mapSession.get("userName");
        System.out.println(idSongsList);
        this.getMyFacade().createPlaylist(idUser, userName, drugs, moods, idSongsList, fileName);
        return SUCCESS;
    }
    public String playPlaylist(){
        playlist = getMyFacade().getPlaylistFromId(idPlaylist);
        return SUCCESS;
    }
    public String updateMood(){
        moodsList = getMyFacade().getMoodsListOfDrug(drugSelected);
        return SUCCESS;
    }

    public ArrayList<String> getIdSongsList() {return idSongsList;}

    public void setIdSongsList(ArrayList<String> idSongsList) {this.idSongsList = idSongsList;}

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

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return contentType;
    }

    public void setUploadContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUploadFileName() {
        return fileName;
    }

    public void setUploadFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIdPlaylist() {return idPlaylist;}

    public void setIdPlaylist(int idPlaylist) {this.idPlaylist = idPlaylist;}



}
