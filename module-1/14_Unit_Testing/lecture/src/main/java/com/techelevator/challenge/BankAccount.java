package com.techelevator.challenge;

import java.math.BigDecimal;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount(String accountHolderName, String accountNumber) {
        this(accountHolderName, accountNumber, BigDecimal.ZERO);
    }

    public BankAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal deposit(BigDecimal amountToDeposit) {
        balance = balance.add(amountToDeposit);
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        balance = balance.subtract(amountToWithdraw);
        return  balance;
    }
}
