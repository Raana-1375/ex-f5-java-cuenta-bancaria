package com.f5.cuentabancaria;

public class CheckingAccount extends Account {

    protected float overdraft;

    public CheckingAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
    }

    @Override
    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            overdraft += amount - balance;
            balance = 0;
        }
        withdrawalCount++;
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount >= overdraft) {
                amount -= overdraft;
                overdraft = 0;
            } else {
                overdraft -= amount;
                amount = 0;
            }
        }
        super.deposit(amount);
    }

}