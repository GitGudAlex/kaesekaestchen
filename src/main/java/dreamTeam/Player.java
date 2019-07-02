package dreamTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.scene.control.Label;
import java.awt.*;

class Player {

    private static final Logger logger = LogManager.getLogger(App.class);

    private int score;
    private String name;
    private Color color;
    private Label label;


    Player(String name, Color color) {
        score = 0;
        this.name = name;
        this.color = color;
    }

    public void setLabel (Label label){
        this.label = label;
    }

    public Label getLabel (){return label;}

    public void addPoints(int points){
        this.score += points;
        logger.debug("Player: "+ name + " Points: "+score);
        label.setText(Integer.toString(this.score));
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
