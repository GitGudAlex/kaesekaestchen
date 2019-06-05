package dreamTeam;

import java.awt.*;

public class Field implements IField{

    int xCoord;
    int yCoord;

    boolean state;

    Color colorField = Color.gray;

    Line leftLine;
    Line topLine;
    Line rightLine;
    Line bottomLine;

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
