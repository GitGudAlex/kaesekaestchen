package dreamTeam;

public class Bonusfield extends Field {

    public Bonusfield(int xCoord, int yCoord, int fieldIndex) {
        super(xCoord, yCoord, fieldIndex);
    }

    @Override
    public String getType() {
        return "bonus";
    }
    @Override
    public void generateField() {
        super.generateField();
    }

}
