package com.techelevator.challenge;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CheckingAccountTests {

    private CheckingAccount account = new CheckingAccount("Yoav", "123456", BigDecimal.valueOf(200));

    @Test
    public void withdraw_valueThatLeavesPositiveBal_shouldReturnCorrectBal() {

        // Arrange
        BigDecimal expected = BigDecimal.valueOf(190);

        // Act
        BigDecimal actual = account.withdraw(BigDecimal.TEN);

        // Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, account.getBalance());

    }

    @Test
    public void withdraw_valueLeavesNegBalAboveThreshold_returnsBalanceWithFee() {

        // Arrange

        // Act
        BigDecimal actual = account.withdraw(BigDecimal.valueOf(220));

        // Assert
        Assert.assertEquals(BigDecimal.valueOf(-30) , actual);
        Assert.assertEquals(BigDecimal.valueOf(-30), account.getBalance());


    }

    @Test
    public void withdraw_valueLeavesNegBalAboveNeg100_returnsBalanceWithFee() {

        // Arrange

        // Act
        BigDecimal actual = account.withdraw(BigDecimal.valueOf(299));

        // Assert
        Assert.assertEquals(BigDecimal.valueOf(-109) , actual);
        Assert.assertEquals(BigDecimal.valueOf(-109), account.getBalance());


    }

    @Test
    public void withdraw_valueLeavesNegBalAtNeg100_returnsOrigBalance() {

        // Arrange
        BigDecimal expected = account.getBalance();

        // Act
        BigDecimal actual = account.withdraw(BigDecimal.valueOf(300));

        // Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, account.getBalance());


    }

    @Test
    public void withdraw_valueLeavesNegBalBelowNeg100_returnsOrigBalance() {

        // Arrange
        BigDecimal expected = account.getBalance();

        // Act
        BigDecimal actual = account.withdraw(BigDecimal.valueOf(301));

        // Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, account.getBalance());



    }

    @Test
    public void withdraw_withNullAmount_returnsOriginalBalance() {

        // Arrange
        BigDecimal expected = account.getBalance();

        // Act
        BigDecimal actual = account.withdraw(null);

        // Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, account.getBalance());
    }


}
