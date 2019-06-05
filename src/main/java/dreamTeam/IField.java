package dreamTeam;

public interface IField {

    void checkCompleted ();

    void generateField();

    boolean isState();

    void setState(boolean state);
}
