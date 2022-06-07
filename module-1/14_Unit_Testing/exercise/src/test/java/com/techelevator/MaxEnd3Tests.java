package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Tests {

    @Test
    public void firstIsLarger_shouldReturnAllFirstInt() {
        MaxEnd3 firstInt = new MaxEnd3();
        int[] expected = {12, 12, 12};
        int[] result = firstInt.makeArray(new int[] {12, 2, 3});
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void lastIsLarger_shouldReturnAllLastInt() {
        MaxEnd3 lastInt = new MaxEnd3();
        int[] expected = {13, 13, 13};
        int[] result = lastInt.makeArray(new int[]{12, 2, 13});
        Assert.assertArrayEquals(expected, result);
    }
}
