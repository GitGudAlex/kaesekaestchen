package dreamTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class MatchfieldSettings {

    private static final Logger logger = LogManager.getLogger(App.class);

    private int fieldSize;

    private int fieldShape;

    private boolean bonusfield;
    private boolean minusfield;

    private boolean fastMode;

    private ArrayList<Line> lineListHorizontal;
    private ArrayList<Line> lineListVertical;
    private ArrayList<IField> fieldList;

    MatchfieldSettings(int fieldSize, int fieldShape, boolean bonusfield, boolean minusfield, boolean fastMode) {
        this.fieldSize = (fieldSize*2)+1;
        this.fieldShape = fieldShape;
        this.bonusfield = bonusfield;
        this.minusfield = minusfield;
        this.fastMode = fastMode;
    }

    void generateMatchfield(){
        int indexLineHorizontal = 1;
        int indexLineVertical = 1;
        int indexField=1;

        for (int x = 1; x < this.fieldSize; x+=2) {
            for (int y = 0; y <= this.fieldSize ; y+=2) {
                lineListHorizontal.add(indexLineHorizontal,new Line(x, y, 0));
                indexLineHorizontal++;
                logger.debug("Horizontal Line created. Index: " + indexLineHorizontal + " xCoord: " + x + " yCoord: " + y);
            }
        }
        logger.info("Horizontal Lines count: " + indexLineHorizontal);

        for (int x = 0; x <= this.fieldSize ; x+=2) {
            for (int y = 1; y < this.fieldSize ; y+=2) {
                lineListVertical.add(indexLineVertical, new Line (x,y,1));
                indexLineVertical++;
                logger.debug("Vertical Line created. Index: " + indexLineVertical + " xCoord: " + x + " yCoord: " + y);
            }
        }
        logger.info("Vertical Lines count: " + indexLineVertical);

        FieldFactory factory = new FieldFactory();

        for (int x = 1; x < this.fieldSize ; x+=2) {
            for (int y = 1; y < this.fieldSize ; y+=2) {
                fieldList.add(indexField, factory.generateField(x,y, calculateLineSide(indexField, 0), calculateLineTop(indexField), calculateLineSide(indexField, 1), calculateLineBottom(indexField),randomFieldType()));
                indexField++;
                logger.debug("Index: " + indexField  + " xCoord: " + x + " yCoord: " + y);
            }

        }
        logger.info("Field count: " + indexField);
    }

    private String randomFieldType (){
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

    private Line calculateLineSide (int indexField, int side) { // left = 0, right = 1
        logger.debug("calculateLineSide");
        int rest = indexField%fieldSize;
        logger.debug("Remainder: " + rest);
        int n = indexField-rest;
        logger.debug("n: " + n);
        int factor = n/fieldSize;
        logger.debug("Factor: " + factor);
        logger.debug("Vertical " + side + " : " + lineListVertical);
        return lineListVertical.get(n+(factor*1)+rest+side);
    }

    private Line calculateLineTop (int indexField){
        logger.debug("LineTop: " + lineListHorizontal);
        return lineListHorizontal.get(indexField);
    }

    private Line calculateLineBottom(int indexField){
        logger.debug("LineBottom: " + lineListHorizontal);
        return lineListHorizontal.get(indexField+fieldSize);
    }

    protected IField checkFieldTop (int indexLine){
        logger.debug("Check current FieldTop: " + fieldList);
        return fieldList.get(indexLine-fieldSize);
    }

    protected IField checkFieldBottom (int indexLine){
        logger.debug("Check current FieldBottom: " + fieldList);
        return fieldList.get(indexLine);
    }

    protected IField checkFieldSide (int indexLine, int side){
        logger.debug("Check FieldSide");
        int rest = indexLine%fieldSize;
        logger.debug("FieldSide remainder: " + rest);
        int n = indexLine-rest;
        logger.debug("n: " + n);
        int factor = n/fieldSize;
        logger.debug("FieldSide factor: " + factor);
        logger.debug("FieldSide " + side + " : " + fieldList);
        return fieldList.get(n+rest-(factor*1)+side);
    }
}
