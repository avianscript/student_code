package com.techelevator.challenge;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber) {
        this(accountHolderName, accountNumber, BigDecimal.ZERO);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        if (amountToWithdraw != null) {
            BigDecimal newBalance = getBalance().subtract(amountToWithdraw);
            if (newBalance.compareTo(BigDecimal.valueOf(-100)) > 0) {
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                    amountToWithdraw = amountToWithdraw.add(BigDecimal.TEN);
                }
                return super.withdraw(amountToWithdraw);
            }
        }
        return getBalance();
    }
}
