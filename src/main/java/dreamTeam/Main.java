package dreamTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        int start = 1; // 1=newGame 2=instructions

        if (start==1){
            newGame();
        } else if (start==2) {
            showInstruction();
        }

    }

    private static void newGame (){
        //if (AnzahlSpieler == 1) {aiPlayer = true;}

        generatePlayers(4);

        //Weiter-Button

        //Namen einfügen

        //Weiter-Button

        generatePlayers();
    };

    private static void showInstruction (){
        logger.info("show Instruction");
    };

    private static void startGame (){

    };

    private static void checkPoints(){

    };

    private static void generatePlayers(int players){
        if (){
            Player playerOne = new Player(name, color);
        }else if (){
            Player playerTwo = new Player(name, color);
        }else if (){
            Player playerThree = new Player(name, color);
        }
    };
}
