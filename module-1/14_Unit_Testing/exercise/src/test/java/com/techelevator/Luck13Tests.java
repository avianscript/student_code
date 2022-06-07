package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Luck13Tests {

    @Test
    public void has1Or3_shouldReturnFalse() {
        Lucky13 falseScenario = new Lucky13();
        boolean expected = false;
        boolean result = falseScenario.getLucky(new int[] {1, 2, 3});
        Assert.assertEquals(expected, result);
    }

    @Test
    public void hasNo1Or3_shouldReturnTrue() {
        Lucky13 falseScenario = new Lucky13();
        boolean expected = true;
        boolean result = falseScenario.getLucky(new int[] {2, 4, 7});
        Assert.assertEquals(expected, result);
    }
}
