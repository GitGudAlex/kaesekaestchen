package dreamTeam;

import java.awt.*;

class Player {

    int score;
    String name;
    Color color;


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


}
