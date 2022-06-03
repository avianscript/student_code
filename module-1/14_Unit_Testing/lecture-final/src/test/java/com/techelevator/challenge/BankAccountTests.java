package com.techelevator.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTests {

    private BankAccount account = new BankAccount("Yoav", "123456");


    @Before
    public void setUp() {
        // just to demo @Before (could have done this when creating instance varriable)
        account.deposit(BigDecimal.valueOf(25));
    }


    @Test
    public void constrctr_validDataNoBalance_hasCorrectData() {

        // Arrange
        String expectedName = "Yoav";
        String expectAcctNumber = "123456";
        BigDecimal expectedBalance = BigDecimal.ZERO;

        // Act
        BankAccount account = new BankAccount("Yoav", "123456");

        // Assert
        Assert.assertNotNull(account);
        Assert.assertEquals(expectedName, account.getAccountHolderName());
        Assert.assertEquals(expectAcctNumber, account.getAccountNumber());
        Assert.assertEquals(expectedBalance, account.getBalance());



    }

    @Test
    public void constrctr_validDataWithBalance_hasCorrectData() {

        // Arrange
        String expectedName = "Yoav";
        String expectAcctNumber = "123456";
        BigDecimal expectedBalance = BigDecimal.valueOf(25);

        // Act
//        BankAccount account = new BankAccount("Yoav", "123456", BigDecimal.valueOf(25));

        // Assert
        Assert.assertNotNull(account);
        Assert.assertEquals(expectedName, account.getAccountHolderName());
        Assert.assertEquals(expectAcctNumber, account.getAccountNumber());
        Assert.assertEquals(expectedBalance, account.getBalance());



    }

    @Test
    public void deposit_withValidData_returnsCorrectBalance() {

        // Arrange
//        BankAccount account = new BankAccount("Yoav", "123456", BigDecimal.valueOf(25));
        BigDecimal expected = BigDecimal.valueOf(75);

        // Act
        BigDecimal actual = account.deposit(BigDecimal.valueOf(50));
        BigDecimal actualBalance = account.getBalance();

        // Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actualBalance);



    }

    @Test
    public void deposit_withNullAmount_returnsOrginalBalance() {

        // Arrange
//        BankAccount account = new BankAccount("Yoav", "123456", BigDecimal.valueOf(25));
        BigDecimal expected = BigDecimal.valueOf(25);

        // Act
        BigDecimal actual = account.deposit(null);
        BigDecimal actualBalance = account.getBalance();

        // Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actualBalance);

    }

    @Test
    public void withdraw_validData_returnsCorrectBalance() {

        // Arrange (not needed)

        // Act
        BigDecimal actual = account.withdraw(BigDecimal.TEN);

        // Assert
        Assert.assertEquals(BigDecimal.valueOf(15), actual);

    }

    @Test
    public void withdraw_withNullAmount_returnsOrginalBalance() {

        // Arrange
        BigDecimal expected = BigDecimal.valueOf(25);

        // Act
        BigDecimal actual = account.withdraw(null);
        BigDecimal actualBalance = account.getBalance();

        // Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actualBalance);

    }

    @Test
    public void transferTo_amountLessThan500LeavesPosBal_shouldReturnCorrectBalances() {

        // Arrange
        BankAccount bankAccount = new BankAccount("Yoav", "123456", BigDecimal.valueOf(200));
        BankAccount destinationAccount = new BankAccount("Jim", "89202");

        // Act
        BigDecimal actual = bankAccount.transferTo(destinationAccount, BigDecimal.valueOf(50));

        // Assert
        Assert.assertEquals(BigDecimal.valueOf(150), actual);
        Assert.assertEquals(BigDecimal.valueOf(150), bankAccount.getBalance());
        Assert.assertEquals(BigDecimal.valueOf(50), destinationAccount.getBalance());


    }

    @Test
    public void transferTo_withNullDestAccount_shouldReturnOrigBalances() {

        // Arrange
        BankAccount bankAccount = new BankAccount("Yoav", "123456", BigDecimal.valueOf(200));
        BigDecimal expoected = bankAccount.getBalance();

        // Act
        BigDecimal actual = bankAccount.transferTo(null, BigDecimal.valueOf(50));

        // Assert
        Assert.assertEquals(expoected, actual);
        Assert.assertEquals(expoected, bankAccount.getBalance());


    }

    @Test
    public void transferTo_withNullAmount_shouldReturnOrigBalances() {

        // Arrange
        BankAccount bankAccount = new BankAccount("Yoav", "123456", BigDecimal.valueOf(200));
        BankAccount destinationAccount = new BankAccount("Jim", "89202");
        BigDecimal expoected = bankAccount.getBalance();

        // Act
        BigDecimal actual = bankAccount.transferTo(destinationAccount, null);

        // Assert
        Assert.assertEquals(expoected, actual);
        Assert.assertEquals(expoected, bankAccount.getBalance());


    }

    @Test
    public void transferTo_withAmountAt500_shouldReturnCorrectBalances() {

        // Arrange
        BankAccount bankAccount = new BankAccount("Yoav", "123456", BigDecimal.valueOf(700));
        BankAccount destinationAccount = new BankAccount("Jim", "89202");
        BigDecimal acct1expected = BigDecimal.valueOf(200);
        BigDecimal acct2expected = BigDecimal.valueOf(500);

        // Act
        BigDecimal actual = bankAccount.transferTo(destinationAccount, BigDecimal.valueOf(500));

        // Assert
        Assert.assertEquals(acct1expected, actual);
        Assert.assertEquals(acct1expected, bankAccount.getBalance());
        Assert.assertEquals(acct2expected, destinationAccount.getBalance());


    }

    @Test
    public void transferTo_withAmountMoreThan500_shouldReturnOrigBalances() {

        // Arrange
        BankAccount bankAccount = new BankAccount("Yoav", "123456", BigDecimal.valueOf(700));
        BankAccount destinationAccount = new BankAccount("Jim", "89202");
        BigDecimal acct1expected = bankAccount.getBalance();
        BigDecimal acct2expected = destinationAccount.getBalance();

        // Act
        BigDecimal actual = bankAccount.transferTo(destinationAccount, BigDecimal.valueOf(501));

        // Assert
        Assert.assertEquals(acct1expected, actual);
        Assert.assertEquals(acct1expected, bankAccount.getBalance());
        Assert.assertEquals(acct2expected, destinationAccount.getBalance());


    }

    @Test
    public void transferTo_leavesZeroBal_shouldReturnCorrectBalances() {

        // Arrange
        BankAccount bankAccount = new BankAccount("Yoav", "123456", BigDecimal.valueOf(200));
        BankAccount destinationAccount = new BankAccount("Jim", "89202");

        // Act
        BigDecimal actual = bankAccount.transferTo(destinationAccount, BigDecimal.valueOf(200));

        // Assert
        Assert.assertEquals(BigDecimal.ZERO, actual);
        Assert.assertEquals(BigDecimal.ZERO,  bankAccount.getBalance());
        Assert.assertEquals(BigDecimal.valueOf(200), destinationAccount.getBalance());


    }

    @Test
    public void transferTo_leavesNegBal_shouldReturnOrigBalances() {

        // Arrange
        BankAccount bankAccount = new BankAccount("Yoav", "123456", BigDecimal.valueOf(200));
        BankAccount destinationAccount = new BankAccount("Jim", "89202");
        BigDecimal expectedAcct1 = bankAccount.getBalance();
        BigDecimal expectedAcct2 = destinationAccount.getBalance();

        // Act
        BigDecimal actual = bankAccount.transferTo(destinationAccount, BigDecimal.valueOf(201));

        // Assert
        Assert.assertEquals(expectedAcct1, actual);
        Assert.assertEquals(expectedAcct1,  bankAccount.getBalance());
        Assert.assertEquals(expectedAcct2, destinationAccount.getBalance());


    }



}
