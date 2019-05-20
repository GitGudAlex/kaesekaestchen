package dreamTeam;

public class Line {

    int xCoord;
    int yCoord;
    int ali;
    //0=horizontal
    //1=vertikal

    boolean state;

    public Line(int xCoord, int yCoord, int ali) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.ali = ali;
        this.state = false;
    }

    private void generateLine (){

    };

    private void setLine (){

    };

    private void checkLine () {

    };

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
