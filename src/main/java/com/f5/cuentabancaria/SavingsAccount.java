package com.f5.cuentabancaria;

public class SavingsAccount extends Account {

    protected boolean active;

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        active = balance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (active) {
            super.deposit(amount);
        }
    }

    @Override
    public void withdraw(float amount) {
        if (active) {
            super.withdraw(amount);
        }
    }

    @Override
    public void generateMonthlyStatement() {
        if (withdrawalCount > 4) {
            monthlyFee = (withdrawalCount - 4) * 1000;
        } else {
            monthlyFee = 0;
        }
        super.generateMonthlyStatement();
        active = balance >= 10000;
    }

    @Override
    public String toString() {
        int transactionCount = depositCount + withdrawalCount;
        return "Balance: " + balance +
                ", Monthly fee: " + monthlyFee +
                ", Transactions: " + transactionCount;
    }
}