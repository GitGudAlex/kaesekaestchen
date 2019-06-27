package dreamTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class Field implements IField{

    private static final Logger logger = LogManager.getLogger(App.class);

    private int xCoord;
    private int yCoord;

    private boolean state;
    private boolean completed;

    private Color colorField = Color.gray;

    private MatchfieldSettings matchfield;

    private Line leftLine;
    private Line topLine;
    private Line rightLine;
    private Line bottomLine;

    private int indexField;

    public Field(int xCoord, int yCoord, int indexField) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.indexField = indexField;
        this.state = false;
    }

    public void generateField (){

    };

    public void checkCompleted () {
        logger.debug("checkCompleted");
        if (this.leftLine.getState()&&this.topLine.getState()&&this.rightLine.getState()&&this.bottomLine.getState()){
            this.completed = true;
        }
        logger.debug("Field: " + indexField + " Completed: " + this.completed );
        
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setMatchfield (MatchfieldSettings matchfielda){
        matchfield = matchfielda;
    }

    public void calculateLines (){
        logger.debug("Field: " + indexField);
        this.bottomLine=calculateLineBottom(this.indexField);
        this.leftLine=calculateLineSide(this.indexField, 0);
        this.rightLine=calculateLineSide(this.indexField, 1);
        this.topLine=calculateLineTop(this.indexField);
    }

    protected Line calculateLineSide (int indexField, int side) { // left = 0, right = 1
        //logger.debug("calculateLineSide");
        int rest = indexField% matchfield.getFieldSize();
        //logger.debug("Remainder: " + rest);
        int n = indexField-rest;
       // logger.debug("n: " + n);
        int factor = n/ matchfield.getFieldSize();
        //logger.debug("Factor: " + factor);
        logger.debug("LineSide " + side + " : " +(n+(factor*1)+rest+side));
        return matchfield.getLineListVertical().get(n+(factor*1)+rest+side);
    }

    protected Line calculateLineTop (int indexField){
        logger.debug("LineTop: " + indexField);
        return matchfield.getLineListHorizontal().get(indexField);
    }

    protected Line calculateLineBottom(int indexField){
        logger.debug("LineBottom: " + (indexField+matchfield.getFieldSize()));
        return matchfield.getLineListHorizontal().get(indexField+ matchfield.getFieldSize());
    }

    public String getType (){
        return "normal";
    }

    public String getTypeField() {return "";}
}
