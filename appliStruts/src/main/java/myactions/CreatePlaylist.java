package myactions;

import librairies.ImageResizer;
import modele.Playlist;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 24/01/2017.
 */
public class CreatePlaylist extends MyCommonEnvironnement{

    private ArrayList<String> idSongsList;
    private String selectedCategory;
    private List<String> moodsList;
    private List<String> drugsList;
    private String drugs;
    private String moods;
    private Playlist playlist;
    private int idPlaylist;
    private String cssCroppedImage;
    private String title;
    private String description;

    private File upload; //uploaded file
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
        //-----------file upload part-----------
        String userDir = ServletActionContext.getServletContext().getRealPath("/");
        userDir = userDir.replaceAll("\\\\", "/");
        String newFileName = "resources/images/" + fileName;
        String fullFileName = userDir + newFileName;
        File theFile = new File(fullFileName);
        try {
            FileUtils.copyFile(upload, theFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //get position of image + zoom for resizing
        JSONObject obj = new JSONObject(decodeURIComponent(cssCroppedImage));
        JSONArray jsonArray = obj.getJSONArray("points");
        int[] posImage = new int[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); ++i) {
            posImage[i] = jsonArray.optInt(i);
        }
        //resize image
        try {
            ImageResizer.resize(fullFileName, fullFileName, obj.getDouble("zoom"),posImage[0], posImage[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-----------end file upload-----------
        int idUser = (Integer) this.mapSession.get("idUser");
        String userName = (String) this.mapSession.get("userName");
        this.getMyFacade().createPlaylist(idUser, userName, drugs, moods, idSongsList, fileName, title, description);
        return SUCCESS;
    }

    public String playPlaylist(){
        playlist = getMyFacade().getPlaylistFromId(idPlaylist);
        return SUCCESS;
    }
    public String updateMood(){
        moodsList = getMyFacade().getMoodsListOfDrug(selectedCategory);
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


    public ArrayList<String> getIdSongsList() {return idSongsList;}

    public void setIdSongsList(ArrayList<String> idSongsList) {this.idSongsList = idSongsList;}

    public List<String> getDrugsList() {return drugsList;}

    public void setDrugsList(List<String> drugsList) {this.drugsList = drugsList;}

    public List<String> getMoodsList() {return moodsList;}

    public void setMoodsList(List<String> moodsList) {this.moodsList = moodsList;}

    public String getSelectedCategory() {return selectedCategory;}

    public void setSelectedCategory(String selectedCategory) {this.selectedCategory = selectedCategory;}

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

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getCssCroppedImage() {
        return cssCroppedImage;
    }

    public void setCssCroppedImage(String cssCroppedImage) {
        this.cssCroppedImage = cssCroppedImage;
    }

}
