package dreamTeam;

public class FieldFactory {

    protected IField generateField (int fieldIndex, String type){

        if(type.equals("bonus")){
            return new Bonusfield(fieldIndex);
        } else if(type.equals("minus")){
            return new Minusfield(fieldIndex);
        } else {
            return new Field(fieldIndex);
        }

    };
}
