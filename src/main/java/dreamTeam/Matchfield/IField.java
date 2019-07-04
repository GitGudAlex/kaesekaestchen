package dreamTeam.Matchfield;

public interface IField {

    void checkCompleted();

    boolean isState();

    boolean isCompleted();

    void setState(boolean state);

    void calculateLines();

    String getType();

    String getTypeField();

    void setMatchfield(MatchfieldSettings matchfield);
}
