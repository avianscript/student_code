package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Tests {

    @Test
    public void givenNum1Or2Less_shouldReturnTrue() {
        Less20 trueScenario = new Less20();
        boolean expected = true;
        boolean result = trueScenario.isLessThanMultipleOf20(59);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenNum3OrMoreLess_shouldReturnFalse() {
        Less20 falseScenario = new Less20();
        boolean expected = false;
        boolean result = falseScenario.isLessThanMultipleOf20(53);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void multipleOf20_shouldReturnFalse() {
        Less20 multOf20 = new Less20();
        boolean expected = false;
        boolean result = multOf20.isLessThanMultipleOf20(60);
        Assert.assertEquals(expected, result);
    }
}
