package dreamTeam;

public class Line {

    private int xCoord;
    private int yCoord;
    private int ali;
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

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getAli() {
        return ali;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
