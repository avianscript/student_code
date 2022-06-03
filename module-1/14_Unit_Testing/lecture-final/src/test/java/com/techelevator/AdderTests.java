package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AdderTests {

    @Test
    // addNums_returns_sum_of_instance_variables
    public void addNums_validDataRoundTrue_returnsCorrectValue() {

        // Arrange
        Adder adder = new Adder(5.5, 7.25);
        double expected = 12.0;

        // Act
        double actual = adder.addNums();

        // Assert
        //
        // Note: assertEquals for double is a little different - not great first example :(
        Assert.assertEquals(expected, actual, 0.0);
//        Assert.assertEquals("Invalid result for add with 5.5 and 7.25 with round", expected, actual, 0.0);
    }

    @Test
    // addNums_returns_sum_of_instance_variables
    public void addNums_validDataRoundFalse_returnsCorrectValue() {

        // Arrange
        Adder adder = new Adder(5.5, 7.25, false);
        double expected = 12.75;

        // Act
        double actual = adder.addNums();

        // Assert
        //
        // Note: assertEquals for double is a little different - not great first example :(
        Assert.assertEquals(expected, actual, 0.0);
//        Assert.assertEquals("Invalid result for add with 5.5 and 7.25 with round", expected, actual, 0.0);
    }


}
