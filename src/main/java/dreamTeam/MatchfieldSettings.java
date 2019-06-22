package dreamTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class MatchfieldSettings {

    private static final Logger logger = LogManager.getLogger(App.class);

    private int fieldSizeGUI;
    private int fieldSize;

    public int getFieldSizeGUI() {
        return fieldSizeGUI;
    }

    private int fieldShape;

    private boolean bonusfield;
    private boolean minusfield;

    private boolean fastMode;

    public void setLineListHorizontal(ArrayList<Line> lineListHorizontal) {
        this.lineListHorizontal = lineListHorizontal;
    }

    public void setLineListVertical(ArrayList<Line> lineListVertical) {
        this.lineListVertical = lineListVertical;
    }

    public void setFieldList(ArrayList<IField> fieldList) {
        this.fieldList = fieldList;
    }

    private ArrayList<Line> lineListHorizontal = new ArrayList<>();
    private ArrayList<Line> lineListVertical = new ArrayList<>();
    private ArrayList<IField> fieldList = new ArrayList<>();

    MatchfieldSettings(int fieldSize, int fieldShape, boolean bonusfield, boolean minusfield, boolean fastMode) {
        this.fieldSizeGUI = (fieldSize *2)+1;
        this.fieldShape = fieldShape;
        this.bonusfield = bonusfield;
        this.minusfield = minusfield;
        this.fastMode = fastMode;
        this.fieldSize = fieldSize;
    }


    public int getFieldSize() {
        return fieldSize;
    }

    protected String randomFieldType (){
        Random randomGenerator = new Random();

        int i = randomGenerator.nextInt(10); //i ist Zahl zwischen 0 und 9

        if(i>=8 && this.bonusfield){
            logger.debug("bonusfield created");
            return "bonus";
        } else if (i>=6 && this.minusfield){
            logger.debug("minusfield created.");
            return "minus";
        } else {
            logger.debug("field created.");
            return "normal";
        }

    }



    protected IField checkFieldTop (int indexLine){
        logger.debug("Check current FieldTop: " + fieldList);
        return fieldList.get(indexLine- fieldSize);
    }

    protected int checkFieldBottom (int indexLine){
        logger.debug("Check current FieldBottom: " + fieldList);
        return indexLine;
    }

    protected int checkFieldSide (int indexLine, int side){
        logger.debug("Check FieldSide");
        logger.debug("FieldSize: " + fieldSize + " ; indexLine: " + indexLine);
        int rest = indexLine% fieldSize;
        logger.debug("FieldSide remainder: " + rest);
        int n = indexLine-rest;
        logger.debug("n: " + n);
        int factor = n/ fieldSize;
        logger.debug("FieldSide factor: " + factor);
        logger.debug("FieldSide " + side + " : " + fieldList);
        int test = n+rest-factor+side-factor;
        logger.debug("Field: " +test);
        return n+rest-factor+side-1;
    }

    public ArrayList<Line> getLineListHorizontal() {
        return lineListHorizontal;
    }

    public ArrayList<Line> getLineListVertical() {
        return lineListVertical;
    }

    public ArrayList<IField> getFieldList() {
        return fieldList;
    }

}
