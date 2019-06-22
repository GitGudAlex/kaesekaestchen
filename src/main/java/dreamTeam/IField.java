package dreamTeam;

public interface IField {

    void checkCompleted ();

    void generateField();

    boolean isState();

    boolean isCompleted();

    void setState(boolean state);

    void calculateLines();

    String getType();

    void setMatchfield(MatchfieldSettings matchfield);
}
