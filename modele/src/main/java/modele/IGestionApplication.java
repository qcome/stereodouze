package modele;

import modele.exceptions.ExceptionCoupleLoginPasswordInvalid;
import modele.exceptions.ExceptionLoginAlreadyTaken;
import modele.exceptions.ExceptionUserNotConnected;
import modele.exceptions.ExceptionUserNotRegistered;

import java.util.ArrayList;

/**
 * Created by Quentin on 17/01/2017.
 */
public interface IGestionApplication {
    int registration(String login, String password) throws ExceptionLoginAlreadyTaken;
    void createPlaylist(int idUser, String userName, String drug, String mood, ArrayList<Integer> songs, String imageName);
    int connection(String username, String password) throws ExceptionUserNotRegistered, ExceptionCoupleLoginPasswordInvalid;
    void disconnection(int idUser) throws ExceptionUserNotConnected;
}
