package dreamTeam;

import java.util.ArrayList;
import java.util.Random;

public class MatchfieldSettings {

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
            }
        }

        for (int x = 0; x <= this.fieldSize ; x+=2) {
            for (int y = 1; y < this.fieldSize ; y+=2) {
                lineListVertical.add(indexLineVertical, new Line (x,y,1));
                indexLineVertical++;
            }
        }

        FieldFactory factory = new FieldFactory();

        for (int x = 1; x < this.fieldSize ; x+=2) {
            for (int y = 1; y < this.fieldSize ; y+=2) {
                fieldList.add(indexField, factory.generateField(x,y, calculateLineSide(indexField, 0), calculateLineTop(indexField), calculateLineSide(indexField, 1), calculateLineBottom(indexField),randomFieldType()));
                indexField++;
            }

        }
    }

    private String randomFieldType (){
        Random randomGenerator = new Random();

        int i = randomGenerator.nextInt(10); //i ist Zahl zwischen 0 und 9

        if(i>=8 && this.bonusfield){
            return "bonus";
        } else if (i>=6 && this.minusfield){
            return "minus";
        } else {
            return "normal";
        }

    }

    private Line calculateLineSide (int indexField, int side) { // left = 0, right = 1
        int rest = indexField%fieldSize;
        int n = indexField-rest;
        int factor = n/fieldSize;
        return lineListVertical.get(n+(factor*1)+rest+side);
    }

    private Line calculateLineTop (int indexField){
        return lineListHorizontal.get(indexField);
    }

    private Line calculateLineBottom(int indexField){
        return lineListHorizontal.get(indexField+fieldSize);
    }

    protected IField checkFieldTop (int indexLine){
        return fieldList.get(indexLine-fieldSize);
    }

    protected IField checkFieldBottom (int indexLine){
        return fieldList.get(indexLine);
    }

    protected IField checkFieldSide (int indexLine, int side){
        int rest = indexLine%fieldSize;
        int n = indexLine-rest;
        int factor = n/fieldSize;
        return fieldList.get(n+rest-(factor*1)+side);
    }
}
