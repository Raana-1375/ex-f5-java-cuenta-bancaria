package com.f5.cuentabancaria;

public class SavingsAccount extends Account {

    protected boolean active;

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        active = balance >= 10000;
    }

}