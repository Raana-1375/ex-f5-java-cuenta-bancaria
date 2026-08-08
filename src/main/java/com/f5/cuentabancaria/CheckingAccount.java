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
    
}