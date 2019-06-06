package dreamTeam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
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

            Scene scene = new Scene(pane,300,300);

            pane.setMinSize(300,300);

            ArrayList<Button> buttonList = new ArrayList();
            ArrayList<Button> buttonListHorizontal = new ArrayList();
            ArrayList<Button> buttonField = new ArrayList<>();


        matchfield.generateMatchfield();
            int indexHorizontal = 0;
            int indexVertical = 0;
            int indexField = 0;
            int column = 0;
            for (int i = 0; i < matchfield.getFieldSizeGUI(); i+=2) {
                for (int j = 0; j < matchfield.getFieldSizeGUI()-1; j+= 2) {
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
                if (i<matchfield.getFieldSizeGUI()-1) {
                    for (int j = 0; j < matchfield.getFieldSizeGUI()-1; j += 2) {
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
            clickChangeColor(buttonField,buttonList, i, p, matchfield, 0); //0: vertical buttons

        }for (int i = 0; i < buttonListHorizontal.size() ; i++) {
            clickChangeColor(buttonField, buttonListHorizontal, i, p, matchfield, 1); //1: horizontal buttons
        }
            return scene;
        }

        private static void clickChangeColor(ArrayList <Button> buttonField, ArrayList <Button> buttonList, int i, PlayerManager p, MatchfieldSettings m, int ali){
            Button b= buttonList.get(i);
            b.setOnAction(actionEvent -> {
                if(ali == 0 && m.getLineListVertical().get(i).getState()==false || ali == 1 && m.getLineListHorizontal().get(i).getState()==false){
                String newColor = "#" + Integer.toHexString(p.getCurrentPlayer().getColor().getRGB()).substring(2);
                logger.debug(newColor);
                b.setStyle("-fx-background-color: "+newColor);
                if (ali == 0){
                    m.getLineListVertical().get(i).setState(true);
                    logger.debug("Line state:"+m.getLineListVertical().get(i).getState());
                    logger.debug(("x-Coord: " + m.getLineListVertical().get(i).getxCoord() + "y-Coord: " + m.getLineListVertical().get(i).getyCoord()));

                } else if (ali == 1){
                    m.getLineListHorizontal().get(i).setState(true);
                    logger.debug(("x-Coord: " + m.getLineListHorizontal().get(i).getxCoord() + "y-Coord: " + m.getLineListHorizontal().get(i).getyCoord()));
                }
                checkFields(buttonField,m,i,ali, p);
                p.nextPlayer();}
            });}

        private static void checkFields(ArrayList<Button> buttonField, MatchfieldSettings m, int index, int ali, PlayerManager p){
        IField field;
            if (ali==0){
                if(m.getLineListVertical().get(index).getyCoord()==0){
                    int indexField = m.checkFieldSide(index,1);
                    field = m.getFieldList().get(indexField);
                    field.checkCompleted();
                    Button button = buttonField.get(indexField);
                    logger.debug("fieldState: " + field.isState());
                    if(field.isState()){
                            String newColor = "#" + Integer.toHexString(p.getCurrentPlayer().getColor().getRGB()).substring(2);
                            logger.debug(newColor);
                            button.setStyle("-fx-background-color: " + newColor);
                    } else {

                        }
                    }
                }
            }
            }




    //ToDo überprüfe ob Rand oder Mittellinie


