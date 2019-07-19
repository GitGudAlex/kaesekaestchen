package dreamTeam.PlayerManager;


import dreamTeam.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class PlayerManager {
    private static final Logger logger = LogManager.getLogger(App.class);

    private String highScoreFile = "highscoreFile.txt";
    private Map<Integer, String> highScoreList = new TreeMap<>();

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
        logger.debug("next player.");

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

    public int WinnerPoints(){
        if(playerList.get(0).getScore() > playerList.get(1).getScore())
            return playerList.get(0).getScore();
        else if(playerList.get(0).getScore() < playerList.get(1).getScore())
            return playerList.get(1).getScore();
        else
            return 0;
    }

    public void updateHighscoreList(String name, int points){

        logger.info("Start uploading Highscore-List");

        int[] keys;
        String[] values;
        int index = 0;

        highScoreList.put(points, name);
        logger.debug("Add new winnerpoints to highscorelist \nkey: "+points+"\nvalue: "+name);


        highScoreList.entrySet()
             .removeIf(score -> score.getKey().compareTo(Integer.valueOf(5))<0);

        keys = new int[highScoreList.size()];
        values = new String[highScoreList.size()];

        for (Map.Entry<Integer, String> mapEntry : highScoreList.entrySet()) {
            keys[index] = mapEntry.getKey();
            logger.debug("upload key nr."+index+" : " +mapEntry.getKey());
            values[index] = mapEntry.getValue();
            logger.debug("upload value nr."+index+" : " +values[index]);
            index++;
        }
        try{
            PrintWriter pw = new PrintWriter(highScoreFile);
            for (int i = 0; i < highScoreList.size() ; i++) {
                pw.println(keys[i]+ ":" +values[i]);
                logger.debug("Write to file: " +keys[i]+":"+values[i]);
            }
            pw.close();
        }catch (FileNotFoundException e){
            logger.error(e);
        }
    }


    public String downloadHighScoreList(){
        String line;
        String highscoreListeString="";
        logger.info("Start downloading Highscore-List");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(highScoreFile));
            while ((line = reader.readLine())!=null){
                String[] parts = line.split(":",2);
                if(parts.length >= 2){
                    String keyS = parts[0];
                    logger.debug("String for key: "+parts[0]);
                    String value = parts[1];
                    logger.debug("String for value: "+parts[1]);
                    int key = Integer.parseInt(keyS);
                    logger.debug("Int for key: "+key);
                    highscoreListeString = highscoreListeString+"\n"+parts[1]+" = "+parts[0];
                    highScoreList.put(key,value);
                }else {
                    logger.debug("HighscoreFile downloading went wrong at line: " + line);
                }
            }
        }catch (Exception e){
            logger.error(e);
        }
        return highscoreListeString;
    }

    public Map getHighscorList(){
        highScoreList.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()));
        return highScoreList;
    }
}
