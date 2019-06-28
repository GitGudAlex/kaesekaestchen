package dreamTeam;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;

public class PlayerManager {
    private static final Logger logger = LogManager.getLogger(App.class);

    private int players;

    private boolean aiPlayerSet;

    private int playerPlaying;
    private ArrayList<Player> playerList = new ArrayList<Player>();

    public PlayerManager(int players, boolean aiPlayerSet, String[] playerName, Color[] playerColor) {
        this.players = players;
        this.aiPlayerSet = aiPlayerSet;
        for (int i = 0; i < players; i++) {
            playerList.add(new Player(playerName[i], playerColor[i]));
        }
        playerPlaying = 0;
    }

    //Maximale Punktzahl
    private void checkScore(){

    };

    public void nextPlayer(){

        playerPlaying = (playerPlaying+1) % players;

    }

    public Player getCurrentPlayer (){
        logger.debug(playerList.get(playerPlaying).getName());
        return playerList.get(playerPlaying);

    }

    public ArrayList<Player> getPlayers() {
        ArrayList playerListC = playerList;
        return playerListC;
    }

    void setPlayers(int inputPlayers) {
        this.players = inputPlayers;
    }

    public boolean isAiPlayerSet() {
        return aiPlayerSet;
    }

    public void setAiPlayerSet(boolean aiPlayerSet) {
        this.aiPlayerSet = aiPlayerSet;
    }
}
