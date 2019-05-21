package dreamTeam;

public class FieldFactory {

    protected IField generateField (int xCoord, int yCoord, Line leftLine, Line topLine, Line rightLine, Line bottomLine, String type){

        if(type.equals("bonus")){
            return new Bonusfield(xCoord, yCoord, leftLine, topLine, rightLine, bottomLine);
        } else if(type.equals("minus")){
            return new Minusfield(xCoord,yCoord, leftLine, topLine, rightLine, bottomLine);
        } else {
            return new Field(xCoord, yCoord, leftLine, topLine, rightLine, bottomLine);
        }

    };
}
