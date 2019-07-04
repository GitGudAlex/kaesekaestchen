package dreamTeam.Matchfield;

public class FieldFactory {

    public IField generateField (int fieldIndex, String type){

        if(type.equals("bonus")){
            return new Bonusfield(fieldIndex);
        } else if(type.equals("minus")){
            return new Minusfield(fieldIndex);
        } else {
            return new Field(fieldIndex);
        }

    };
}
