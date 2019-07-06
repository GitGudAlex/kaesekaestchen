package dreamTeam.PlayerManager;


import dreamTeam.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;

public class PlayerManager {
    private static final Logger logger = LogManager.getLogger(App.class);

    private int players;
    private int playerPlaying;

    private boolean aiPlayerSet;

    private ArrayList<Player> playerList = new ArrayList<Player>();

    public PlayerManager(int players, boolean aiPlayerSet, String[] playerName, Color[] playerColor) {
        this.players = players;
        this.aiPlayerSet = aiPlayerSet;
        for (int i = 0; i < players; i++) {
            playerList.add(new Player(playerName[i], playerColor[i]));
        }
        playerPlaying = 0;
    }

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

    public String WinnerText(){
        if(WinnerName().equals("None"))
            return "The Game is a draw";
        else
            return WinnerName() + "wins the game";
    }

    public String WinnerName(){
        if(playerList.get(0).getScore() > playerList.get(1).getScore())
            return playerList.get(0).getName();
        else if(playerList.get(0).getScore() < playerList.get(1).getScore())
            return playerList.get(1).getName();
        else
            return "None";
    }

}
