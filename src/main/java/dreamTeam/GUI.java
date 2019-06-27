package dreamTeam;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.css.Match;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

        Music.music("music/sound.wav");

        int start = 1; // 1=newGame 2=instructions
        MatchfieldSettings matchfield;
        if (start == 3){

        }
        if (start == 2) {
            showInstruction();
        }
        if (start == 1) {
            matchfield = newGame();
            logger.info("Neues Spiel wird gestartet.");
        } else {
            matchfield = new MatchfieldSettings(0, 0, false, false, false);
        }
        primaryStage.setScene(firstScene(primaryStage));//playingScene(matchfield));
        primaryStage.show();


    }


    private static MatchfieldSettings newGame() {
        //ToDo if (AnzahlSpieler == 1) {aiPlayer = true;}

        /*PlayerManager playermanager = new PlayerManager();
        playermanager.setPlayers(4);


        //ToDo Weiter-Button

        //ToDo Namen einfügen

        //ToDO Weiter-Button

        playermanager.generatePlayer();*/

        MatchfieldSettings matchfield = new MatchfieldSettings(4, 5, true, true, true);

//

        return matchfield;
    }

    ;

    private static void showInstruction() {
        logger.info("show Instruction");
    }

    ;

    private static void startGame() {

    }

    private static Scene firstScene(Stage primaryStage) {

        PlayerManager playerManager;
        MatchfieldSettings matchfield;

        BorderPane bpane = new BorderPane();

        Scene scene = new Scene( bpane,300, 300);

        GridPane gpane = new GridPane();

        BorderPane topPane = new BorderPane();
        bpane.setTop(topPane);
        Label labelSettings = new Label("Settings:");
        topPane.setCenter(labelSettings);

        Button buttonNext = new Button(" next ");

        BorderPane bottomPane = new BorderPane();
        bpane.setBottom(bottomPane);
        bottomPane.setCenter(buttonNext);

        Label labelPlayer1 = new Label("Name: ");
        Label labelPlayer2 = new Label("Name: ");
        javafx.scene.control.TextField tfPlayer1 = new javafx.scene.control.TextField();
        javafx.scene.control.TextField tfPlayer2 = new TextField();

        bpane.setCenter(gpane);
        gpane.add(labelPlayer1, 0, 0);
        gpane.add(labelPlayer2, 0, 1);
        gpane.setMaxHeight(100);
        gpane.setMaxWidth(250);
        gpane.add(tfPlayer1,1,0);
        gpane.add(tfPlayer2, 1, 1);

        Label labelFieldSize = new Label("Fieldsize: ");
        ChoiceBox<Integer> choiceFieldSize = new ChoiceBox<>(FXCollections.observableArrayList(3,4,5,6,7,8,9,10));
        choiceFieldSize.getSelectionModel().selectFirst();

        gpane.add(labelFieldSize, 0,2);
        gpane.add(choiceFieldSize, 1,2); // mögliche Exception, falls Text oder Kommazahl einegeben

        Label labelMinus = new Label("Minusfield: ");
        Label labelBonus = new Label("Bonusfield: ");
        CheckBox checkMinus = new CheckBox();
        CheckBox checkBonus = new CheckBox();

        gpane.add(labelBonus, 0, 3);
        gpane.add(labelMinus, 0, 4);
        gpane.add(checkBonus, 1, 3);
        gpane.add(checkMinus, 1, 4);

        String [] names = {tfPlayer1.getText(), tfPlayer2.getText()};
        Color[] colors = {Color.blue, Color.red};
        playerManager = new PlayerManager(2, false, names, colors);

        boolean bonusField = checkBonus.isSelected();
        boolean minusField = checkMinus.isSelected();

        int fieldSize = choiceFieldSize.getValue();

        logger.debug("FieldSize Choice Box: "+fieldSize);

        matchfield = new MatchfieldSettings(fieldSize, 1, bonusField, minusField, false);

        buttonNext.setOnAction(actionEvent -> {
            primaryStage.setScene(playingScene(matchfield, playerManager));
            primaryStage.show();

        });

        return scene;

    }

    private static void secondScene() {

    }

    private static void thirdScene() {

    }

    private static Scene playingScene(MatchfieldSettings matchfield, PlayerManager p) {
            /*
            mock data
             */

        GridPane pane = new GridPane();

        Scene scene = new Scene(pane, 300, 300);

        pane.setMinSize(300, 300);

        ArrayList<Button> buttonList = new ArrayList();
        ArrayList<Button> buttonListHorizontal = new ArrayList();
        ArrayList<Button> buttonField = new ArrayList<>();


        
        int indexHorizontal = 0;
        int indexVertical = 0;
        int indexField = 0;

        FieldFactory factory = new FieldFactory();

        int column = 0;
        // create matchfield
        for (int i = 0; i < matchfield.getFieldSizeGUI(); i += 2) {
            for (int j = 0; j < matchfield.getFieldSizeGUI() - 1; j += 2) {
                Label label = new Label();
                pane.add(label, j, i);
                label.setPrefSize(10, 10);
                buttonListHorizontal.add(indexHorizontal, new Button());
                logger.debug("generate button horizontal. Index: " + indexHorizontal);
                buttonListHorizontal.get(indexHorizontal).setPrefSize(40, 10);
                pane.add(buttonListHorizontal.get(indexHorizontal), j + 1, i);
                matchfield.getLineListHorizontal().add(indexHorizontal,new Line(j+1, i, 1));
                logger.debug("generate line horizontal. Index: " + indexHorizontal);
                indexHorizontal++;
                column = j;
            }
            Label l = new Label();
            pane.add(l, column + 2, i);
            l.setPrefSize(10, 10);
            if (i < matchfield.getFieldSizeGUI() - 1) {
                for (int j = 0; j < matchfield.getFieldSizeGUI() - 1; j += 2) {
                    buttonList.add(indexVertical, new Button());
                    logger.debug("generate button vertical. Index: " + indexVertical);
                    buttonList.get(indexVertical).setPrefSize(20, 40);
                    pane.add(buttonList.get(indexVertical), j, i + 1);
                    matchfield.getLineListVertical().add(indexVertical, new Line (j,i+1,0));
                    logger.debug("generate line vertical. Index: " + indexVertical);
                    buttonField.add(indexField, new Button());
                    buttonField.get(indexField).setPrefSize(40, 40);
                    pane.add(buttonField.get(indexField), j + 1, i + 1);
                    matchfield.getFieldList().add(indexField, factory.generateField(j+1,i+1, indexField,matchfield.randomFieldType()));
                    logger.debug("field index: "+indexField);
                    indexVertical++;
                    indexField++;
                    column = j;
                }
                buttonList.add(indexVertical, new Button());
                logger.debug("generate button vertical. Index: " + indexVertical);
                buttonList.get(indexVertical).setPrefSize(20, 40);
                pane.add(buttonList.get(indexVertical), column + 2, i + 1);
                matchfield.getLineListVertical().add(indexVertical, new Line (column+2,i+1,0));
                logger.debug("generate line vertical. Index: " + indexVertical);
                indexVertical++;
            }
        }

        //create scoreboard
        Label labele = new Label();
        labele.setPrefSize(20,20);
        Label labelp1 = new Label(p.getPlayers().get(0).getName());
        Label labelp2 = new Label(p.getPlayers().get(1).getName());
        Label pointLabelp1 = new Label("0");
        Label pointLabelp2 = new Label("0");
        pane.add(labele, matchfield.getFieldSizeGUI(), 0);
        pane.add(labelp1, matchfield.getFieldSizeGUI()+1, 0);
        pane.add(pointLabelp1, matchfield.getFieldSizeGUI()+2, 0);
        p.getPlayers().get(0).setLabel(pointLabelp1);
        pane.add(labelp2, matchfield.getFieldSizeGUI()+1, 1);
        pane.add(pointLabelp2, matchfield.getFieldSizeGUI()+2, 1);
        p.getPlayers().get(1).setLabel(pointLabelp2);

        for (int i = 0; i < matchfield.getFieldSize()*matchfield.getFieldSize(); i++) {
            matchfield.getFieldList().get(i).setMatchfield(matchfield);
            matchfield.getFieldList().get(i).calculateLines();
            String s = matchfield.getFieldList().get(i).getTypeField();
            buttonField.get(i).setText(s);
        }

        for (int i = 0; i < buttonList.size(); i++) {
            clickChangeColor(buttonField, buttonList, i, p, matchfield, 0); //0: vertical buttons

        }
        for (int i = 0; i < buttonListHorizontal.size(); i++) {
            clickChangeColor(buttonField, buttonListHorizontal, i, p, matchfield, 1); //1: horizontal buttons
        }

        return scene;
    }

    private static void clickChangeColor(ArrayList<Button> buttonField, ArrayList<Button> buttonList, int indexLine, PlayerManager p, MatchfieldSettings matchfield, int ali) {
        Button b = buttonList.get(indexLine);
        b.setOnAction(actionEvent -> {
            if (ali == 0 && !matchfield.getLineListVertical().get(indexLine).getState() || ali == 1 && !matchfield.getLineListHorizontal().get(indexLine).getState()) {
                String newColor = "#" + Integer.toHexString(p.getCurrentPlayer().getColor().getRGB()).substring(2);
                logger.debug(newColor);
                b.setStyle("-fx-background-color: " + newColor);
                if (ali == 0) {
                    matchfield.getLineListVertical().get(indexLine).setState(true);
                    logger.debug("Line pressed vertical: " + indexLine);

                } else if (ali == 1) {
                    matchfield.getLineListHorizontal().get(indexLine).setState(true);
                    logger.debug("Line pressed horizontal: " + indexLine);
                }

                for(int k=0 ; k < matchfield.checkFields(indexLine, ali).length; k++){
                    matchfield.getFieldList().get(matchfield.checkFields(indexLine, ali)[k]).checkCompleted();
                }

                for (int j = 0; j < (matchfield.getFieldSize()*matchfield.getFieldSize()); j++) {
                    if(matchfield.getFieldList().get(j).isCompleted()&&!matchfield.getFieldList().get(j).isState()){
                        buttonField.get(j).setStyle("-fx-background-color: " + newColor);
                        matchfield.getFieldList().get(j).setState(true);
                        p.getCurrentPlayer().addPoints(PointsToAdd(j, matchfield));
                    }
                }
                p.nextPlayer();
            }
        });
    }

    private static int PointsToAdd(int fieldIndex, MatchfieldSettings matchfield){
        String type = matchfield.getFieldList().get(fieldIndex).getType();

        if(type.equals("bonus")){
            return 3;
        } else if (type.equals("minus")){
            return -2;
        }
        return 1;
    }


}




    //ToDo überprüfe ob Rand oder Mittellinie


