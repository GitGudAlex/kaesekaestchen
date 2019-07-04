package dreamTeam.Matchfield;

public class Minusfield extends Field {

    public Minusfield(int fieldIndex) {
        super(fieldIndex);
    }

    @Override
    public String getType() {
        return "minus";
    }

    @Override
    public String getTypeField() {
        return "-";
    }
}
