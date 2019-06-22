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

    //ali 0 = vertical, 1 = horizontal

    public int[] checkFields(int indexLine, int ali){
        logger.debug("checkField, indexLine: " + indexLine);
        int[] i = new int[1];
        int[] j = new int[2];

        if (ali == 0){
            if(indexLine%(fieldSize + 1) == 0){
                i[0]=checkFieldSide(indexLine, 1);
                return i;
            } else if (indexLine%(fieldSize + 1) == fieldSize){
                i[0]=checkFieldSide(indexLine, 0);
                return i;
            } else{
                j[0]=checkFieldSide(indexLine,0);
                j[1]=checkFieldSide(indexLine, 1);
            }
        }else if(ali == 1){
            if(indexLine < fieldSize){
                i[0]=checkFieldBottom(indexLine);
                return i;
            }else if(indexLine >= (fieldSize*fieldSize)){
                i[0]=checkFieldTop(indexLine);
                return i;
            } else{
                j[0]=checkFieldTop(indexLine);
                j[1]=checkFieldBottom(indexLine);

            }
        }
        return j;
    }

    protected int checkFieldTop (int indexLine){
        logger.debug("Check FieldTop: " + (indexLine-fieldSize));
        return indexLine - fieldSize;
    }

    protected int checkFieldBottom (int indexLine){
        logger.debug("Check FieldBottom: " + indexLine);
        return indexLine;
    }

    protected int checkFieldSide (int indexLine, int side){
        logger.debug("Check FieldSide " + side + ":");
        int row = (indexLine/(fieldSize+1))+1;
        logger.debug("Row: "+row);
        return indexLine-row+side;
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
