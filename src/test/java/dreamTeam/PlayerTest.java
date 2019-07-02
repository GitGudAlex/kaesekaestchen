package dreamTeam;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class PlayerTest {

    Player playerOne = new Player("PlayerOne", Color.red);
    Player playerTwo = new Player("PlayerTwo", Color.blue);

    @Test
    public void setLabel() {
    }

    @Test
    public void addPoints() {
    }

    @Test
    public void getColor() {
        Assert.assertEquals(Color.red, playerOne.getColor());
        Assert.assertEquals(Color.blue, playerTwo.getColor());
        //false testing
        Assert.assertNotEquals(Color.blue, playerOne.getColor());
        Assert.assertNotEquals(Color.green, playerTwo.getColor());
    }

}