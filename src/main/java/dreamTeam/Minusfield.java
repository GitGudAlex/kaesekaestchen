package dreamTeam;

public class Minusfield extends Field{

    public Minusfield(int xCoord, int yCoord, int fieldIndex) {
        super(xCoord, yCoord, fieldIndex);
    }

    @Override
    public String getType() {
        return "minus";
    }

    @Override
    public void generateField() {
        super.generateField();
    }

    @Override
    public String getTypeField() {
        return "-";
    }
}
