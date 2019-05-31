package dreamTeam;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUI extends Application {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        int start = 1; // 1=newGame 2=instructions
        MatchfieldSettings matchfield;

        if (start == 2) {
            showInstruction();
        }
        if (start == 1) {
            matchfield = newGame();
            logger.info("Neues Spiel wird gestartet.");
        } else {
            matchfield = new MatchfieldSettings(0, 0, false, false, false);
        }
        primaryStage.setScene(playingScene(matchfield));
        primaryStage.show();



    }



    private static MatchfieldSettings newGame (){
        //ToDo if (AnzahlSpieler == 1) {aiPlayer = true;}

        /*PlayerManager playermanager = new PlayerManager();
        playermanager.setPlayers(4);


        //ToDo Weiter-Button

        //ToDo Namen einfügen

        //ToDO Weiter-Button

        playermanager.generatePlayer();*/

        MatchfieldSettings matchfield = new MatchfieldSettings(3,5,true,false,true);

//        matchfield.generateMatchfield();

        return matchfield;
    };

    private static void showInstruction (){
        logger.info("show Instruction");
    };

    private static void startGame (){

    }

    private static void firstScene(){

    }

    private static void secondScene(){

    }

    private static void thirdScene(){

    }

    private static Scene playingScene(MatchfieldSettings matchfield){
            /*
            mock data
             */
            String [] n = {"p1", "p2"};
            Color [] c = {Color.blue, Color.red};
            PlayerManager p = new PlayerManager(2,false,n,c);

            GridPane pane = new GridPane();

            Scene scene = new Scene(pane,600,600);

            pane.setMinSize(600,600);

            ArrayList<Button> buttonList = new ArrayList();
            ArrayList<Button> buttonListHorizontal = new ArrayList();
            ArrayList<Button> buttonField = new ArrayList<>();


            int indexHorizontal = 0;
            int indexVertical = 0;
            int indexField = 0;
            int column = 0;
            for (int i = 0; i < matchfield.getFieldSize(); i+=2) {
                for (int j = 0; j < matchfield.getFieldSize()-1; j+= 2) {
                    Label label = new Label();
                    pane.add(label, j, i);
                    label.setPrefSize(10,10);
                    buttonListHorizontal.add(indexHorizontal, new Button());
                    buttonListHorizontal.get(indexHorizontal).setPrefSize(40,10);
                    pane.add(buttonListHorizontal.get(indexHorizontal), j+1, i);
                    indexHorizontal ++;
                    column = j;
                }
                Label l = new Label();
                pane.add(l, column+2, i);
                l.setPrefSize(10,10);
                if (i<matchfield.getFieldSize()-1) {
                    for (int j = 0; j < matchfield.getFieldSize()-1; j += 2) {
                        buttonList.add(indexVertical, new Button());
                        buttonList.get(indexVertical).setPrefSize(20, 40);
                        pane.add(buttonList.get(indexVertical), j, i + 1);
                        buttonField.add(indexField, new Button());
                        buttonField.get(indexField).setPrefSize(40, 40);
                        pane.add(buttonField.get(indexField), j + 1, i + 1);
                        indexVertical++;
                        indexField++;
                        column = j;
                    }
                    buttonList.add(indexVertical, new Button());
                    buttonList.get(indexVertical).setPrefSize(20, 40);
                    pane.add(buttonList.get(indexVertical), column + 2, i + 1);
                    indexVertical++;
                }
            }

        for (int i = 0; i < buttonList.size() ; i++) {
            Button b = buttonList.get(i);
            b.setOnAction(actionEvent -> {
                String newColor = "#" + Integer.toHexString(p.getCurrentPlayer().getColor().getRGB()).substring(2);
                logger.debug(newColor);
                b.setStyle("-fx-background-color: "+newColor);
                p.nextPlayer();
            });

        }for (int i = 0; i < buttonListHorizontal.size() ; i++) {
            Button b = buttonListHorizontal.get(i);
            b.setOnAction(actionEvent -> {
                String newColor = "#" + Integer.toHexString(p.getCurrentPlayer().getColor().getRGB()).substring(2);
                logger.debug(newColor);
                b.setStyle("-fx-background-color: "+newColor);
                p.nextPlayer();
            });
        }

            return scene;

        }


    }
    //ToDo überprüfe ob Rand oder Mittellinie


