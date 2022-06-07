package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTests {

    @Test
    public void givenSameFirstAndLast_shouldReturnTrue() {
        SameFirstLast normalSituation = new SameFirstLast();
        boolean expected = true;
        boolean result = normalSituation.isItTheSame(new int[] {12, 4, 12});
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenEmptyArray_shouldReturnFalse() {
        SameFirstLast emptyArray = new SameFirstLast();
        boolean expected = false;
        boolean result = emptyArray.isItTheSame(new int[]{});
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenNull_shouldReturnFalse() {
        SameFirstLast nullArray = new SameFirstLast();
        boolean expected = false;
        boolean result = nullArray.isItTheSame(null);
        Assert.assertEquals(expected, result);
    }
}
