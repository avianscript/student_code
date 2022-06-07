package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTests {

    @Test
    public void givenStringOver3CharsLong_ShouldReplicateNTimes() {
        FrontTimes normalSituation = new FrontTimes();
        String expected = "TacTacTacTac";
        String result = normalSituation.generateString("Tacos", 4);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenStringShorterThan3CharsLong_ShouldReplicateNTimes() {
        FrontTimes lessChars = new FrontTimes();
        String expected = "GoGoGoGoGo";
        String result = lessChars.generateString("Go", 5);
        Assert.assertEquals(expected, result);
    }
}
