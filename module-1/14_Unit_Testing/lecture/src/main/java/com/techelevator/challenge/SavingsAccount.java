package com.techelevator.challenge;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolderName, String accountNumber) {
        this(accountHolderName, accountNumber, BigDecimal.ZERO);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {

        BigDecimal newBalance = getBalance().subtract(amountToWithdraw);

        if (newBalance.compareTo(BigDecimal.valueOf(150)) < 0) {
            amountToWithdraw  = amountToWithdraw.add(BigDecimal.valueOf(2));
        }

        if (getBalance().subtract(amountToWithdraw).compareTo(BigDecimal.ZERO) >= 0) {
            return super.withdraw(amountToWithdraw);
        }

        return getBalance();
    }
}
