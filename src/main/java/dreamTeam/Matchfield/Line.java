package dreamTeam.Matchfield;

public class Line {

    private int ali;
    //0=horizontal
    //1=vertikal

    private boolean state;

    public Line(int ali) {
        this.ali = ali;
        this.state = false;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
