package modele;

import modele.exceptions.ExceptionLoginAlreadyTaken;

/**
 * Created by Quentin on 17/01/2017.
 */
public interface IGestionApplication {
    int registration(String login, String password) throws ExceptionLoginAlreadyTaken;
    void createPlaylist(int id, String drug, String mood);
    int connection(String username);
}
