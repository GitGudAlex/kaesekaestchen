package dreamTeam;

public class MatchfieldSettings {

    private int fieldSize;
    private int fieldShape;
    private int bonusfield;
    private int minusfield;

    private boolean fastMode;

    MatchfieldSettings(int fieldSize, int fieldShape, int bonusfield, int minusfield, boolean fastMode) {
        this.fieldSize = fieldSize;
        this.fieldShape = fieldShape;
        this.bonusfield = bonusfield;
        this.minusfield = minusfield;
        this.fastMode = fastMode;
    }

    void generateMatchfield(){

    }
}
