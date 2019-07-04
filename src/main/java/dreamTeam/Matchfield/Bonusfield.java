package dreamTeam.Matchfield;

public class Bonusfield extends Field {

    public Bonusfield(int fieldIndex) {
        super(fieldIndex);
    }

    @Override
    public String getType() {
        return "bonus";
    }

    @Override
    public String getTypeField() {
        return "+";
    }
}
