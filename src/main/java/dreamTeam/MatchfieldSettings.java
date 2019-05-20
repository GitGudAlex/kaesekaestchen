package dreamTeam;

import java.util.ArrayList;
import java.util.Random;

public class MatchfieldSettings {

    private int fieldSize;

    private int fieldShape;

    private boolean bonusfield;
    private boolean minusfield;

    private boolean fastMode;

    private ArrayList<Line> lineList;
    private ArrayList<IField> fieldList;

    MatchfieldSettings(int fieldSize, int fieldShape, boolean bonusfield, boolean minusfield, boolean fastMode) {
        this.fieldSize = (fieldSize*2)+1;
        this.fieldShape = fieldShape;
        this.bonusfield = bonusfield;
        this.minusfield = minusfield;
        this.fastMode = fastMode;
    }

    void generateMatchfield(){
        int indexLine=0;
        int indexField=0;

        for (int x = 1; x < this.fieldSize; x+=2) {
            for (int y = 0; y <= this.fieldSize ; y+=2) {
                lineList.add(indexLine,new Line(x, y, 0));
                indexLine++;
            }
        }

        for (int x = 0; x <= this.fieldSize ; x+=2) {
            for (int y = 1; y < this.fieldSize ; y+=2) {
                lineList.add(indexLine, new Line (x,y,1));
                indexLine++;
            }
        }

        FieldFactory factory = new FieldFactory();

        for (int x = 1; x < this.fieldSize ; x+=2) {
            for (int y = 1; y < this.fieldSize ; y+=2) {
                fieldList.add(indexField, factory.generateField(x,y,randomFieldType()));
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
}
