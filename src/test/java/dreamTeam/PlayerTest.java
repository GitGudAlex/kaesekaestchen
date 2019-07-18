package dreamTeam;

import dreamTeam.PlayerManager.Player;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class PlayerTest {

    private Player playerOne = new Player("PlayerOne", Color.red);
    private Player playerTwo = new Player("PlayerTwo", Color.blue);

    @Test
    public void getColor() {
        Assert.assertEquals(Color.red, playerOne.getColor());
        Assert.assertEquals(Color.blue, playerTwo.getColor());
        //false testing
        Assert.assertNotEquals(1, playerOne.getColor());
        Assert.assertNotEquals(false, playerTwo.getColor());
    }

    @Test
    public void getName(){
        Assert.assertEquals("PlayerOne", playerOne.getName());
        Assert.assertEquals("PlayerTwo", playerTwo.getName());
        //false testing
        Assert.assertNotEquals("PlayerThree", playerOne.getName());
    }

}