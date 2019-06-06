package dreamTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class Field implements IField{

    private static final Logger logger = LogManager.getLogger(App.class);

    private int xCoord;
    private int yCoord;

    private boolean state;

    private Color colorField = Color.gray;

    private Line leftLine;
    private Line topLine;
    private Line rightLine;
    private Line bottomLine;

    public Field(int xCoord, int yCoord, Line leftLine, Line topLine, Line rightLine, Line bottomLine) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.leftLine = leftLine;
        this.topLine = topLine;
        this.rightLine = rightLine;
        this.bottomLine = bottomLine;
        this.state = false;
    }

    public void generateField (){

    };

    public void checkCompleted () {
        logger.debug(("checkCompleted"));
        logger.debug("leftLine: " + leftLine.getxCoord() + leftLine.getyCoord() + leftLine.getState());
        logger.debug("rightLine: " + rightLine.getxCoord() + rightLine.getyCoord() + rightLine.getState());
        logger.debug("topLine: " + topLine.getxCoord() + topLine.getyCoord() + topLine.getState());
        logger.debug("bottomLine: " + bottomLine.getxCoord() + bottomLine.getyCoord() + bottomLine.getState());
        if (this.leftLine.getState()&&this.topLine.getState()&&this.rightLine.getState()&&this.bottomLine.getState()){
            this.state = true;
        }
        
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }
}
