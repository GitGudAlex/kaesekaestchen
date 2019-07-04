package dreamTeam;

import dreamTeam.Matchfield.Bonusfield;
import dreamTeam.Matchfield.Field;
import dreamTeam.Matchfield.IField;
import dreamTeam.Matchfield.Minusfield;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FieldTest {

    private IField fieldNormal = new Field(1);
    private IField fieldBonus = new Bonusfield(2);
    private IField fieldMinus = new Minusfield(3);

    @Before
    public void setStateField(){
        fieldNormal.setState(true);
        fieldBonus.setState(false);
    }

    @Test
    public void setState() {
        fieldNormal.setState(false);
        fieldBonus.setState(true);
        Assert.assertFalse(fieldNormal.isState());
        Assert.assertTrue(fieldBonus.isState());
    }

    @Test
    public void isState() {
        Assert.assertTrue(fieldNormal.isState());
        Assert.assertFalse(fieldBonus.isState());
    }

    @Test
    public void getTypeField() {
        Assert.assertEquals("", fieldNormal.getTypeField());
        Assert.assertEquals("+", fieldBonus.getTypeField());
        Assert.assertEquals("-", fieldMinus.getTypeField());
        //false test
        Assert.assertNotEquals("", fieldBonus.getTypeField());
        Assert.assertNotEquals("", fieldMinus.getTypeField());
    }

    @Test
    public void getType() {
        Assert.assertEquals("normal", fieldNormal.getType());
        Assert.assertEquals("bonus", fieldBonus.getType());
        Assert.assertEquals("minus", fieldMinus.getType());
        // false test
        Assert.assertNotEquals("bonus", fieldNormal.getType());
        Assert.assertNotEquals("minus", fieldNormal.getType());
    }
}