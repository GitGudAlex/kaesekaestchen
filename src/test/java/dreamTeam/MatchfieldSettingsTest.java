package dreamTeam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchfieldSettingsTest {


    MatchfieldSettings matchfield = new MatchfieldSettings(3,1, false, false, false);
    MatchfieldSettings matchfield2 = new MatchfieldSettings(5,1, false, false, false);

    @Test
    public void generateMatchfield() {
    }

    @Test
    public void checkFieldTop() {
        Assert.assertEquals(2, matchfield.checkFieldTop(5));
        Assert.assertEquals(5, matchfield2.checkFieldTop(10));
        Assert.assertEquals(10, matchfield2.checkFieldTop(15));
        //false testing
        Assert.assertNotEquals(5, matchfield2.checkFieldTop(5));
        Assert.assertNotEquals(10, matchfield.checkFieldTop(11));
    }

    @Test
    public void checkFieldBottom() {
        Assert.assertEquals(1, matchfield.checkFieldBottom(1));
        Assert.assertEquals(5, matchfield.checkFieldBottom(5));
        Assert.assertEquals(-10, matchfield.checkFieldBottom(-10));
        Assert.assertEquals(5, matchfield2.checkFieldBottom(5));
        // false testing
        Assert.assertNotEquals(1, matchfield.checkFieldBottom(3));
        Assert.assertNotEquals(5, matchfield.checkFieldBottom(1000));
    }

    @Test
    public void checkFieldSide() {
        Assert.assertEquals(2, matchfield.checkFieldSide(3,0));
        Assert.assertEquals(3, matchfield.checkFieldSide(3,1));
        Assert.assertEquals(8, matchfield2.checkFieldSide(10,0));
        //false testing
        Assert.assertNotEquals(4, matchfield.checkFieldSide(20,0));
        Assert.assertNotEquals(8, matchfield2.checkFieldSide(-10, 1));
    }

    @Test
    public void getFieldSize() {
        Assert.assertEquals(3, matchfield.getFieldSize());
        Assert.assertEquals(5, matchfield2.getFieldSize());
        // false testing
        Assert.assertNotEquals(4, matchfield.getFieldSize());
    }
}