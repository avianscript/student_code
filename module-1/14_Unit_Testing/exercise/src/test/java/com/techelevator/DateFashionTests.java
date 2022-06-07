package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTests {
    @Test
    public void givenAbove8And2_shouldReturn2() {
        DateFashion fashionableEnough = new DateFashion();
        int expected = 2;
        int result = fashionableEnough.getATable(8, 5);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenAbove8AndBelow3_shouldReturn0() {
        DateFashion fashionableEnough = new DateFashion();
        int expected = 0;
        int result = fashionableEnough.getATable(8, 2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenBelow8AndBelow8_bothAbove2_shouldReturn1() {
        DateFashion fashionableEnough = new DateFashion();
        int expected = 1;
        int result = fashionableEnough.getATable(5, 5);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenBelow8AndBelow2_shouldReturn0() {
        DateFashion fashionableEnough = new DateFashion();
        int expected = 0;
        int result = fashionableEnough.getATable(5, 2);
        Assert.assertEquals(expected, result);
    }

    }
