package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTests {

    @Test
    public void givenBetween40And60NotWeekend_returnsTrue() {
        CigarParty inRange = new CigarParty();
        boolean expected = true;
        boolean result = inRange.haveParty(50, false);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenBetween40And60YesWeekend_returnsTrue() {
        CigarParty inRange = new CigarParty();
        boolean expected = true;
        boolean result = inRange.haveParty(50, true);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenOver60NotWeekend_returnsFalse() {
        CigarParty aboveRange = new CigarParty();
        boolean expected = false;
        boolean result = aboveRange.haveParty(80, false);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenOver60YesWeekend_returnsFalse() {
        CigarParty aboveRange = new CigarParty();
        boolean expected = true;
        boolean result = aboveRange.haveParty(80, true);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenBelow40NotWeekend_returnsFalse() {
        CigarParty underRange = new CigarParty();
        boolean expected = false;
        boolean result = underRange.haveParty(20, false);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenBelow40YesWeekend_returnsFalse() {
        CigarParty underRange = new CigarParty();
        boolean expected = false;
        boolean result = underRange.haveParty(20, true);
        Assert.assertEquals(expected, result);
    }
}
