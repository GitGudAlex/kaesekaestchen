package dreamTeam;


import java.awt.*;
import java.util.ArrayList;

public class PlayerManager {

    private int players;

    private boolean aiPlayerSet;

    private String[] playerName;
    private Color[] playerColor;

    private ArrayList<Player> playerList = new ArrayList<Player>();

    void generatePlayer(){

        playerName = new String[players];
        playerColor = new Color[players];

        for (int i = 1; i <= players ; i++) {
            playerList.add(i, new Player(playerName[i], playerColor[i]));
        }
    };

    //Maximale Punktzahl
    private void checkScore(){

    };

    public int getPlayers() {
        return players;
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
