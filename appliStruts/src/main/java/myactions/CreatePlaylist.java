package myactions;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import librairies.ImageResizer;
import modele.Playlist;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
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


    public String getCssCroppedImage() {
        return cssCroppedImage;
    }

    public void setCssCroppedImage(String cssCroppedImage) {
        this.cssCroppedImage = cssCroppedImage;
    }

    private String cssCroppedImage;


    private String title;


    private String description;

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
        System.out.println("idSongsList" + idSongsList);
        System.out.println("fileName" + fileName);
        //Array array = (Array) cssCroppedImage;
        //Map map = (Map) cssCroppedImage;


        JSONObject obj = new JSONObject(decodeURIComponent(cssCroppedImage));
        JSONArray jsonArray = obj.getJSONArray("points");
        System.out.println(obj.getDouble("zoom"));
        int[] numbers = new int[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); ++i) {
            numbers[i] = jsonArray.optInt(i);
        }
        System.out.println(jsonArray.get(0));
        System.out.println(jsonArray.get(1));
        System.out.println(jsonArray.get(2));
        System.out.println(jsonArray.get(3));

//resize image
        try {
            ImageResizer.resize(fullFileName, fullFileName, obj.getDouble("zoom"),numbers[0], numbers[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
       //ImageResizer.marvinResize(fullFileName,fullFileName, numbers[0], numbers[1]);
        this.getMyFacade().createPlaylist(idUser, userName, drugs, moods, idSongsList, fileName, title, description);
        return SUCCESS;
    }
    public static String decodeURIComponent(String encodedURI) {
        char actualChar;

        StringBuffer buffer = new StringBuffer();

        int bytePattern, sumb = 0;

        for (int i = 0, more = -1; i < encodedURI.length(); i++) {
            actualChar = encodedURI.charAt(i);

            switch (actualChar) {
                case '%': {
                    actualChar = encodedURI.charAt(++i);
                    int hb = (Character.isDigit(actualChar) ? actualChar - '0'
                            : 10 + Character.toLowerCase(actualChar) - 'a') & 0xF;
                    actualChar = encodedURI.charAt(++i);
                    int lb = (Character.isDigit(actualChar) ? actualChar - '0'
                            : 10 + Character.toLowerCase(actualChar) - 'a') & 0xF;
                    bytePattern = (hb << 4) | lb;
                    break;
                }
                case '+': {
                    bytePattern = ' ';
                    break;
                }
                default: {
                    bytePattern = actualChar;
                }
            }

            if ((bytePattern & 0xc0) == 0x80) { // 10xxxxxx
                sumb = (sumb << 6) | (bytePattern & 0x3f);
                if (--more == 0)
                    buffer.append((char) sumb);
            } else if ((bytePattern & 0x80) == 0x00) { // 0xxxxxxx
                buffer.append((char) bytePattern);
            } else if ((bytePattern & 0xe0) == 0xc0) { // 110xxxxx
                sumb = bytePattern & 0x1f;
                more = 1;
            } else if ((bytePattern & 0xf0) == 0xe0) { // 1110xxxx
                sumb = bytePattern & 0x0f;
                more = 2;
            } else if ((bytePattern & 0xf8) == 0xf0) { // 11110xxx
                sumb = bytePattern & 0x07;
                more = 3;
            } else if ((bytePattern & 0xfc) == 0xf8) { // 111110xx
                sumb = bytePattern & 0x03;
                more = 4;
            } else { // 1111110x
                sumb = bytePattern & 0x01;
                more = 5;
            }
        }
        return buffer.toString();
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

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}



}
