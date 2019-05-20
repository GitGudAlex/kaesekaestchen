package dreamTeam;

public class FieldFactory {

    protected IField generateField (int xCoord, int yCoord, String type){

        if(type.equals("bonus")){
            return new Bonusfield(xCoord, yCoord);
        } else if(type.equals("minus")){
            return new Minusfield(xCoord,yCoord);
        } else {
            return new Field(xCoord, yCoord);
        }

    };
}
