package dreamTeam.PlayerManager;

import dreamTeam.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.scene.control.Label;
import java.awt.*;

public class Player {

    private static final Logger logger = LogManager.getLogger(App.class);

    private int score;
    private String name;
    private Color color;
    private Label label;


    public Player(String name, Color color) {
        score = 0;
        this.name = name;
        this.color = color;
    }

    public void setLabel (Label label){
        this.label = label;
    }

    public void addPoints(int points){
        this.score += points;
        logger.debug("Player: "+ name + " new score: "+score);
        label.setText(Integer.toString(this.score));
    }

    public int getScore(){return score;}

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
