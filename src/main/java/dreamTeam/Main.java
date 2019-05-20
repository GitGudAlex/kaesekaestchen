package dreamTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        int start = 1; // 1=newGame 2=instructions

        if (start==1){
            newGame();
        } else if (start==2) {
            showInstruction();
        }

    }

    private static void newGame (){
        //ToDo if (AnzahlSpieler == 1) {aiPlayer = true;}

        PlayerManager playermanager = new PlayerManager();
        playermanager.setPlayers(4);


        //ToDo Weiter-Button

        //ToDo Namen einfügen

        //ToDO Weiter-Button

        playermanager.generatePlayer();

        MatchfieldSettings matchfield = new MatchfieldSettings(3,5,true,false,true);

        matchfield.generateMatchfield();
    };

    private static void showInstruction (){
        logger.info("show Instruction");
    };

    private static void startGame (){

    };

}
