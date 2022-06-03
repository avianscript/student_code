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
        if (amountToDeposit != null) {
            balance = balance.add(amountToDeposit);
        }
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        if (amountToWithdraw != null) {
            balance = balance.subtract(amountToWithdraw);
        }
        return  balance;
    }

    public BigDecimal transferTo(BankAccount destAccount, BigDecimal amountToTransfer) {

        if (destAccount != null && amountToTransfer != null) {
            if (amountToTransfer.compareTo(BigDecimal.valueOf(500)) <= 0) {

                BigDecimal origBalance = getBalance();
                BigDecimal newBalance = origBalance.subtract(amountToTransfer);

                if (newBalance.compareTo(BigDecimal.ZERO) >= 0) {

                    withdraw(amountToTransfer);
                    destAccount.deposit(amountToTransfer);
                }
            }
        }

        return getBalance();
    }
}
