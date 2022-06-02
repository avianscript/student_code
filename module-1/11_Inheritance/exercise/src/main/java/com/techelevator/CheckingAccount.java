package com.techelevator;

public class CheckingAccount extends BankAccount {


    public CheckingAccount(String accountHolderName, String accountNumber) {
//        accountHolderName = getAccountHolderName();
//        accountNumber = getAccountNumber();
        super(accountHolderName, accountNumber);
      //  this(accountHolderName, accountNumber, 0)

    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
//        accountHolderName = getAccountHolderName();
//        accountNumber = getAccountNumber();
//        balance = getBalance();
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int newBalance = getBalance() - amountToWithdraw;
        if (newBalance > -100) {
            if (newBalance < 0) {
                amountToWithdraw += 10;
            }
                    return super.withdraw(amountToWithdraw);
                }
        return getBalance();
            }
        }




