package com.f5.cuentabancaria;

public class CheckingAccount extends Account {

    protected float overdraft;

    public CheckingAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
    }

}