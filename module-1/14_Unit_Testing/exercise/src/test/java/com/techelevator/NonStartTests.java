package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTests {

    @Test
    public void firstLettersMissingString_shouldReturnNewStringNoFirsts() {
        NonStart firstsGone = new NonStart();
        String expected = "morefizzbuzz";
        String result = firstsGone.getPartialString("smore", "pfizzbuzz");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void nullEntry_shouldReturnEmptyString() {
        NonStart nullString = new NonStart();
        String expected = "";
        String result = nullString.getPartialString(null, null);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenEmptyString_shouldReturnEmptyString() {
        NonStart emptyStrings = new NonStart();
        String expected = "";
        String result = emptyStrings.getPartialString("", "");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenOneChar_shouldReturnEmptyString() {
        NonStart oneCharStrings = new NonStart();
        String expected = "";
        String result = oneCharStrings.getPartialString("a", "b");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenMoreThanOneCharForOne_shouldReturnOnlyOneStringCat() {
        NonStart oneCharStrings = new NonStart();
        String expected = "linda";
        String result = oneCharStrings.getPartialString("", "blinda");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenMoreThanOneCharForOne_shouldReturnOnlyOneStringCatB() {
        NonStart oneCharStrings = new NonStart();
        String expected = "lindb";
        String result = oneCharStrings.getPartialString("blindb", "");
        Assert.assertEquals(expected, result);
    }
}
