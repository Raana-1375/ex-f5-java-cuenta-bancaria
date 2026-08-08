package com.f5.cuentabancaria;

public class Account {

    protected float balance;
    protected int depositCount;
    protected int withdrawalCount;
    protected float annualInterestRate;
    protected float monthlyFee;

    public Account(float balance, float annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(float amount) {
        balance += amount;
        depositCount++;
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            withdrawalCount++;
        }
    }

    public void calculateInterest() {
        float monthlyInterest = balance * (annualInterestRate / 100) / 12;
        balance += monthlyInterest;
    }

    public void generateMonthlyStatement() {
        balance -= monthlyFee;
        calculateInterest();
    }
    
}