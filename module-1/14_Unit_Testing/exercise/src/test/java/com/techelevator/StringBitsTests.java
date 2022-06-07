package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTests {

    private StringBits stringBits = new StringBits();

    @Test
    public void getBits_validData_returnsCorrectString() {
        String data = "Hello";
        String expected = "Hlo";

        String actual = stringBits.getBits(data);

        Assert.assertEquals(expected, actual);
    }
}
