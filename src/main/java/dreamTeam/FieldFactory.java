package dreamTeam;

public class FieldFactory {

    protected IField generateField (int xCoord, int yCoord, int fieldIndex, String type){

        if(type.equals("bonus")){
            return new Bonusfield(xCoord, yCoord, fieldIndex);
        } else if(type.equals("minus")){
            return new Minusfield(xCoord,yCoord, fieldIndex);
        } else {
            return new Field(xCoord, yCoord, fieldIndex);
        }

    };
}
