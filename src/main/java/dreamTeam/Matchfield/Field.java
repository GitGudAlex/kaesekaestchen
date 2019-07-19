package dreamTeam.Matchfield;

import dreamTeam.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Field implements IField {

    private static final Logger logger = LogManager.getLogger(App.class);

    private boolean state;
    private boolean completed;

    private int indexField;

    private MatchfieldSettings matchfield;

    private Line leftLine;
    private Line topLine;
    private Line rightLine;
    private Line bottomLine;



    public Field(int indexField) {
        this.indexField = indexField;
        this.state = false;
    }

    public void checkCompleted () {
        if (this.leftLine.getState()&&this.topLine.getState()&&this.rightLine.getState()&&this.bottomLine.getState()){
            this.completed = true;
        }
        logger.debug("Check Field: " + indexField + " is completed: " + this.completed );
        
    }

    public void calculateLines (){
        logger.debug("calculate Lines from Field: " + indexField);
        this.bottomLine=calculateLineBottom(this.indexField);
        this.leftLine=calculateLineSide(this.indexField, 0);
        this.rightLine=calculateLineSide(this.indexField, 1);
        this.topLine=calculateLineTop(this.indexField);
    }

    private Line calculateLineSide(int indexField, int side) { // left = 0, right = 1
        int rest = indexField% matchfield.getFieldSize();
        int n = indexField-rest;
        int factor = n/ matchfield.getFieldSize();
        logger.debug("LineSide " + side + " : " +(n+(factor*1)+rest+side));
        return matchfield.getLineListVertical().get(n+(factor*1)+rest+side);
    }

    private Line calculateLineTop (int indexField){
        logger.debug("LineTop: " + indexField);
        return matchfield.getLineListHorizontal().get(indexField);
    }

    private Line calculateLineBottom(int indexField){
        logger.debug("LineBottom: " + (indexField+matchfield.getFieldSize()));
        return matchfield.getLineListHorizontal().get(indexField+ matchfield.getFieldSize());
    }

    public String getType (){
        logger.debug("Fieldtype: normal");
        return "normal";
    }

    public String getTypeField() {
        logger.debug("Fieldtype: normal");
        return "";}

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setMatchfield (MatchfieldSettings matchfielda){
        matchfield = matchfielda;
    }
}
