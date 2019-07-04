package dreamTeam;

import dreamTeam.Matchfield.Line;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineTest {

    private Line lineHorizontal = new Line(0);
    private Line lineVertical = new Line(1);

    @Before
    public void setStateLine(){
        lineHorizontal.setState(true);
        lineVertical.setState(false);
    }

    @Test
    public void getState() {
        Assert.assertFalse(lineVertical.getState());
        Assert.assertTrue(lineHorizontal.getState());
    }

    @Test
    public void setState() {
        lineVertical.setState(true);
        lineHorizontal.setState(false);
        Assert.assertTrue(lineVertical.getState());
        Assert.assertFalse(lineHorizontal.getState());
    }
}