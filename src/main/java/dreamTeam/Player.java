package dreamTeam;

import java.awt.*;

class Player {

    private int score;
    private String name;
    private Color color;


    Player(String name, Color color) {
        score = 0;
        this.name = name;
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private void addPoints(){

    };

    private void decreasePoints (){

    };

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
